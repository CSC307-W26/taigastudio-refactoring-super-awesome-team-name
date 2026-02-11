import dao.*;
import project.*;
import stories.Backlog;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

/**
 * This class is used to test edit project functionality
 *
 * @author Owen Sam
 * @version 1.0
 *
 */
public class EditProjectTest extends JFrame {



    public static void main(String[] args){
        Blackboard.getInstance().addProject(new Project(UUID.randomUUID().toString(), "Title", "Description"));

        EditProjectTest main = new EditProjectTest();
        main.setSize(1200, 600);
        main.setTitle("Projects");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    public EditProjectTest(){
        ListProjectPanelMouseNanny mouseNanny = new ListProjectPanelMouseNanny(this);
        EditProjectPanelNanny nanny = new EditProjectPanelNanny(this);
        ListProjectHomePanel home = new ListProjectHomePanel(this);
        add(home, BorderLayout.CENTER);
    }
}
