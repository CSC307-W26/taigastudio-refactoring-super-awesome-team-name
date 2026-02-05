package tasks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.Task;

/**
 * Panel for editing an existing task with input fields for subject and body.
 *
 * @author Alexander Bloomer, Collin Howard
 * @version 1.0
 */
public class TaskPanel extends JPanel {
	
	public TaskPanel(Task task, TaskNanny nanny) {
		boolean isCreate = task == null;
		String subjectText = "";
		String bodyText = "";
		if(!isCreate){
			subjectText = task.getSubject();
			bodyText = task.getBody();
		}
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(10, 10));
		
		JLabel title = isCreate ? new JLabel("Create Task", SwingConstants.CENTER) : new JLabel("Edit Task", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 28f));
		
		JPanel center = new JPanel();
		
		JTextField subject;
		subject = new JTextField(subjectText);
		subject.setPreferredSize(new Dimension(0, 20));
		subject.setBorder(new LineBorder(Color.blue));
		
		JTextArea body;
		body = new JTextArea(bodyText);
		body.setLineWrap(true);
		body.setPreferredSize(new Dimension(0, 100));
		body.setBorder(new LineBorder(Color.blue));
		
		JButton saveButton = isCreate ? new JButton("CREATE") : new JButton("SAVE");
		if(isCreate){
			saveButton.addActionListener(e -> nanny.createButton(subject.getText(), body.getText()));
		}
		else{
			saveButton.addActionListener(e -> nanny.SaveButton(new Task(task.getId(), subject.getText(), body.getText())));
		}
		center.setLayout(new BorderLayout(10, 10));
		center.add(subject, BorderLayout.NORTH);
		center.add(body, BorderLayout.CENTER);
		
		add(title, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(saveButton, BorderLayout.SOUTH);
	}
	
}
