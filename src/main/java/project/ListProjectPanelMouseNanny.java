package project;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class listens for mouse events on the ListProjectPanel
 * and handles the transition to the project backlog view when clicked.
 *
 * @author Johnny Parini
 * @version 1.0
 */
public class ListProjectPanelMouseNanny implements MouseListener {
	
	private static JFrame main;
	
	public ListProjectPanelMouseNanny(JFrame main) {
		this.main = main;
	}
	
	//when the project panel is clicked, enter the project backlog
	@Override
	public void mouseClicked(MouseEvent e) {
		ListProjectPanel p = (ListProjectPanel) e.getSource();
		main.setTitle(p.getProject().getTitle());
    // TempBacklogPanel bl = new TempBacklogPanel(p.getProject());
		// main.setContentPane(bl);
		main.revalidate();
		main.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	
	}
 
}
