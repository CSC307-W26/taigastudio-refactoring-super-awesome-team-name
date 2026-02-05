import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.UUID;

import dao.*;
import project.*;
import stories.Backlog;

/**
 * A main class to test the project list page home
 *
 * @author Johnny Parini
 * @version 1.0
 */

public class ProjectListTest extends JFrame {

    private static final long MILLIS_PER_DAY = 86400000;

    public static void main(String[] args){
        Backlog bl = new Backlog();
        bl.addStory(new Story("Temp", "Desc", 1));
        bl.addStory(new Story("TempNew", "Desc", 1));
        bl.addStory(new Story("TempR", "Desc", 2));
        Blackboard.getInstance().addProject(new Project(UUID.randomUUID().toString(), "Title", "Description", bl));
        ProjectListTest main = new ProjectListTest();
        main.setSize(1470, 600);
        main.setTitle("Projects");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

    }

    public ProjectListTest(){
//        ListProjectPanelMouseNanny mouseNanny = new ListProjectPanelMouseNanny(this);
        EditProjectPanelNanny editNanny = new EditProjectPanelNanny(this);
        ListProjectHomePanel home = new ListProjectHomePanel(this);
        add(home, BorderLayout.CENTER);


    }
}

