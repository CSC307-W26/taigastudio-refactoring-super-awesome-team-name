package stories;

import javax.swing.*;
import java.awt.*;

/**
 * This class builds and displays the new story screen, validates user input when "Create" is clicked, than call the
 * nanny to save the story
 *
 * @author Jonathan Garcia
 * @version 1.0
 */
public class NewStoryPanel extends JPanel {
	
	public NewStoryPanel(NewStoryNanny newStoryNanny) {
		JLabel titleLabel = new JLabel("New user story");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField subjectField = new JTextField("Subject");
		String subjectPlaceholder = "Subject";
		subjectField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				if (subjectField.getText().equals(subjectPlaceholder)) {
					subjectField.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent e) {
				if (subjectField.getText().isEmpty()) {
					subjectField.setText(subjectPlaceholder);
				}
			}
		});
		JButton tagButton = new JButton("Add Tag ➕");
		JTextArea descriptionArea = new JTextArea(
			"Please add descriptive text to help others better understand this user story"
		);
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
		JScrollPane descriptionScroller = new JScrollPane(descriptionArea);
		String descriptionPlaceholder =
			"Please add descriptive text to help others better understand this user story";
		descriptionArea.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				if (descriptionArea.getText().equals(descriptionPlaceholder)) {
					descriptionArea.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent e) {
				if (descriptionArea.getText().isEmpty()) {
					descriptionArea.setText(descriptionPlaceholder);
				}
			}
		});
		JLabel attachmentLabel = new JLabel("0 Attachments");
		JButton attachmentButton = new JButton("Add Attachment");
		JLabel dropZoneLabel = new JLabel("Drop attachments here!");
		String[] status = {"New", "Ready", "In Progress", "Ready to Test", "Done", "Archived"};
		JComboBox<String> statusComboBox = new JComboBox<>(status);
		JLabel locationLabel = new JLabel("LOCATION");
		JRadioButton bottomRadio = new JRadioButton("at the bottom");
		JRadioButton topRadio = new JRadioButton("on top");
		ButtonGroup locationGroup = new ButtonGroup();
		locationGroup.add(bottomRadio);
		locationGroup.add(topRadio);
		JPanel locationRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
		locationRow.add(bottomRadio);
		locationRow.add(topRadio);
		JButton assignButton = new JButton("Assign");
		JButton assignToMeButton = new JButton("Assign to me");
		JPanel assignRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
		assignRow.add(assignButton);
		assignRow.add(assignToMeButton);
		JLabel pointsLabel = new JLabel("POINTS");
		JButton uxButton = new JButton("UX");
		JButton designButton = new JButton("Design");
		JButton frontButton = new JButton("Front");
		JButton backButton = new JButton("Back");
		JLabel errorLabel = new JLabel("");
		JButton createButton = new JButton("CREATE");
		JButton cancelButton = new JButton("✕");
		
		JPanel pointColumn = new JPanel();
		pointColumn.setLayout(new BoxLayout(pointColumn, BoxLayout.Y_AXIS));
		pointColumn.add(shrink(uxButton));
		pointColumn.add(Box.createVerticalStrut(6));
		pointColumn.add(shrink(designButton));
		pointColumn.add(Box.createVerticalStrut(6));
		pointColumn.add(shrink(frontButton));
		pointColumn.add(Box.createVerticalStrut(6));
		pointColumn.add(shrink(backButton));
		
		JLabel storyPointsLabel = new JLabel("Total Points:");
		JTextField storyPointsField = new JTextField();
		storyPointsField.setColumns(3);
		JButton dueDateButton = new JButton("\u23F0");
		JButton teamRequirementButton = new JButton("\uD83D\uDC65");
		JButton clientRequirementButton = new JButton("\uD83D\uDCC1");
		JButton blockButton = new JButton("\uD83D\uDD12");
		
		JPanel miscRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
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
		
		JPanel header = new JPanel(new BorderLayout());
		header.add(titleLabel, BorderLayout.CENTER);
		header.add(cancelButton, BorderLayout.EAST);
		
		JPanel pointsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
		pointsPanel.add(storyPointsLabel);
		pointsPanel.add(storyPointsField);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(12, 12, 12, 12);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		add(header, gbc);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(subjectField, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(statusComboBox, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(shrink(tagButton), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(locationLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(locationRow, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 1;
		add(descriptionScroller, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weighty = 0;
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(assignRow, gbc);
		gbc.gridy = 5;
		add(pointsLabel, gbc);
		gbc.gridy = 6;
		add(pointColumn, gbc);
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		add(pointsPanel, gbc);
		gbc.gridy = 8;
		add(miscRow, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(attachmentLabel, gbc);
		gbc.gridy = 5;
		add(shrink(attachmentButton), gbc);
		gbc.gridy = 6;
		add(dropZoneLabel, gbc);
		gbc.gridy = 10;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		add(createButton, gbc);
		gbc.gridy = 9;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		add(errorLabel, gbc);
		
		createButton.addActionListener(e -> {
			String title = subjectField.getText().trim();
			String desc = descriptionArea.getText().trim();
			String pts = storyPointsField.getText().trim();
			
			if ((title.isEmpty() || title.equals(subjectPlaceholder)) &&
				(desc.isEmpty() || desc.equals(descriptionPlaceholder))) {
				errorLabel.setText("Title and Description are required.");
				return;
			} else if (title.isEmpty() || title.equals(subjectPlaceholder)) {
				errorLabel.setText("Title is required.");
				return;
			} else if (desc.isEmpty() || desc.equals(descriptionPlaceholder)) {
				errorLabel.setText("Description is required.");
				return;
			}
			
			if (pts.isEmpty()) {
				errorLabel.setText("dao.Story Points are required.");
				return;
			}
			
			int points;
			try {
				points = Integer.parseInt(pts);
			} catch (NumberFormatException ex) {
				errorLabel.setText("dao.Story Points must be an integer.");
				return;
			}
			
			if (points <= 0) {
				errorLabel.setText("dao.Story Points must be a positive integer.");
				return;
			}
			
			errorLabel.setText(" ");
			newStoryNanny.createStory(title, desc, points);
		});
		
		cancelButton.addActionListener(e ->
			SwingUtilities.getWindowAncestor(this).dispose()
		);
	}
	
	private JPanel shrink(Component c) {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p.add(c);
		return p;
	}
	
	private void makeTransparent(JButton b) {
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
	}
}
