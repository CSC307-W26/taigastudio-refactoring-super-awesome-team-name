package stories;

import dao.Backlog;

/**
 * This class creates a New Story form and handles user input before sending it to the nanny. 
 *
 * @author Jonathan Garcia
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;

public class NewStoryPanel extends JPanel {

    private final NewStoryNanny nanny;
    private final Runnable onSuccess;
    private final Runnable onCancel;
    private final Backlog backlog;

    private final NewStoryUI ui = new NewStoryUI();

    public NewStoryPanel(NewStoryNanny nanny, Runnable onSuccess, Runnable onCancel, Backlog backlog) {
        this.nanny = nanny;
        this.onSuccess = onSuccess;
        this.onCancel = onCancel;
        this.backlog = backlog;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = NewStoryUI.baseGbc();

        NewStoryUI.addToGrid(this, ui.header, gbc, 0, 0, 2, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.CENTER);

        NewStoryUI.addToGrid(this, ui.subjectField, gbc, 0, 1, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);
        NewStoryUI.addToGrid(this, ui.statusComboBox, gbc, 1, 1, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);

        NewStoryUI.addToGrid(this, ui.tagWrap, gbc, 0, 2, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);
        NewStoryUI.addToGrid(this, ui.locationLabel, gbc, 1, 2, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);

        NewStoryUI.addToGrid(this, ui.descriptionScroller, gbc, 0, 3, 1, 1, GridBagConstraints.BOTH, 1, 1, GridBagConstraints.WEST);
        NewStoryUI.addToGrid(this, ui.locationRow, gbc, 1, 3, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);

        NewStoryUI.addToGrid(this, ui.attachmentLabel, gbc, 0, 4, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);
        NewStoryUI.addToGrid(this, ui.assignRow, gbc, 1, 4, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);

        NewStoryUI.addToGrid(this, ui.attachmentWrap, gbc, 0, 5, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);
        NewStoryUI.addToGrid(this, ui.pointsLabel, gbc, 1, 5, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);

        NewStoryUI.addToGrid(this, ui.dropZoneLabel, gbc, 0, 6, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);
        NewStoryUI.addToGrid(this, ui.pointColumn, gbc, 1, 6, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);

        NewStoryUI.addToGrid(this, ui.pointsPanel, gbc, 1, 7, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);
        NewStoryUI.addToGrid(this, ui.miscRow, gbc, 1, 8, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);

        NewStoryUI.addToGrid(this, ui.errorLabel, gbc, 0, 9, 2, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.WEST);
        NewStoryUI.addToGrid(this, ui.createButton, gbc, 0, 10, 2, 1, GridBagConstraints.HORIZONTAL, 1, 0, GridBagConstraints.CENTER);

        wireActions();
    }

    private void wireActions() {
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

            backlog.addStory(r.getStory());
            ui.errorLabel.setText(" ");
            JOptionPane.showMessageDialog(this, r.getMessage());
            clearForm();
            onSuccess.run();
        });

        ui.cancelButton.addActionListener(e -> onCancel.run());
    }

    private void clearForm() {
        ui.subjectField.setText(NewStoryUI.SUBJECT_PLACEHOLDER);
        ui.descriptionArea.setText(NewStoryUI.DESCRIPTION_PLACEHOLDER);
        ui.storyPointsField.setText("");
        ui.priorityBox.setSelectedIndex(0);
    }
}
