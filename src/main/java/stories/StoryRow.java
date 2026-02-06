package stories;
/**
 * This class is the individual panels
 * for each story in the backlog
 *
 * @author Nick Grant
 * @version 1.3
 */
import dao.Story;
import stories.*;

import javax.swing.*;
import java.awt.*;

public class StoryRow extends JPanel {
    private final Story story;
    private final BacklogPanel backlogPanel;
    private final SwitchWindow windowSwitcher;

    public StoryRow(BacklogPanel backlogPanel, Story story,
                    SwitchWindow windowSwitcher, StoryReorderHandler handler) {
        this.story = story;
        this.backlogPanel = backlogPanel;
        this.windowSwitcher = windowSwitcher;
        setLayout(null); // absolute positioning

        setPreferredSize(new Dimension(0, 60));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        JLabel subject = new JLabel(story.getTitle());
        subject.setBounds(10, 25, 200, 20);  // x, y, width, height
        add(subject);

        JLabel points = new JLabel("Points: " + story.getPoints());
        points.setBounds(600, 20, 100, 20);
        add(points);

        JButton details = new JButton("Details");
        details.setBounds(10, 5, 80, 15);
        details.addActionListener(e -> {
            windowSwitcher.changeWindow(new StoryDetailsPanel(story));
        });
        add(details);

        JButton menuBtn = new JButton("⋮");
        menuBtn.setFocusable(false);
        menuBtn.setBorderPainted(false);
        menuBtn.setContentAreaFilled(false);
        menuBtn.setPreferredSize(new Dimension(30, 30));

        // Attach popup menu
        JPopupMenu menu = buildMenu();
        menuBtn.addActionListener(e -> menu.show(menuBtn, 0, menuBtn.getHeight()));
        menuBtn.setBounds(800, 10, 30, 30);
        add(menuBtn);

        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        setTransferHandler(handler);
        addMouseListener(handler.createDragStarter(this));
    }

    private JPopupMenu buildMenu() {
        JPopupMenu menu = new JPopupMenu();

        JMenuItem edit = new JMenuItem("Edit");
        edit.addActionListener(_ -> windowSwitcher.changeWindow(new StoryEditor(story)));
        menu.add(edit);

        JMenuItem delete = new JMenuItem("Delete");
        delete.addActionListener(_ -> {
            backlogPanel.delStory(story);
            backlogPanel.refresh();
        });
        menu.add(delete);

        return menu;
    }

    public Story getStory() {return story;}
}