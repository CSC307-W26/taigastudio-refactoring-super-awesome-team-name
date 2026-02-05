/**
 * This class contains all UI components for the New Story screen.
 *
 * @author Jonathan Garcia
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;

public class NewStoryUI {

    public static final String SUBJECT_PLACEHOLDER = "Subject";
    public static final String DESCRIPTION_PLACEHOLDER =
            "Please add descriptive text to help others better understand this user story";

    public final JLabel titleLabel = new JLabel("New user story", SwingConstants.CENTER);
    public final JButton cancelButton = new JButton("✕");
    public final JPanel header = new JPanel(new BorderLayout());

    public final JTextField subjectField = new JTextField(SUBJECT_PLACEHOLDER);

    public final JButton tagButton = new JButton("Add Tag ➕");
    public final JPanel tagWrap = shrink(tagButton);

    public final JTextArea descriptionArea = new JTextArea(DESCRIPTION_PLACEHOLDER);
    public final JScrollPane descriptionScroller = new JScrollPane(descriptionArea);

    public final JLabel attachmentLabel = new JLabel("0 Attachments");
    public final JButton attachmentButton = new JButton("Add Attachment");
    public final JPanel attachmentWrap = shrink(attachmentButton);
    public final JLabel dropZoneLabel = new JLabel("Drop attachments here!");

    public final JComboBox<String> statusComboBox = new JComboBox<>(new String[]{
            "New", "Ready", "In Progress", "Ready to Test", "Done", "Archived"
    });

    public final JLabel locationLabel = new JLabel("LOCATION");
    public final JRadioButton bottomRadio = new JRadioButton("at the bottom");
    public final JRadioButton topRadio = new JRadioButton("on top");
    public final JPanel locationRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));

    public final JButton assignButton = new JButton("Assign");
    public final JButton assignToMeButton = new JButton("Assign to me");
    public final JPanel assignRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));

    public final JLabel pointsLabel = new JLabel("POINTS");
    public final JButton uxButton = new JButton("UX");
    public final JButton designButton = new JButton("Design");
    public final JButton frontButton = new JButton("Front");
    public final JButton backButton = new JButton("Back");
    public final JPanel pointColumn = new JPanel();

    public final JLabel storyPointsLabel = new JLabel("Total Points:");
    public final JTextField storyPointsField = new JTextField(3);

    public final JLabel priorityLabel = new JLabel("Priority:");
    public final JComboBox<Integer> priorityBox = new JComboBox<>(new Integer[]{1,2,3,4,5});

    public final JPanel pointsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));

    public final JButton dueDateButton = new JButton("\u23F0");
    public final JButton teamRequirementButton = new JButton("\uD83D\uDC65");
    public final JButton clientRequirementButton = new JButton("\uD83D\uDCC1");
    public final JButton blockButton = new JButton("\uD83D\uDD12");
    public final JPanel miscRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));

    public final JLabel errorLabel = new JLabel("");
    public final JButton createButton = new JButton("CREATE");

    public NewStoryUI() {
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

        ButtonGroup locationGroup = new ButtonGroup();
        locationGroup.add(bottomRadio);
        locationGroup.add(topRadio);
        locationRow.add(bottomRadio);
        locationRow.add(topRadio);

        assignRow.add(assignButton);
        assignRow.add(assignToMeButton);

        pointColumn.setLayout(new BoxLayout(pointColumn, BoxLayout.Y_AXIS));
        pointColumn.add(shrink(uxButton));
        pointColumn.add(Box.createVerticalStrut(6));
        pointColumn.add(shrink(designButton));
        pointColumn.add(Box.createVerticalStrut(6));
        pointColumn.add(shrink(frontButton));
        pointColumn.add(Box.createVerticalStrut(6));
        pointColumn.add(shrink(backButton));

        pointsPanel.add(storyPointsLabel);
        pointsPanel.add(storyPointsField);
        pointsPanel.add(priorityLabel);
        pointsPanel.add(priorityBox);

        miscRow.add(dueDateButton);
        miscRow.add(teamRequirementButton);
        miscRow.add(clientRequirementButton);
        miscRow.add(blockButton);

        tagButton.setPreferredSize(new Dimension(120, 30));
        assignButton.setPreferredSize(new Dimension(120, 30));
        assignToMeButton.setPreferredSize(new Dimension(120, 30));
        uxButton.setPreferredSize(new Dimension(300, 32));
        designButton.setPreferredSize(new Dimension(300, 32));
        frontButton.setPreferredSize(new Dimension(300, 32));
        backButton.setPreferredSize(new Dimension(300, 32));
        storyPointsField.setPreferredSize(new Dimension(120, 30));
        attachmentButton.setPreferredSize(new Dimension(160, 30));
        createButton.setPreferredSize(new Dimension(260, 45));
        cancelButton.setPreferredSize(new Dimension(60, 60));
        dueDateButton.setPreferredSize(new Dimension(60, 60));
        teamRequirementButton.setPreferredSize(new Dimension(60, 60));
        clientRequirementButton.setPreferredSize(new Dimension(60, 60));
        blockButton.setPreferredSize(new Dimension(60, 60));

        makeTransparent(cancelButton);
        makeTransparent(tagButton);
        makeTransparent(assignButton);
        makeTransparent(assignToMeButton);

        errorLabel.setForeground(Color.RED);
    }

    public static GridBagConstraints baseGbc() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        return gbc;
    }

    public static void addToGrid(JPanel parent, JComponent c, GridBagConstraints gbc,
                                 int x, int y, int w, int h,
                                 int fill, double wx, double wy, int anchor) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.fill = fill;
        gbc.weightx = wx;
        gbc.weighty = wy;
        gbc.anchor = anchor;
        parent.add(c, gbc);
    }

    public static JPanel shrink(Component c) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        p.add(c);
        return p;
    }

    public static void makeTransparent(JButton b) {
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
    }
}
