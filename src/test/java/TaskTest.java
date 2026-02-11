import java.io.IOException;

import javax.swing.JFrame;

import dao.Task;
import dao.UserStory;
import tasks.TaskListPanel;
import tasks.TaskNanny;

/**
 * Test Application for Editing Tasks
 *
 * @author Alexander Bloomer, Collin Howard
 * @version 1.0
 */
public class TaskTest extends JFrame {	
	public static void main(String[] arr) throws IOException {
		TaskTest app = new TaskTest();
		TaskNanny nanny = new TaskNanny(app);
		UserStory story = new UserStory("Story 1", "Testing task editor");
        story.addTask(new Task("0", "Task1", "Make a GUI"));
        story.addTask(new Task("1", "Task2", "Add event listener"));
		// blackboard.addTask(new Task("2", "Task3", "Load existing data"));
		// blackboard.addTask(new Task("3", "Task4", "Save new data"));
		// blackboard.addTask(new Task("4", "Task5", "idk what to do 1"));
		// blackboard.addTask(new Task("5", "Task6", "idk what to do 2"));
		// blackboard.addTask(new Task("6", "Task7", "idk what to do 3"));
		// blackboard.addTask(new Task("7", "Task8", "idk what to do 4"));
		TaskListPanel taskList = new TaskListPanel(app, nanny, story);
		app.setSize(800, 600);
		app.setTitle("Taiga");
		app.add(taskList);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setLocationRelativeTo(null);
		app.setResizable(false);
		app.setVisible(true);
	}
 
}