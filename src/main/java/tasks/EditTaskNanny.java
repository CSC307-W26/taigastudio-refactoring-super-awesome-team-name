package tasks;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import dao.Blackboard;
import dao.Task;

/**
 * This class is the nanny for tasks.EditTaskTest
 *
 * @author ALEXANDER BLOOMER
 * @version 1.0
 */
public class EditTaskNanny {
 
	private final JFrame main;
	
	public EditTaskNanny(JFrame main) {
		this.main = main;
	}
	
	public void SaveButton(Task newTask) {
		Blackboard blackboard = Blackboard.getInstance();
		blackboard.addTask(newTask);
		main.setContentPane(new TaskListPanel(main, this));
		main.revalidate();
		main.repaint();
	}
	
	
	public void EditButton(ActionEvent e) {
		String id = e.getActionCommand();
		Blackboard blackboard = Blackboard.getInstance();
		main.setContentPane(new EditTaskPanel(blackboard.getTask(id), this));
		main.revalidate();
		main.repaint();
	}
	
	
}