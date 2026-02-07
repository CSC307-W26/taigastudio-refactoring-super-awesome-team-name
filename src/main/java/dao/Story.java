package dao;

/**
 * This class represents a user story
 *
 * @author Jonathan Garcia
 * @version 3.0
 */

public class Story {

    private final String title;
    private final String description;
    private final int points;
    private String status;
    private final int priority;

    private final int ID;
    private static int countStories = 0;

    public Story(String title, String description, int points, String status, int priority) {
        this.title = title;
        this.description = description;
        this.points = points;
        this.status = status;
        this.priority = priority;
        this.ID = ++countStories;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getPoints() {
        return points;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String s) { status = s; }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "P" + priority + " | " + title + " (" + points + ") [" + status + "]";
    }
}
