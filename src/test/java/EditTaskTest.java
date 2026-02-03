import java.io.IOException;

import javax.swing.JFrame;

import dao.Blackboard;
import dao.Task;
import tasks.EditTaskNanny;
import tasks.TaskListPanel;

/**
 * Test Application for Editing Tasks
 *
 * @author ALEXANDER BLOOMER
 * @version 1.0
 */
public class EditTaskTest extends JFrame {	
	public static void main(String[] arr) throws IOException {
		EditTaskTest app = new EditTaskTest();
		Blackboard blackboard = Blackboard.getInstance();
		EditTaskNanny nanny = new EditTaskNanny(app);
		blackboard.addTask(new Task("0", "Task1", "Make a GUI"));
		blackboard.addTask(new Task("1", "Task2", "Add event listener"));
		blackboard.addTask(new Task("2", "Task3", "Load existing data"));
		blackboard.addTask(new Task("3", "Task4", "Save new data"));
		blackboard.addTask(new Task("4", "Task5", "idk what to do 1"));
		blackboard.addTask(new Task("5", "Task6", "idk what to do 2"));
		blackboard.addTask(new Task("6", "Task7", "idk what to do 3"));
		blackboard.addTask(new Task("7", "Task8", "idk what to do 4"));
		TaskListPanel taskList = new TaskListPanel(app, nanny);
		app.setSize(800, 600);
		app.setTitle("Taiga");
		app.add(taskList);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setLocationRelativeTo(null);
		app.setResizable(false);
		app.setVisible(true);
	}
 
}