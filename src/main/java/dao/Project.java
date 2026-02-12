package dao;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This class represents a project
 *
 * @author Owen Sam and Owen Ledrick
 * @version 1.0
 *
 */
public class Project {
   
    private String title;
    private String description;
    private String id;
    private Backlog backlog;

    private Sprint activeSprint;
    private List<Sprint> allSprints;

   
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


    public List<Sprint> getAllSprints() {
        return allSprints;
    }

    public void setAllSprints(List<Sprint> allSprints) {
        this.allSprints = allSprints;
    }

    public Sprint getActiveSprint() {
        if (activeSprint == null){
            Calendar c = Calendar.getInstance();
            Date dt = new Date();
            c.setTime(dt);
            c.add(Calendar.DATE, 14);
            return new Sprint(dt, c.getTime());
        }
        return activeSprint;
    }

    public void setActiveSprint(Sprint activeSprint) {
        this.activeSprint = activeSprint;
    }
}
