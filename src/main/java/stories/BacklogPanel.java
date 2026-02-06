package stories;
/**

 * This class creates the panel which
 * displays the backlog structure
 *
 * @author Nick Grant
 * @version 1.0
 *
 */
import dao.Backlog;
import dao.Story;

import javax.swing.*;
import java.awt.*;

public class BacklogPanel extends JPanel {
    private final Backlog backlog;
    private final JPanel listPanel;
    private final SwitchWindow windowSwitcher;

    public BacklogPanel(Backlog backlog, SwitchWindow windowSwitcher) {
        this.backlog = backlog;
        this.windowSwitcher = windowSwitcher;

        setLayout(new BorderLayout());

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        JScrollPane scroll = new JScrollPane(listPanel);
        add(scroll, BorderLayout.CENTER);

        refresh();
    }

    public void refresh() {
        listPanel.removeAll();
        StoryReorderHandler handler = new StoryReorderHandler(backlog, this);
        listPanel.setTransferHandler(handler);
        for (Story s : backlog.getStories()) {
            StoryRow row = new StoryRow(s, windowSwitcher, handler);
            listPanel.add(row);
        }

        listPanel.revalidate();
        listPanel.repaint();
    }
    public int getDropIndex(Point p) {
        int index = 0;

        for (Component c : listPanel.getComponents()) {
            Rectangle r = c.getBounds();
            if (p.y < r.y + r.height / 2) {
                return index;
            }
            index++;
        }

        return listPanel.getComponentCount();
    }

    public JPanel getListPanel() {
        return listPanel;
    }
}