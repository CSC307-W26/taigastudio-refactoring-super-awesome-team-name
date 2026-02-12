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
    private int points;
    private List<Task> tasks;
    private int backlogID;

    public UserStory(String title, String description, String status, int points) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.status = status;
        this.points = points;
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

    public void addTask(Task task){
        if(tasks == null){
            tasks = new ArrayList<>();
        }
        tasks.add(task);
    }

    public String getStatus(){ return status; }

    public void setStatus(String status){ this.status = status; }

    public void setBacklogID(int id) { backlogID = id; }

    public int getBacklogID() { return backlogID; }

    @Override
    public int compareTo(UserStory other) {
        return Integer.compare(this.getPoints(), other.getPoints());
    }
}
