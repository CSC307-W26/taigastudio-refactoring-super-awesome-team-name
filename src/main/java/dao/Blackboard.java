package dao;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Central shared data model for the TaigaStudio application.
 * FEEL FREE TO MODIFY AS YOU NEED
 *
 * @version 2026.02.11
 * @author Isaac-Pruett
 */
public class Blackboard {

    private static Blackboard instance;
    private Project activeProject;
    private final Map<String, Project> projects;

    private Blackboard() {
        this.projects = new ConcurrentHashMap<>();
    }

    public static Blackboard getInstance() {
        if (instance == null) {
            instance = new Blackboard();
        }
        return instance;
    }

    public void setActiveProject(Project p){
        this.activeProject = p;
    }
    public Project getActiveProject(){
        return this.activeProject;
    }
    public Collection<Project> getAllProjects(){
        return this.projects.values();
    }
    public void addProject(Project p){
        this.projects.put(p.getId(), p);
    }
    public void deleteProject(Project p){
        this.projects.remove(p.getId());
    }

}
