

import project.EditProjectPanelNanny;
import project.ListProjectHomePanel;
import stories.NewStoryNanny;
import stories.NewStoryPanel;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates app window and connects the nanny
 *
 * @author Johnny Parini
 * @version 1.0
 */
public class Main extends JFrame {
	
	public Main() {
		EditProjectPanelNanny editNanny = new EditProjectPanelNanny(this);
		ListProjectHomePanel home = new ListProjectHomePanel(this);
		add(home, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {


		Main main = new Main();
		main.setSize(1470, 600);
		main.setTitle("Projects");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
}
