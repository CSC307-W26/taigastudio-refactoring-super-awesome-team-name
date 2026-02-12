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

public class BacklogView extends JPanel {
    private BurndownChart chart;
    private BacklogPanel backlogPanel;

    public BacklogView(Backlog backlog, SwitchWindow windowSwitcher) {
        setLayout(new BorderLayout());
        if (Blackboard.getInstance().getActiveProject().getActiveSprint() != null) {
            chart = new BurndownChart();
        }else{
            chart = null;
        }
        // Fixed header
        JPanel scrumHeaderWrapper = new JPanel(new BorderLayout());
        scrumHeaderWrapper.add(new JLabel("Scrum"), BorderLayout.WEST);
        add(scrumHeaderWrapper, BorderLayout.NORTH);

        JPanel chartPanel = new JPanel(new BorderLayout());
        chartPanel.add(chart, BorderLayout.CENTER);
        // keep the same size
        chartPanel.setPreferredSize(new Dimension(800, 200));
        chartPanel.setMinimumSize(new Dimension(800, 200));
        chartPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

        // Backlog
        backlogPanel = new BacklogPanel(backlog, windowSwitcher);

        // Scrollable content
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(chartPanel);
        content.add(backlogPanel);

        JScrollPane scroll = new JScrollPane(content);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        add(scroll, BorderLayout.CENTER);
    }

    public BacklogPanel getBacklogPanel() { return backlogPanel; }

    //FOR BACKLOGTEST
    public void setBurndownChart(BurndownChart bdc){ chart = bdc; repaint(); }
}

