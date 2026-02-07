import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.UUID;

import dao.*;
import project.*;
/**
 * A main class to test the project list page home
 *
 * @author Johnny Parini
 * @version 1.0
 */

public class ProjectListTest extends JFrame {


    public ProjectListTest(){

        ListProjectHomePanel home = new ListProjectHomePanel(this);
        add(home, BorderLayout.CENTER);


    }

    public static void main(String[] args){
        ProjectListTest main = new ProjectListTest();
        main.setSize(1470, 600);
        main.setTitle("Projects");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

    }
}

