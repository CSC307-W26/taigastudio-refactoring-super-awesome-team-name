package stories; /**
 * This class creates app window and connects the nanny
 *
 * @author Jonathan Garcia
 * @version 1.0
 */

import javax.swing.*;

public class StoryCreator extends JFrame {
    public StoryCreator(NewStoryNanny nanny) {
        nanny.setFrame(this);
        NewStoryPanel newStoryPanel = new NewStoryPanel(nanny);
        add(newStoryPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setVisible(true);
    }

}