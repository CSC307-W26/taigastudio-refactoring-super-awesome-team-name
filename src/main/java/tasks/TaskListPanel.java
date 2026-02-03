package tasks;

import dao.Blackboard;
import dao.Task;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Panel that displays a list of tasks with edit buttons.
 *
 * @author ALEXANDER BLOOMER
 * @version 1.0
 */
public class TaskListPanel extends JPanel {
	
	public TaskListPanel(EditTaskTest main, EditTaskNanny nanny, Blackboard blackboard) {
		Collection<Task> taskCollection = List.of(blackboard.getAllTasks());
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