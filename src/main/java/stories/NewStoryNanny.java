package stories;

import dao.Blackboard;

import javax.swing.*;

/**
 * This class validate input, saves stories to backlog, and refreshes main window
 *
 * @author Jonathan Garcia
 * @version 1.0
 */
public class NewStoryNanny {
	private final JFrame main;
	
	private static final String DESCRIPTION_PLACEHOLDER =
		"Please add descriptive text to help others better understand this user story";
	
	public NewStoryNanny(JFrame main) {
		this.main = main;
	}
	
	public void createStory(String subject, String description, int points) {
		String title = (subject == null) ? "" : subject.trim();
		String desc = (description == null) ? "" : description.trim();
		
		if (title.isEmpty() || title.equals("Subject")) {
			System.out.println("Please input a valid subject.");
			return;
		}
		
		if (desc.isEmpty() || desc.equals(DESCRIPTION_PLACEHOLDER)) {
			System.out.println("Please input a valid description.");
			return;
		}
		
		if (points < 0) {
			System.out.println("Please input valid story points.");
			return;
		}
		
		String story = "Title:" + title + " Points:" + points + " Description:" + desc;
		Blackboard.addStory(story);
		
		System.out.println("Saved story: " + story);
		System.out.println("Amount of stories: " + Blackboard.getStories().size());
		
		switchUI();
	}
	
	private void switchUI() {
		main.setTitle("New dao.Story");
		main.revalidate();
		main.repaint();
	}
}
