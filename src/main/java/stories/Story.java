public class Story {
    private final String title;
    private final String description;
    private final int points;
    private final int priority;

    public Story(String title, String description, int points, int priority) {
        this.title = title;
        this.description = description;
        this.points = points;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "P" + priority + " | " + title + " (" + points + ")";
    }
}
