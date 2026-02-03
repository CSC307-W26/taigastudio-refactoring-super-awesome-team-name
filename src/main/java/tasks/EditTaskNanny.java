package tasks;

import dao.Blackboard;
import dao.Task;

import java.awt.event.ActionEvent;

/**
 * This class is the nanny for tasks.EditTaskTest
 *
 * @author ALEXANDER BLOOMER
 * @version 1.0
 */
public class EditTaskNanny {
 
	private final EditTaskTest main;
	private final Blackboard blackboard;
	
	public EditTaskNanny(EditTaskTest main, Blackboard blackboard) {
		this.main = main;
		this.blackboard = blackboard;
	}
	
	public void SaveButton(Task newTask) {
		blackboard.addTask(newTask);
		main.setContentPane(new TaskListPanel(main, this, blackboard));
		main.revalidate();
		main.repaint();
	}
	
	
	public void EditButton(ActionEvent e) {
		String id = e.getActionCommand();
		main.showEdit(id);
	}
	
	
}