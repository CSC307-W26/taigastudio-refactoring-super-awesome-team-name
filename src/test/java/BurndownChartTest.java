import dao.*;
import stories.BurndownChart;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Test class for stories.BurndownChart
 *
 * @author Isaac-Pruett
 * @version 2026.02.11
 */
public class BurndownChartTest extends JFrame {
	
	private static final long MILLIS_PER_DAY = 86400000;
	
	public static void main(String[] a) {
		BurndownChartTest app = new BurndownChartTest();
		Blackboard blackboard = Blackboard.getInstance();



		Date start = new Date();
		Date end = new Date(start.getTime() + MILLIS_PER_DAY * 14L);
		Sprint sprint = new Sprint(start, end);



		UserStory story = new UserStory("mystory", "desc", 1, "status", 1);

		sprint.addStory(story);

		story.setPoints(8);
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task("task1", "blank", "blank"));
		tasks.add(new Task("task2", "blank", "blank"));
		tasks.add(new Task("task3", "blank", "blank"));
		Task task4 = new Task("task4", "blank", "blank");
		task4.setCompletionDate(new Date(start.getTime() + MILLIS_PER_DAY * 2L));
		tasks.add(task4);
		tasks.add(new Task("task5", "blank", "blank"));
		tasks.add(new Task("task6", "blank", "blank"));
		tasks.add(new Task("task7", "blank", "blank"));

		story.setTasks(tasks);


		Project project = new Project(UUID.randomUUID().toString(), "my cool project", "it does the thing");
		project.setActiveSprint(sprint);
		blackboard.setActiveProject(project);

		Backlog backlog = new Backlog();
		blackboard.getActiveProject().setBacklog(backlog);

		blackboard.getActiveProject().getBacklog().getStories().add(story);


		BurndownChart bdc = new BurndownChart();
		app.setTitle("Taiga");
		app.setSize(1470, 600);
		app.add(bdc);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		bdc.repaint();
	}
	
}

