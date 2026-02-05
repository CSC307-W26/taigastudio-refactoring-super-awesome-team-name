package stories;

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

        for (Story s : backlog.getStories()) {
            StoryRow row = new StoryRow(s, windowSwitcher);
            row.setTransferHandler(new StoryReorderHandler(backlog, this));
            row.addMouseListener(new DragMouseAdapter());
            row.addMouseMotionListener(new DragMouseAdapter());
            listPanel.add(row);
        }

        listPanel.revalidate();
        listPanel.repaint();
    }
    public int getDropIndex(Point p) {
        for (int i = 0; i < listPanel.getComponentCount(); i++) {
            Rectangle bounds = listPanel.getComponent(i).getBounds();
            if (p.y < bounds.y + bounds.height / 2) {
                return i;
            }
        }
        return listPanel.getComponentCount();
    }
}