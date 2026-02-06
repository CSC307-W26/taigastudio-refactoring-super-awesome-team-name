package dao;

/**
 * This class represents a project
 *
 * @author Owen Sam
 * @version 1.0
 *
 */
public class Project {
   
    private String title;
    private String description;
    private String id;
    private Backlog backlog;
   
    public Project(String id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
        this.backlog = new Backlog();
    }

    public String getDescription(){
        return description;
    }
   
    public void setDescription(String description){
        this.description = description;
    }
   
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }
}