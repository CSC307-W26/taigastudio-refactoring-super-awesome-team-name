package stories; /**

 * This class is the individual panels
 * for each story in the backlog
 *
 * @author Nick Grant
 * @version 1.0
 */
import dao.Story;

import javax.swing.*;
import java.awt.*;

public class StoryRow extends JPanel {
    private final Story story;

    public StoryRow(Story story, SwitchWindow windowSwitcher) {
        this.story = story;
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

        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    public Story getStory() {return story;}
}