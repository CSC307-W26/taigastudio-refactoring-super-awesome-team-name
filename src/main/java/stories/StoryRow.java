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

        int rowWidth = backlogPanel.getWidth();

        JLabel ID = new JLabel("#" + story.getID());
        ID.setForeground(new Color(37, 168, 157));
        ID.setBounds(10, 25, 20, 20);
        add(ID);

        JLabel subject = new JLabel(story.getTitle());
        subject.setBounds(35, 25, 200, 20);
        add(subject);

        JLabel points = new JLabel("Points: " + story.getPoints());
        points.setBounds(rowWidth-130, 20, 50, 20);
        add(points);

        JLabel status = new JLabel(story.getStatus());
        status.setBounds(rowWidth-250, 20, 100, 20);
        add(status);

        JButton details = new JButton("Details");
        details.setBounds(10, 5, 80, 15);
        details.addActionListener(e -> {
            windowSwitcher.changeWindow(new StoryDetailsExample(story));
        });
        add(details);

        JComboBox<String> statusBtn = new JComboBox<>(new String[]{
                "New", "Ready", "In Progress", "Ready to Test", "Done", "Archived"
        });
        statusBtn.setSelectedItem(story.getStatus());
        statusBtn.addActionListener(_ -> {
            story.setStatus((String) statusBtn.getSelectedItem());
        });
        statusBtn.setBounds(rowWidth-270, 18, 110, 30);
        statusBtn.setFocusable(false);
        add(statusBtn);

        JButton menuBtn = new JButton("⋮");
        menuBtn.setFocusable(false);
        menuBtn.setBorderPainted(false);
        menuBtn.setContentAreaFilled(false);
        menuBtn.setPreferredSize(new Dimension(20, 30));

        // Attach popup menu
        JPopupMenu menu = buildMenu();
        menuBtn.addActionListener(e -> menu.show(menuBtn, 0, menuBtn.getHeight()));
        menuBtn.setBounds(rowWidth-60, 12, 30, 30);
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