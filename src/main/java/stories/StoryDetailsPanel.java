package stories; /**

 * This class is the panel that opens
 * to view an individual story
 *
 * @author Nick Grant
 * @version 1.0 - draft
 */
import javax.swing.*;
import java.awt.*;

public class StoryDetailsPanel extends JPanel {

    public StoryDetailsPanel(Story story) {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("ID: " + story.getID()));
        panel.add(new JLabel("Subject: " + story.getSubject()));
        panel.add(new JLabel("Points: " + story.getScore()));

        add(panel, BorderLayout.CENTER);
    }
}