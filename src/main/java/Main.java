

import stories.NewStoryNanny;
import stories.NewStoryPanel;

import javax.swing.*;

/**
 * This class creates app window and connects the nanny
 *
 * @author Jonathan Garcia
 * @version 1.0
 */
public class Main extends JFrame {
	
	public Main() {
		NewStoryNanny newStoryNanny = new NewStoryNanny(this);
		NewStoryPanel newStoryPanel = new NewStoryPanel(newStoryNanny);
		add(newStoryPanel);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(800, 800);
		main.setVisible(true);
	}
}
