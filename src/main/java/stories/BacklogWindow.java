package stories;
/**

 * This class creates the backlog window including
 * a header (with a title and button to add new stories)
 * and a panel for the backlog list, and the burndown chart ** @author Nick Grant
 * @version 1.3
 *
 */
import dao.*;

import java.util.Date;
import javax.swing.*;
import java.awt.*;

public class BacklogWindow extends JPanel {
    private BurndownChart chart;


    public BacklogWindow(Backlog backlog, SwitchWindow windowSwitcher) {
        setLayout(new BorderLayout());

        // Fixed header
        JPanel scrumHeaderWrapper = new JPanel(new BorderLayout());
        scrumHeaderWrapper.add(new JLabel("Scrum"), BorderLayout.WEST);
        add(scrumHeaderWrapper, BorderLayout.NORTH);

        // Chart
        BurndownChartTest();

        JPanel chartPanel = new JPanel(new BorderLayout());
        chartPanel.add(chart, BorderLayout.CENTER);
        // keep the same size
        chartPanel.setPreferredSize(new Dimension(800, 200));
        chartPanel.setMinimumSize(new Dimension(800, 200));
        chartPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

        // Backlog
        BacklogPanel backlogPanel = new BacklogPanel(backlog, windowSwitcher);

        // Scrollable content
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(chartPanel);
        content.add(backlogPanel);

        JScrollPane scroll = new JScrollPane(content);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        add(scroll, BorderLayout.CENTER);
    }

    //test burndown chart
    public void BurndownChartTest() {
        final long MILLIS_PER_DAY = 86400000;
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
        Sprint s = new Sprint(new Date(MILLIS_PER_DAY * 14));
        s.setBeginning(new Date(0));
        blackboard.setActiveSprint(s);
        chart = new BurndownChart();
        chart.repaint();
    }
}

