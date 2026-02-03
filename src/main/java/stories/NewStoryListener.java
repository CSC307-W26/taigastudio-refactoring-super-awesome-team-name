package stories;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a listener for button
 * that adds stories to the backlog
 *
 * @author Nick Grant
 * @version 1.0
 *
 */
public class NewStoryListener implements ActionListener {
	
	private final Backlog backlog;
	
	public NewStoryListener(Backlog backlog) {
		this.backlog = backlog;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("+ USER STORY")) {
			//  backlog.addStory(new dao.Story("hello", 4, "New", "draft"));
		}
	}

}