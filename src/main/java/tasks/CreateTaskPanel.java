package tasks;

import dao.Blackboard;

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
	
	public CreateTaskPanel(CreateTaskNanny nanny, Blackboard blackboard) {
		this.nanny = nanny;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(10, 10));
		setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		
		JLabel title = new JLabel("Create New dao.Task", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 28f));
		add(title, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		
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
		
		centerPanel.add(titlePanel);
		centerPanel.add(Box.createVerticalStrut(15));
		centerPanel.add(bodyPanel);
		
		add(centerPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(e -> nanny.cancelButton());
		
		createButton = new JButton("Create");
		createButton.setEnabled(false);
		createButton.addActionListener(e -> {
			if (validateInputs()) {
				nanny.createButton(titleField.getText().trim(), bodyArea.getText().trim());
				clearInputs();
			}
		});
		
		buttonPanel.add(cancelButton);
		buttonPanel.add(createButton);
		add(buttonPanel, BorderLayout.SOUTH);
		
		titleField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateCreateButtonState();
			}
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateCreateButtonState();
				if (titleField.getText().trim().isEmpty()) {
					errorLabel.setVisible(true);
					titleField.setBorder(new LineBorder(Color.RED));
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateCreateButtonState();
			}
		});
		
		titleField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (titleField.getText().trim().isEmpty()) {
					errorLabel.setVisible(true);
					titleField.setBorder(new LineBorder(Color.RED));
				}
			}
		});
	}
	
	private void updateCreateButtonState() {
		boolean hasTitle = !titleField.getText().trim().isEmpty();
		createButton.setEnabled(hasTitle);
		if (hasTitle) {
			errorLabel.setVisible(false);
			titleField.setBorder(new LineBorder(Color.BLUE));
		}
	}
	
	private boolean validateInputs() {
		if (titleField.getText().trim().isEmpty()) {
			errorLabel.setVisible(true);
			titleField.setBorder(new LineBorder(Color.RED));
			return false;
		}
		errorLabel.setVisible(false);
		titleField.setBorder(new LineBorder(Color.BLUE));
		return true;
	}
	
	private void clearInputs() {
		titleField.setText("");
		bodyArea.setText("");
		errorLabel.setVisible(false);
		titleField.setBorder(new LineBorder(Color.BLUE));
		createButton.setEnabled(false);
	}
 
}