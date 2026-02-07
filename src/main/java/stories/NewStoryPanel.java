package stories;

import javax.swing.*;
import java.awt.*;

/**
 * UI panel for creating a new story.
 *
 * @author Jonathan Garcia
 * @version 3.0
 */
public class NewStoryPanel extends JPanel {

    public static final String SUBJECT_PLACEHOLDER = "Subject";
    public static final String DESCRIPTION_PLACEHOLDER =
            "Please add descriptive text to help others better understand this user story";

    public final JButton createButton = new JButton("CREATE");
    public final JButton cancelButton = new JButton("✕");
    public final JLabel errorLabel = new JLabel("");

    public final JTextField subjectField = new JTextField(SUBJECT_PLACEHOLDER);
    public final JTextArea descriptionArea = new JTextArea(DESCRIPTION_PLACEHOLDER);
    public final JTextField storyPointsField = new JTextField(3);
    public final JComboBox<Integer> priorityBox = new JComboBox<>(new Integer[]{1,2,3,4,5});

    public final JComboBox<String> statusComboBox = new JComboBox<>(new String[]{
            "New", "Ready", "In Progress", "Ready to Test", "Done", "Archived"
    });

    public NewStoryPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = baseGbc();

        JPanel header = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("New user story", SwingConstants.CENTER);
        header.add(titleLabel, BorderLayout.CENTER);
        header.add(cancelButton, BorderLayout.EAST);

        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        subjectField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (subjectField.getText().equals(SUBJECT_PLACEHOLDER)) subjectField.setText("");
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (subjectField.getText().trim().isEmpty()) subjectField.setText(SUBJECT_PLACEHOLDER);
            }
        });

        descriptionArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (descriptionArea.getText().equals(DESCRIPTION_PLACEHOLDER)) descriptionArea.setText("");
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (descriptionArea.getText().trim().isEmpty()) descriptionArea.setText(DESCRIPTION_PLACEHOLDER);
            }
        });

        JPanel pointsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        pointsPanel.add(new JLabel("Total Points:"));
        storyPointsField.setPreferredSize(new Dimension(120, 30));
        pointsPanel.add(storyPointsField);
        pointsPanel.add(new JLabel("Priority:"));
        pointsPanel.add(priorityBox);

        errorLabel.setForeground(Color.RED);
        createButton.setPreferredSize(new Dimension(260, 45));
        cancelButton.setPreferredSize(new Dimension(60, 60));

        addToGrid(this, header, gbc, 0, 0, 2, 1, GridBagConstraints.HORIZONTAL, 1, 0);
        addToGrid(this, subjectField, gbc, 0, 1, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0);
        addToGrid(this, statusComboBox, gbc, 1, 1, 1, 1, GridBagConstraints.HORIZONTAL, 1, 0);
        addToGrid(this, new JScrollPane(descriptionArea), gbc, 0, 2, 2, 1, GridBagConstraints.BOTH, 1, 1);
        addToGrid(this, pointsPanel, gbc, 0, 3, 2, 1, GridBagConstraints.HORIZONTAL, 1, 0);
        addToGrid(this, errorLabel, gbc, 0, 4, 2, 1, GridBagConstraints.HORIZONTAL, 1, 0);
        addToGrid(this, createButton, gbc, 0, 5, 2, 1, GridBagConstraints.HORIZONTAL, 1, 0);
    }

    private static GridBagConstraints baseGbc() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6,6,6,6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;
        return gbc;
    }

    private static void addToGrid(JPanel parent, JComponent c, GridBagConstraints gbc,
                                  int x, int y, int w, int h,
                                  int fill, double wx, double wy) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.fill = fill;
        gbc.weightx = wx;
        gbc.weighty = wy;
        parent.add(c, gbc);
    }
}
