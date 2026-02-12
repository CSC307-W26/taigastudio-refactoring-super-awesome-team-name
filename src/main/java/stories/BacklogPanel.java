package stories;
/**

 * This class creates the panel which
 * displays the backlog structure
 *
 * @author Nick Grant
 * @version 1.3
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

        JPanel backlogHeader = new JPanel(new BorderLayout());
        backlogHeader.add(new JLabel("Backlog"), "West");
        add(backlogHeader, BorderLayout.NORTH);
        JButton newStoryBtn = getNewStoryBtn(backlog);
        backlogHeader.add(newStoryBtn, "East");

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        add(listPanel, BorderLayout.CENTER);
    }

    private JButton getNewStoryBtn(Backlog backlog) {
        JButton newStoryBtn = new JButton("+ USER STORY");
        newStoryBtn.addActionListener(e -> {
            NewStoryNanny nanny = new NewStoryNanny();
            JFrame f = new JFrame("New Story");
            f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            Runnable onSuccess = () -> {
                refresh();
                f.dispose();
            };
            Runnable onCancel = f::dispose;

            NewStoryPanel panel = new NewStoryPanel();
            NewStoryController.connect(panel, nanny, backlog, onSuccess, onCancel);

            f.setContentPane(panel);
            f.setSize(800, 800);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
        return newStoryBtn;
    }

    public void refresh() {
        listPanel.removeAll();
        StoryReorderHandler handler = new StoryReorderHandler(backlog, this);
        listPanel.setTransferHandler(handler);
        for (Story s : backlog.getStories()) {
            StoryRow row = new StoryRow(this, s, windowSwitcher, handler);
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

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, listPanel.getPreferredSize().height + 50);
    }

    public void delStory(Story s){ backlog.delStory(s); }

}