package project;
import javax.swing.*;

/**
 * Starting panel with a button to create a new project, should be changed
 *
 * @author Owen Ledrick
 * @version 1.0
 */
public class StartingPanel extends JPanel {

    public StartingPanel(){
        JButton button = new JButton();
        button.setText("New Project");
        button.addActionListener(e -> NewProjectPanelNanny.newProject());
        add(button);
    }
    
}
