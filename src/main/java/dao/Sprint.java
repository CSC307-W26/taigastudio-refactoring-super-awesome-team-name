package dao;

import java.util.*;

/**
 * This class represents a sprint
 *
 * @author Finley Room
 * @version 1.0
 */
public class Sprint {
	
	private PriorityQueue<UserStory> stories;
	private Map<UserStory, String> designations;
	private Date expiration;
	private Date beginning;
	
	public Sprint (PriorityQueue<UserStory> s, Map<UserStory, String> d, Date exp) {
		stories = s;
		designations = d;
		expiration = exp;
	}
	
	public Sprint(Date exp) {
		stories = new PriorityQueue<UserStory>();
		designations = new HashMap<>() {
		};
		expiration = exp;
	}
	
	public boolean addStory(UserStory story) {
		return stories.add(story);
	}
	
	public void addDesignation(UserStory story, String developer) {
		designations.put(story, developer);
	}
	
	public UserStory nextStory() {
		return stories.peek();
	}
	
	public boolean hasNextStory() {
		return !stories.isEmpty();
	}
	
	public int storyCount() {
		return stories.size();
	}
	
	public boolean removeStory(UserStory story) {
		if (designations.containsKey(story)) designations.remove(story);
		return stories.remove(story);
	}
	
	public boolean containsStory(UserStory story) {
		return stories.contains(story);
	}
	
	public void clearStories() {
		stories.clear();
	}
	
	public void clearDesignations() {
		designations.clear();
	}
	
	public String getDeveloper(UserStory story) {
		return designations.get(story);
	}
	
	public boolean isDesignated(UserStory story) {
		return designations.containsKey(story);
	}
	
	public String removeDesigation(UserStory story) {
		return designations.remove(story);
	}
	
	public void reassign(UserStory story, String newDeveloper) {
		designations.remove(story);
		designations.put(story, newDeveloper);
	}
	
	public Date getExpiration() {
		return expiration;
	}
	
	public boolean isExpired() {
		return new Date().after(expiration);
	}
	
	public int daysRemaining() {
		return 0;
	}
	
	public void extend(Date newExp) {
		expiration = newExp;
	}
	
	public Designation startNextStory() {
		UserStory story = stories.poll();
		if (story == null) return null;
		String developer = designations.get(story);
		return new Designation(developer, story);
	}
	
	public Designation peekNextDesignation() {
		UserStory story = stories.peek();
		String developer = designations.get(story);
		return new Designation(developer, story);
	}
	
	public Designation startStory(UserStory story) {
		stories.remove(story);
		String developer = designations.get(story);
		return new Designation(developer, story);
	}
	
	public List<Designation> startStories(int n) {
		List<UserStory> stories = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			stories.add(this.stories.poll());
		}
		List<Designation> complete = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			complete.add(new Designation(designations.get(stories.get(i)), stories.get(i)));
		}
		return complete;
	}
	
	public Date getBeginning() {
		return beginning;
	}
	
	public void setBeginning(Date beginning) {
		this.beginning = beginning;
	}
	
	public record Designation(String developer, UserStory story) {
	}
}

