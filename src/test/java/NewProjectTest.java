import dao.*;
import project.*;

import javax.swing.*;
import java.awt.*;


public class NewProjectTest extends JFrame {

    public static void main(String[] args){

        NewProjectTest main = new NewProjectTest();
        main.setSize(1200, 600);
        main.setTitle("Projects");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    public NewProjectTest(){
        ListProjectPanelMouseNanny mouseNanny = new ListProjectPanelMouseNanny(this);
        EditProjectPanelNanny nanny = new EditProjectPanelNanny(this);
        ListProjectHomePanel home = new ListProjectHomePanel(this);
        add(home, BorderLayout.CENTER);
    }
}