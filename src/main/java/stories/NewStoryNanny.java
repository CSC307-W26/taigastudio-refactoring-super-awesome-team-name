package stories;

import dao.Story;

/**
 * This class validate input, saves stories to backlog, and refreshes main window
 *
 * @author Jonathan Garcia
 * @version 2.0
 */

public class NewStoryNanny {
    private StoryCreator newStoryFrame;

    public Result createStory(String title, String desc, int points, int priority) {
        String t = (title == null) ? "" : title.trim();
        String d = (desc == null) ? "" : desc.trim();

        if (t.isEmpty() || t.equals("Subject")) return Result.fail("Title is required.");
        if (d.isEmpty() || d.equals(NewStoryUI.DESCRIPTION_PLACEHOLDER)) return Result.fail("Description is required.");
        if (points <= 0) return Result.fail("Points must be a positive integer.");
        if (priority < 1 || priority > 5) return Result.fail("Priority must be 1–5.");

        Story s = new Story(t, d, points, "New", priority);


        return Result.ok("Story saved successfully!", s);
    }
    public void setFrame(StoryCreator frame){
        newStoryFrame = frame;
    }

    public static class Result {
        private final boolean ok;
        private final String message;
        private final Story story;

        private Result(boolean ok, String message, Story story) {
            this.ok = ok;
            this.message = message;
            this.story = story;
        }

        public static Result ok(String m, Story s) { return new Result(true, m, s); }
        public static Result fail(String m) { return new Result(false, m, null); }

        public boolean isOk() { return ok; }
        public String getMessage() { return message; }
        public Story getStory() { return story; }
    }
}
