package dao;

/**
 * This class represents a user story
 *
 * @author Jonathan Garcia
 * @version 2.0
 */

public class Story {

    private final String title;
    private final String description;
    private final int points;
    private final String status;
    private final int priority;

    public Story(String title, String description, int points, String status, int priority) {
        this.title = title;
        this.description = description;
        this.points = points;
        this.status = status;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPoints() {
        return points;
    }

    public String getStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "P" + priority + " | " + title + " (" + points + ") [" + status + "]";
    }
}
