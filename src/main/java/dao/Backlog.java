package dao;

import java.util.ArrayList;
import java.util.List;

/**

 * This class creates the backend and visual data structures
 * for the backlog, also has functionally to add story to backlog
 *
 * @author Nick Grant
 * @version 1.1
 *
 */

public class Backlog {
    private final List<Story> stories = new ArrayList<>();

    public void addStory(Story story) {
        stories.add(story);
    }

    public List<Story> getStories() { return stories; }

    public Story get(int index){ return stories.get(index); }
    public int indexOf(Story story){ return stories.indexOf(story); }
    public int size() {
        return stories.size();
    }

    public void moveStory(Story story, int newIndex) {
        int oldIndex = stories.indexOf(story);
        if (oldIndex == -1) return;

        stories.remove(oldIndex);
        stories.add(newIndex, story);
    }

}
