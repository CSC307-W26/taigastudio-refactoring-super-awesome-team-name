package stories; /**

 * This class is the panel that opens
 * to view an individual story
 *
 * @author Nick Grant
 * @version 1.0 - draft
 */
import dao.Story;

import javax.swing.*;
import java.awt.*;

public class StoryDetailsExample extends JPanel {

    public StoryDetailsExample(Story story) {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("ID: " + story.getID()));
        panel.add(new JLabel("Subject: " + story.getTitle()));
        panel.add(new JLabel("Points: " + story.getPoints()));

        add(panel, BorderLayout.CENTER);
    }
}