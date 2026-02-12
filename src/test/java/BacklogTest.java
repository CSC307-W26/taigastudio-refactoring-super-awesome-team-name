package test.java;

import dao.*;
import stories.BacklogView;
import stories.BurndownChart;
import stories.ScrumScreen;
import stories.SprintWindowExample;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Test class for Backlog + Story rendering
 *
 * @author Nick Grant
 * @version 1.1
 */
public class BacklogTest extends JFrame {
    private static final long MILLIS_PER_DAY = 86400000;
    private static final Backlog backlog = new Backlog();
    private static final BurndownChart bdc = new BurndownChart();

    static void main(String[] a) {
        BacklogTest app = new BacklogTest();

        ScrumScreen scrumScreen = new ScrumScreen(app, backlog);
        BurndownChartTest();
        BacklogView backlogView = scrumScreen.getWindow();
        backlogView.setBurndownChart(bdc);

        app.setTitle("Backlog Test");
        app.setSize(900, 1400);
        app.setContentPane(scrumScreen);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

        backlog.addStory(new UserStory("Login page", "Create login UI", 3, "New",
                1));
        backlog.addStory(new UserStory("DB schema", "Build tables + keys", 8, "In Progress",
                2));
        backlog.addStory(new UserStory("Fix crash", "Null pointer in controller", 2, "Ready",
                1));
        backlog.addStory(new UserStory("Polish UI", "Spacing + alignment", 5, "Done",
                3));
        backlogView.getBacklogPanel().refresh();

        backlog.deleteStory(backlog.getStories().get(2));
        backlogView.getBacklogPanel().refresh();

        scrumScreen.changeWindow(new SprintWindowExample());
        scrumScreen.changeWindow(new BacklogView(backlog, scrumScreen::changeWindow));


    }

    private static void BurndownChartTest(){
        Blackboard blackboard = Blackboard.getInstance();
        Date start = new Date();
        Date end = new Date(start.getTime() + MILLIS_PER_DAY * 14L);
        Sprint sprint = new Sprint(start, end);



        UserStory story = new UserStory("mystory", "desc", 8, "New", 1);

        sprint.addStory(story);

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

        blackboard.getActiveProject().setBacklog(backlog);

        blackboard.getActiveProject().getBacklog().getStories().add(story);
    }
}
