package stories;

import dao.UserStory;

/**
 * The result of attempting to create a story, if succesful it contains validation status, message, and the created
 * UserStory
 *
 * @author Jonathan Garcia
 * @version 3.1
 */

public class NewStoryResult {

    private final boolean ok;
    private final String message;
    private final UserStory story;

    public NewStoryResult(boolean ok, String message, UserStory story) {
        this.ok = ok;
        this.message = message;
        this.story = story;
    }

    public boolean isOk() { return ok; }
    public String getMessage() { return message; }
    public UserStory getStory() { return story; }
}
