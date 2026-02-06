package stories; /**
 * This class creates a listener to open the frame
 * to create a new story when button is pressed
 *
 * @author Nick Grant
 * @version 1.1
 *
 */

import dao.Backlog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewStoryListener implements ActionListener {
    private final Backlog backlog;
    private final BacklogPanel backlogPanel;
    public NewStoryListener(BacklogPanel backlogPanel, Backlog backlog) {
        this.backlog = backlog;
        this.backlogPanel = backlogPanel;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("+ USER STORY")) {
            NewStoryNanny nanny = new NewStoryNanny(backlog, backlogPanel);
            new StoryCreator(nanny);
            backlogPanel.refresh();
        }

    }
}
