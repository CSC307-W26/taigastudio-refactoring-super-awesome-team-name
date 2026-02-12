package dao;

import java.util.ArrayList;
import java.util.List;

/**

 * This class creates the backend and visual data structures
 * for the backlog, also has functionally to add story to backlog
 *
 * @author Nick Grant
 * @version 1.3
 *
 */

public class Backlog {
    private final List<UserStory> stories = new ArrayList<>();
    private int countStories = 0;


    public void addStory(UserStory story) {
        stories.add(story);
        story.setBacklogID(++countStories);
    }
    public void deleteStory(UserStory story) { stories.remove(story); }

    public List<UserStory> getStories() { return stories; }

    public UserStory get(int index){ return stories.get(index); }
    public int indexOf(UserStory story){ return stories.indexOf(story); }
    public int size() {
        return stories.size();
    }

    public void moveStory(UserStory story, int newIndex) {
        int oldIndex = stories.indexOf(story);
        if (oldIndex == -1) return;

        stories.remove(oldIndex);
        stories.add(newIndex, story);
    }

}
