package stories;

import dao.UserStory;

/**
 * Validates input and creates a Story (does NOT change backlog directly).
 *
 * @author Jonathan Garcia
 * @version 3.0
 */
public class NewStoryNanny {

    public NewStoryResult createStory(String title, String desc, int points, int priority) {
        String t = (title == null) ? "" : title.trim();
        String d = (desc == null) ? "" : desc.trim();

        if (t.isEmpty() || t.equals(NewStoryPanel.SUBJECT_PLACEHOLDER)) {
            return new NewStoryResult(false, "Title is required.", null);
        }

        if (d.isEmpty() || d.equals(NewStoryPanel.DESCRIPTION_PLACEHOLDER)) {
            return new NewStoryResult(false, "Description is required.", null);
        }

        if (points <= 0) {
            return new NewStoryResult(false, "Points must be a positive integer.", null);
        }

        if (priority < 1 || priority > 5) {
            return new NewStoryResult(false, "Priority must be 1–5.", null);
        }

        UserStory s = new UserStory(t, d, points, "New", priority);
        return new NewStoryResult(true, "Story saved successfully!", s);
    }
}
