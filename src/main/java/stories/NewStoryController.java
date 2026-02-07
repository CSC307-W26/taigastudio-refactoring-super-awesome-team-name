package stories;

import dao.Backlog;

import javax.swing.*;

/**
 * Controller for NewStoryPanel.
 *
 * @author Jonathan Garcia
 * @version 3.0
 */
public class NewStoryController {

    public static void connect(NewStoryPanel ui,
                               NewStoryNanny nanny,
                               Backlog backlog,
                               Runnable onSuccess,
                               Runnable onCancel) {

        ui.createButton.addActionListener(e -> {
            String title = ui.subjectField.getText().trim();
            String desc = ui.descriptionArea.getText().trim();
            String pts = ui.storyPointsField.getText().trim();
            int priority = (Integer) ui.priorityBox.getSelectedItem();

            String err = validate(title, desc, pts);
            if (err != null) {
                ui.errorLabel.setText(err);
                return;
            }

            int points;
            try {
                points = Integer.parseInt(pts);
            } catch (NumberFormatException ex) {
                ui.errorLabel.setText("Story Points must be an integer.");
                return;
            }

            NewStoryNanny.Result r = nanny.createStory(title, desc, points, priority);
            if (!r.isOk()) {
                ui.errorLabel.setText(r.getMessage());
                return;
            }

            backlog.addStory(r.getStory());
            ui.errorLabel.setText(" ");
            JOptionPane.showMessageDialog(ui, r.getMessage());

            clear(ui);
            onSuccess.run();
        });

        ui.cancelButton.addActionListener(e -> onCancel.run());
    }

    private static String validate(String title, String desc, String pts) {
        boolean titleBad = title.isEmpty() || title.equals(NewStoryPanel.SUBJECT_PLACEHOLDER);
        boolean descBad = desc.isEmpty() || desc.equals(NewStoryPanel.DESCRIPTION_PLACEHOLDER);

        if (titleBad && descBad) return "Title and Description are required.";
        if (titleBad) return "Title is required.";
        if (descBad) return "Description is required.";
        if (pts.isEmpty()) return "Story Points are required.";
        return null;
    }

    private static void clear(NewStoryPanel ui) {
        ui.subjectField.setText(NewStoryPanel.SUBJECT_PLACEHOLDER);
        ui.descriptionArea.setText(NewStoryPanel.DESCRIPTION_PLACEHOLDER);
        ui.storyPointsField.setText("");
        ui.priorityBox.setSelectedIndex(0);
        ui.errorLabel.setText(" ");
    }
}
