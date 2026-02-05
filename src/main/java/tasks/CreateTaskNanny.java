package tasks;

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
	private final TaskRepository taskRepository;
	
	public CreateTaskNanny(JFrame main, TaskRepository taskRepository) {
		this.main = main;
		this.taskRepository = taskRepository;
	}
	
	public void createButton(String title, String body) {
		String id = String.valueOf(taskRepository.getTaskCount());
		Task newTask = new Task(id, title, body);
		taskRepository.addTask(newTask);
		showSuccessMessage(title);
		showCreateTaskPanel();
	}
	
	public void cancelButton() {
		showTaskListPanel();
	}
	
	public void showCreateTaskPanel() {
		main.setContentPane(new CreateTaskPanel(this));
		main.revalidate();
		main.repaint();
	}
	
	private void showSuccessMessage(String title) {
		JOptionPane.showMessageDialog(main,
			"Task created successfully!\nTitle: " + title,
			"Success",
			JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void showTaskListPanel() {
		if (main instanceof CreateTaskTest) {
			CreateTaskTest testMain = (CreateTaskTest) main;
			testMain.showTaskList();
		}
	}
}
