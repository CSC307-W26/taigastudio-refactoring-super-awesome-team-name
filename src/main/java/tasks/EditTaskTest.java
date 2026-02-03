package tasks;

import dao.Blackboard;
import dao.Task;

import java.io.IOException;
import javax.swing.JFrame;

/**
 * Test Application for Editing Tasks
 *
 * @author ALEXANDER BLOOMER
 * @version 1.0
 */
public class EditTaskTest extends JFrame {
	EditTaskNanny nanny;
	Blackboard blackboard;
	
	public static void main(String[] arr) throws IOException {
		EditTaskTest app = new EditTaskTest();
		app.setSize(800, 600);
		app.setTitle("Taiga");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setLocationRelativeTo(null);
		app.setResizable(false);
		app.setVisible(true);
	}
	
	public EditTaskTest() throws IOException {
		blackboard = new Blackboard();
		nanny = new EditTaskNanny(this, blackboard);
		blackboard.addTask(new Task("0", "Task1", "Make a GUI"));
		blackboard.addTask(new Task("1", "Task2", "Add event listener"));
		blackboard.addTask(new Task("2", "Task3", "Load existing data"));
		blackboard.addTask(new Task("3", "Task4", "Save new data"));
		blackboard.addTask(new Task("4", "Task5", "idk what to do 1"));
		blackboard.addTask(new Task("5", "Task6", "idk what to do 2"));
		blackboard.addTask(new Task("6", "Task7", "idk what to do 3"));
		blackboard.addTask(new Task("7", "Task8", "idk what to do 4"));
  
		setContentPane(new TaskListPanel(this, nanny, blackboard));
		revalidate();
		repaint();
	}
	
	public void showEdit(String id) {
		setContentPane(new EditTaskPanel(blackboard.getTask(id), nanny, blackboard));
		revalidate();
		repaint();
	}
 
}