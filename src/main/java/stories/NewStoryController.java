package stories;

import dao.Backlog;
import dao.UserStory;

import javax.swing.*;

/**
 * Listener for NewStoryPanel.
 *
 * @author Jonathan Garcia
 * @version 3.0
 */
public class NewStoryListener {

    private final NewStoryPanel ui;
    private final NewStoryNanny nanny;
    private final Backlog backlog;
    private final Runnable onSuccess;
    private final Runnable onCancel;

    public NewStoryListener(NewStoryPanel ui,
                            NewStoryNanny nanny,
                            Backlog backlog,
                            Runnable onSuccess,
                            Runnable onCancel) {

        this.ui = ui;
        this.nanny = nanny;
        this.backlog = backlog;
        this.onSuccess = onSuccess;
        this.onCancel = onCancel;

        connect();
    }

    private void connect() {

        ui.createButton.addActionListener(e -> {

            String title = ui.subjectField.getText();
            String desc = ui.descriptionArea.getText();
            String pts = ui.storyPointsField.getText();

            Integer priObj = (Integer) ui.priorityBox.getSelectedItem();
            int priority = (priObj == null) ? 1 : priObj;

            int points;
            try {
                points = Integer.parseInt(pts.trim());
            } catch (NumberFormatException ex) {
                ui.errorLabel.setText("Story Points must be an integer.");
                return;
            }

            NewStoryResult r = nanny.createStory(title, desc, points, priority);
            if (!r.isOk()) {
                ui.errorLabel.setText(r.getMessage());
                return;
            }

            UserStory created = r.getStory();
            backlog.addStory(created);

            ui.errorLabel.setText(" ");
            JOptionPane.showMessageDialog(ui, r.getMessage());

            clear();
            onSuccess.run();
        });

        ui.cancelButton.addActionListener(e -> onCancel.run());
    }

    private void clear() {
        ui.subjectField.setText(NewStoryPanel.SUBJECT_PLACEHOLDER);
        ui.descriptionArea.setText(NewStoryPanel.DESCRIPTION_PLACEHOLDER);
        ui.storyPointsField.setText("");
        ui.priorityBox.setSelectedIndex(0);
        ui.errorLabel.setText(" ");
    }
}
