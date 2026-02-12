package dao;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents a user story
 *
 * @author Collin Howard
 * @version 1.0
 */
public class UserStory implements Comparable<UserStory>{

    private String id;
    private String title;
    private String description;
    private String status;
    private final int priority;

    private int points;

    private List<Task> tasks;

    public UserStory(String title, String description, int points, String status, int priority) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.points = points;
        this.status = status;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getPriority() {
        return priority;
    }

    public void addTask(Task task){
        if(tasks == null){
            tasks = new ArrayList<>();
        }
        tasks.add(task);
    }


    @Override
    public int compareTo(UserStory other) {
        return Integer.compare(this.getPoints(), other.getPoints());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String selectedItem) {
        this.status = selectedItem;
    }
}
