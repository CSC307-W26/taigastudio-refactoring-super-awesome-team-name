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
    private Project activeProject;

    private Blackboard() {

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
        return  this.activeProject;
    }


}
