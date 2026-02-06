package tasks;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import dao.Blackboard;
import dao.Task;

/**
 * This class is the nanny for tasks.EditTaskTest
 *
 * @author Alexander Bloomer, Collin Howard
 * @version 1.0
 */
public class TaskNanny {
 
	private final JFrame main;
	
	public TaskNanny(JFrame main) {
		this.main = main;
	}
	
	public void SaveTaskButton(Task oldTask, String subject, String body) {
		if(subject.equals("")){
			return;
		}
		Blackboard blackboard = Blackboard.getInstance();
		blackboard.getTask(oldTask.getId()).setSubject(subject);
		blackboard.getTask(oldTask.getId()).setBody(body);
		main.setContentPane(new TaskListPanel(main, this));
		main.revalidate();
		main.repaint();
	}
	
	public void CreateTaskButton(String subject, String body) {
		if(subject.equals("")){
			return;
		}
		Blackboard blackboard = Blackboard.getInstance();
		blackboard.addTask(new Task(String.valueOf(blackboard.getTaskCount()), subject, body));
		main.setContentPane(new TaskListPanel(main, this));
		main.revalidate();
		main.repaint();
	}
	
	
	public void OpenEditTaskPanel(ActionEvent e) {
		String id = e.getActionCommand();
		Blackboard blackboard = Blackboard.getInstance();
		main.setContentPane(new TaskPanel(blackboard.getTask(id), this));
		main.revalidate();
		main.repaint();
	}

	public void OpenCreateTaskPanel(ActionEvent e) {
		
		main.setContentPane(new TaskPanel(null, this));
		main.revalidate();
		main.repaint();
	}
	
	
}