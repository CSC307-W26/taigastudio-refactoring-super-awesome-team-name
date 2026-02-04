package tasks;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Blackboard;
import dao.Task;

/**
 * Panel that displays a list of tasks with edit buttons.
 *
 * @author ALEXANDER BLOOMER
 * @version 1.0
 */
public class TaskListPanel extends JPanel {
	
	public TaskListPanel(JFrame main, EditTaskNanny nanny) {
		Blackboard blackboard = Blackboard.getInstance();
		Collection<Task> taskCollection = blackboard.getAllTasks();
		List<Task> tasks = new ArrayList<>(taskCollection);
		
		
		setLayout(new GridLayout(tasks.size(), 2));
		
		for (int i = 0; i < tasks.size(); i++) {
			Task t = tasks.get(i);
			
			JTextField taskText = new JTextField(t.getSubject() + ": " + t.getBody());
			taskText.setEditable(false);
			
			JButton edit = new JButton("Edit");
			edit.setActionCommand(String.valueOf(i));
			edit.addActionListener(e -> nanny.EditButton(e));
			
			add(taskText, BorderLayout.CENTER);
			add(edit, BorderLayout.EAST);
			
		}
	}
	
}