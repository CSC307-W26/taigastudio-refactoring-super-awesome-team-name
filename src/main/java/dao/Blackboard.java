package dao;

import project.ListProjectPanel;
import java.util.LinkedList;

/**
 * This class is storing the stories (treating it sort of like the backlog)
 *
 * @author Jonathan Garcia
 * @version 1.0
 */

public class Blackboard {
	
	private static LinkedList<String> stories = new LinkedList<>();
	
	public static void addStory(String story) {
		stories.add(story);
	}
	
	public static LinkedList<String> getStories() {
		return stories;
	}
	
	public static ListProjectPanel getInstance() {
		return null;
	}
	
	public void addTask(Task task) {
	}
	
	public Task getTask(String id) {
		return null;
	}
	
	public String getTaskCount() {
		return "";
	}
	
	public Task[] getAllTasks() {
		return new Task[0];
	}
	
	public Sprint getActiveSprint() {
		return null;
	}
	
	public void setActiveSprint(Sprint s) {
	}
	
}
