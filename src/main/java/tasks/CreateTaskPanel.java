package tasks;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Panel for creating a new task with input fields for title and body.
 *
 * @author Collin Howard
 * @version 1.0
 */
public class CreateTaskPanel extends JPanel {
	
	private JTextField titleField;
	private JTextArea bodyArea;
	private JButton createButton;
	private JLabel errorLabel;
	private CreateTaskNanny nanny;
	
	public CreateTaskPanel(CreateTaskNanny nanny) {
		this.nanny = nanny;
		initializePanel();
		add(createTitleLabel(), BorderLayout.NORTH);
		add(createCenterPanel(), BorderLayout.CENTER);
		add(createButtonPanel(), BorderLayout.SOUTH);
		addTitleFieldListeners();
	}
	
	private void initializePanel() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(10, 10));
		setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
	}
	
	private JLabel createTitleLabel() {
		JLabel title = new JLabel("Create New Task", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 28f));
		return title;
	}
	
	private JPanel createCenterPanel() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		centerPanel.add(createTitleInputPanel());
		centerPanel.add(Box.createVerticalStrut(15));
		centerPanel.add(createBodyInputPanel());
		return centerPanel;
	}
	
	private JPanel createTitleInputPanel() {
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
		titlePanel.setBackground(Color.WHITE);
		titlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel titleLabel = new JLabel("Title (required)");
		titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		titleField = new JTextField(20);
		titleField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		titleField.setBorder(new LineBorder(Color.BLUE));
		titleField.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		errorLabel = new JLabel("Title is required");
		errorLabel.setForeground(Color.RED);
		errorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		errorLabel.setVisible(false);
		
		titlePanel.add(titleLabel);
		titlePanel.add(Box.createVerticalStrut(5));
		titlePanel.add(titleField);
		titlePanel.add(Box.createVerticalStrut(3));
		titlePanel.add(errorLabel);
		
		return titlePanel;
	}
	
	private JPanel createBodyInputPanel() {
		JPanel bodyPanel = new JPanel();
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		bodyPanel.setBackground(Color.WHITE);
		bodyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel bodyLabel = new JLabel("Body (optional)");
		bodyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		bodyArea = new JTextArea(5, 20);
		bodyArea.setLineWrap(true);
		bodyArea.setWrapStyleWord(true);
		bodyArea.setBorder(new LineBorder(Color.BLUE));
		
		JScrollPane bodyScroll = new JScrollPane(bodyArea);
		bodyScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
		bodyScroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
		
		bodyPanel.add(bodyLabel);
		bodyPanel.add(Box.createVerticalStrut(5));
		bodyPanel.add(bodyScroll);
		
		return bodyPanel;
	}
	
	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(e -> handleCancelButton());
		
		createButton = new JButton("Create");
		createButton.setEnabled(false);
		createButton.addActionListener(e -> handleCreateButton());
		
		buttonPanel.add(cancelButton);
		buttonPanel.add(createButton);
		return buttonPanel;
	}
	
	private void addTitleFieldListeners() {
		titleField.getDocument().addDocumentListener(new TitleDocumentListener());
		titleField.addFocusListener(new TitleFocusListener());
	}
	
	private void handleCancelButton() {
		nanny.cancelButton();
	}
	
	private void handleCreateButton() {
		if (validateInputs()) {
			nanny.createButton(titleField.getText().trim(), bodyArea.getText().trim());
			clearInputs();
		}
	}
	
	private void updateCreateButtonState() {
		boolean hasTitle = !titleField.getText().trim().isEmpty();
		createButton.setEnabled(hasTitle);
		if (hasTitle) {
			hideError();
		}
	}
	
	private void showError() {
		errorLabel.setVisible(true);
		titleField.setBorder(new LineBorder(Color.RED));
	}
	
	private void hideError() {
		errorLabel.setVisible(false);
		titleField.setBorder(new LineBorder(Color.BLUE));
	}
	
	private boolean validateInputs() {
		if (titleField.getText().trim().isEmpty()) {
			showError();
			return false;
		}
		hideError();
		return true;
	}
	
	private void clearInputs() {
		titleField.setText("");
		bodyArea.setText("");
		hideError();
		createButton.setEnabled(false);
	}
	
	private class TitleDocumentListener implements DocumentListener {
		@Override
		public void insertUpdate(DocumentEvent e) {
			updateCreateButtonState();
		}
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			updateCreateButtonState();
			if (titleField.getText().trim().isEmpty()) {
				showError();
			}
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			updateCreateButtonState();
		}
	}
	
	private class TitleFocusListener extends FocusAdapter {
		@Override
		public void focusLost(FocusEvent e) {
			if (titleField.getText().trim().isEmpty()) {
				showError();
			}
		}
	}
}
