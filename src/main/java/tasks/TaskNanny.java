package tasks;

import java.awt.event.ActionEvent;
import java.util.UUID;

import javax.swing.JFrame;

import dao.Task;
import dao.UserStory;

/**
 * This class is the nanny for creating and editing tasks
 *
 * @author Alexander Bloomer, Collin Howard
 * @version 1.0
 */
public class TaskNanny {
 
	private final JFrame main;
	
	public TaskNanny(JFrame main) {
		this.main = main;
	}
	
	public void SaveTaskButton(Task oldTask, String subject, String body, UserStory story) {
		if(subject.equals("")){
			return;
		}
		Task task =  story.getTasks().stream().filter(t -> t.getId().equals(oldTask.getId())).findFirst().orElse(null);
		task.setSubject(subject);
		task.setBody(body);
		main.setContentPane(new TaskListPanel(main, this, story));
		main.revalidate();
		main.repaint();
		for(Task t : story.getTasks()){
			System.out.println(t);
		}
	}
	
	public void CreateTaskButton(String subject, String body, UserStory story) {
		if(subject.equals("")){
			return;
		}
		story.addTask(new Task(UUID.randomUUID().toString(), subject, body));
		main.setContentPane(new TaskListPanel(main, this, story));
		main.revalidate();
		main.repaint();

		for(Task t : story.getTasks()){
			System.out.println(t);
		}
	}
	
	public void OpenEditTaskPanel(ActionEvent e, UserStory story) {
		String id = e.getActionCommand();
		Task task =  story.getTasks().stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
		main.setContentPane(new TaskPanel(task, this, story));
		main.revalidate();
		main.repaint();
		
	}

	public void OpenCreateTaskPanel(ActionEvent e, UserStory story) {
		
		main.setContentPane(new TaskPanel(null, this, story));
		main.revalidate();
		main.repaint();
	}
	
	
}