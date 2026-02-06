import javax.swing.*;

/**
 * This class handles button actions and connects the UI with the nanny.
 *
 * @author Jonathan Garcia
 * @version 1.0
 */

public class NewStoryController {

    public static void wire(NewStoryUI ui,
                            NewStoryNanny nanny,
                            Runnable onSuccess,
                            Runnable onCancel,
                            JComponent parentForDialogs) {

        ui.createButton.addActionListener(e -> {
            String title = ui.subjectField.getText().trim();
            String desc = ui.descriptionArea.getText().trim();
            String pts = ui.storyPointsField.getText().trim();
            int priority = (Integer) ui.priorityBox.getSelectedItem();

            if ((title.isEmpty() || title.equals(NewStoryUI.SUBJECT_PLACEHOLDER)) &&
                    (desc.isEmpty() || desc.equals(NewStoryUI.DESCRIPTION_PLACEHOLDER))) {
                ui.errorLabel.setText("Title and Description are required.");
                return;
            } else if (title.isEmpty() || title.equals(NewStoryUI.SUBJECT_PLACEHOLDER)) {
                ui.errorLabel.setText("Title is required.");
                return;
            } else if (desc.isEmpty() || desc.equals(NewStoryUI.DESCRIPTION_PLACEHOLDER)) {
                ui.errorLabel.setText("Description is required.");
                return;
            }

            if (pts.isEmpty()) {
                ui.errorLabel.setText("Story Points are required.");
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

            ui.errorLabel.setText(" ");
            JOptionPane.showMessageDialog(parentForDialogs, r.getMessage());
            clear(ui);
            onSuccess.run();
        });

        ui.cancelButton.addActionListener(e -> onCancel.run());
    }

    private static void clear(NewStoryUI ui) {
        ui.subjectField.setText(NewStoryUI.SUBJECT_PLACEHOLDER);
        ui.descriptionArea.setText(NewStoryUI.DESCRIPTION_PLACEHOLDER);
        ui.storyPointsField.setText("");
        ui.priorityBox.setSelectedIndex(0);
    }
}
