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
    private String Id;
   
    public Project(String title, String description){
        this.title = title;
        this.description = description;
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

}