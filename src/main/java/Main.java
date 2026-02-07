

import project.EditProjectPanelNanny;
import project.ListProjectHomePanel;
import stories.*;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates app window and connects the nanny
 *
 * @author Johnny Parini
 * @version 1.0
 */
public class Main extends JFrame{

	//this breaks the code for now, but will likely be necessary for integration
	//window switching is needed for the backlog and switch code to work
	//therefore this variable and the interface are necessary

	public Main() {
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

//	@Override
//	public void changeWindow(JPanel newWindow) {
//		remove(this.window);
//		window = newWindow;
//
//		//this.setContentPane(new JPanel()); <-- this line might be necessary?? intended to clear everything from main for a hard reset
//		//the line may break the code ngl
//		//or be totally unneccessary
//		//actually i don't think its needed
//		//because ListProjectPanelMouseNanny clears everything anyway
//		//ListProjectPanelMouseNanny needs to execute the below code:
////		JPanel header = new JPanel();
////		ToolBar toolbar = new ToolBar(this);
////		add(toolbar, "West");
////		add(header, "North");
////		add(this.window, "Center");
//		add(this.window, "Center");
//		revalidate();
//		repaint();
//	}

//	public JPanel getWindow() {
//		return window;
//	}
//
//	public void setWindow(JPanel window) {
//		this.window = window;
//	}


}
