package tasks;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Task;
import dao.UserStory;

/**
 * Panel that displays a list of tasks with edit buttons and a create button for new tasks
 *
 * @author Alexander Bloomer, Collin Howard
 * @version 1.0
 */
public class TaskListPanel extends JPanel {
	
	public TaskListPanel(JFrame main, TaskNanny nanny, UserStory story) {
		List<Task> tasks = story.getTasks();		
		
		setLayout(new GridLayout(tasks.size()+1, 2));
		
		for (int i = 0; i < tasks.size(); i++) {
			Task t = tasks.get(i);
			
			JTextField taskText = new JTextField(t.getSubject() + ": " + t.getBody());
			taskText.setEditable(false);
			
			JButton edit = new JButton("Edit");
			edit.setActionCommand(t.getId());
			edit.addActionListener(e -> nanny.OpenEditTaskPanel(e, story));
			
			add(taskText, BorderLayout.CENTER);
			add(edit, BorderLayout.EAST);
			
		}

		JButton create = new JButton("Create");
		create.addActionListener(e -> nanny.OpenCreateTaskPanel(e, story));
		add(create);
	}
	
}