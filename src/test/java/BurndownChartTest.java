import dao.Blackboard;
import dao.Sprint;
import dao.Task;
import dao.UserStory;

import javax.swing.*;
import java.util.Date;

/**
 * Test class for BurndownChart
 *
 * @author Isaac-Pruett
 * @version 2026.02.03
 */
public class BurndownChartTest extends JFrame {
	
	private static final long MILLIS_PER_DAY = 86400000;
	
	public static void main(String[] a) {
		BurndownChartTest app = new BurndownChartTest();
		Blackboard blackboard = Blackboard.getInstance();
		blackboard.addTask(new Task("task1", "blank", "blank"));
		blackboard.addTask(new Task("task2", "blank", "blank"));
		blackboard.addTask(new Task("task3", "blank", "blank"));
		Task task4 = new Task("task4", "blank", "blank");
		task4.setCompletionDate(new Date(MILLIS_PER_DAY * 4));
		blackboard.addTask(task4);
		blackboard.addTask(new Task("task5", "blank", "blank"));
		blackboard.addTask(new Task("task6", "blank", "blank"));
		blackboard.addTask(new Task("task7", "blank", "blank"));


		UserStory st = new UserStory("aaa", "mystory", "desc");
		st.setPoints(8);

		st.setTasks(blackboard.getAllTasks().stream().toList());

		blackboard.addUserStory(st);


		Sprint s = new Sprint(new Date(MILLIS_PER_DAY * 14));
		s.setBeginning(new Date(0));
		blackboard.setActiveSprint(s);
		BurndownChart bdc = new BurndownChart();
		app.setTitle("Taiga");
		app.setSize(1470, 600);
		app.add(bdc);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		bdc.repaint();
	}
	
}

