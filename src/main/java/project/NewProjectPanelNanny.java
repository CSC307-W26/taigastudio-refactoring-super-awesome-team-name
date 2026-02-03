package project;

import dao.Blackboard;
import dao.Project;

import javax.swing.*;

/** Action listeners for the project panel and starting panel
 * @author Owen Ledrick
 */
public class NewProjectPanelNanny {
    private static JFrame main;
    public NewProjectPanelNanny(JFrame m){
        main = m;
    }
    public static void newProject(){
        NewProjectPanel project = new NewProjectPanel();
        main.setContentPane(project);
        main.revalidate();
        main.repaint();
    }
    public static void close(){
        //System.out.println("Button: Close");
        defaultScreen();
    }
    public static void save(String title, String description){
        //System.out.println("Button: Save");
        //System.out.println("Title: " + title);
        //System.out.println("Description: " + description);
        Project project = new Project(title, description);
        Blackboard.getInstance().addProject(project);
        //System.out.println("dao.Project Data Size: " + dao.Blackboard.getInstance().getAllProjects().size());
        defaultScreen();
    }
    public static void defaultScreen(){
        StartingPanel panel = new StartingPanel();
        main.setContentPane(panel);
        main.revalidate();
        main.repaint();
    }
}
