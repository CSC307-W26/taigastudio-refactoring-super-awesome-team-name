package tasks;

import dao.Blackboard;
import dao.Task;

import javax.swing.*;

/**
 * Create Task Panel Nanny
 *
 * @author Collin Howard
 * @version 1.0
 */
public class CreateTaskNanny {
	
	private final JFrame main;
	private final Blackboard blackboard;
	
	public CreateTaskNanny(JFrame main, Blackboard blackboard) {
		this.main = main;
		this.blackboard = blackboard;
	}
	
	public void createButton(String title, String body) {
		String id = String.valueOf(blackboard.getTaskCount());
		
		Task newTask = new Task(id, title, body);
		blackboard.addTask(newTask);
		
		JOptionPane.showMessageDialog(main,
			"dao.Task created successfully!\nTitle: " + title,
			"Success",
			JOptionPane.INFORMATION_MESSAGE);
		
		showCreateTaskPanel();
	}
	
	public void cancelButton() {
		showTaskListPanel();
	}
	
	public void showCreateTaskPanel() {
		main.setContentPane(new CreateTaskPanel(this, blackboard));
		main.revalidate();
		main.repaint();
	}
	
	public void showTaskListPanel() {
		if (main instanceof CreateTaskTest) {
			CreateTaskTest testMain = (CreateTaskTest) main;
			testMain.showTaskList();
		}
	}
	
}
