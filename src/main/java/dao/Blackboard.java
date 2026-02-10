package dao;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Central shared data model for the TaigaStudio application.
 * FEEL FREE TO MODIFY AS YOU NEED
 *
 * @version 2026.02.03
 * @author Isaac-Pruett
 */
public class Blackboard {

    private static Blackboard instance;
    private final Map<String, Project> projects;
    private final Map<String, UserStory> userStories;
    private final Map<String, Task> tasks;
    private Sprint activeSprint;

    private static LinkedList<String> stories = new LinkedList<>();

    public String curEditTaskID = "0";

    private Blackboard() {
        this.projects = new ConcurrentHashMap<>();
        this.userStories = new ConcurrentHashMap<>();
        this.tasks = new ConcurrentHashMap<>();
    }

    public void deleteProject(Project project) {
        projects.remove(project.getId());
    }

    public void addProject(Project project) {
        projects.put(project.getId(), project);
    }

    public Project getProject(String projectId) {
        return projects.get(projectId);
    }

    public Collection<Project> getAllProjects() {
        return projects.values();
    }

    public void addUserStory(UserStory story) {
        userStories.put(story.getId(), story);
    }

    public UserStory getUserStory(String storyId) {
        return userStories.get(storyId);
    }

    public Collection<UserStory> getAllUserStories() {
        return userStories.values();
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }

    public Collection<Task> getAllTasks() {
        return tasks.values();
    }

    public synchronized void setActiveSprint(Sprint sprint) {
        this.activeSprint = sprint;
    }

    public Sprint getActiveSprint() {
        return activeSprint;
    }

    public int getProjectCount() {
        return projects.size();
    }

    public int getStoryCount() {
        return userStories.size();
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public static Blackboard getInstance() {
        if (instance == null) {
            instance = new Blackboard();
        }
        return instance;
    }

    public static void addStory(String story) {
        stories.add(story);
    }

    public static LinkedList<String> getStories() {
        return stories;
    }
}
