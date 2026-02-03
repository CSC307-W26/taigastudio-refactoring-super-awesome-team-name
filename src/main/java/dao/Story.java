package dao;

/**
 * This class represents a user story
 *
 * @author Jonathan Garcia
 * @version 1.0
 */
public class Story {
	
	private String subject;
	private String description;
	private int score;
	
	public Story(String subject, String description, int score) {
		this.subject = subject;
		this.description = description;
		this.score = score;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean getStoryAttribute(String id) {
		return false;
	}

}
