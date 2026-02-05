/**
 * This interface defines methods for storing and getting stories.
 *
 * @author Jonathan Garcia
 * @version 1.0
 */

import java.util.List;

public interface StoryStore {
    void addStory(Story s);
    List<Story> getStories();
}
