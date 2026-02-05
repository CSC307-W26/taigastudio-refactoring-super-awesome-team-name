package stories;

import dao.Story;

import java.util.ArrayList;
import java.util.List;

/**

 * This class creates the backend and visual data structures
 * for the backlog, also has functionally to add story to backlog
 *
 * @author Nick Grant
 * @version 1.0
 *
 */

public class Backlog {
    private final List<Story> stories = new ArrayList<>();

    public void addStory(Story story) {
        stories.add(story);
    }

    public List<Story> getStories() {
        return stories;
    }

    public int getBacklogSize() {
        return stories.size();
    }

    public void moveStory(Story story, int newIndex) {
        stories.remove(story);
        stories.add(newIndex, story);
    }
}
