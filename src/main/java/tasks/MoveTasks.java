package tasks;

import dao.KMTasks;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


/**
 * This class focuses on creating a framework for the tasks where you can move the tasks inside a dao.Story,
 * The class will be making it's own panel where the user can drag and drop various tasks
 * TODO : Make it actually dynamic with creating tasks. Need to start using the blackboard for the work.
 * TODO : More flexibility in code!!!! Things need to be set to some standard
 * TODO : Panels are only able to be moved one by one instead of being able to freely move inside the list. Would want to adjust that
 *
 * @author Kevin Mokarapiromya
 *
 */
public class MoveTasks extends JFrame {
	
	private JPanel tasksPanel;
	private ArrayList<KMTasks> tasksTest = new ArrayList<>();
	
	private int dragIndex = 0;
	
	public MoveTasks() {
		//Current arrayList as a method to test things out. Will need to add things in it so that
		//there is at least a visual for how things should be done/work
		tasksTest.add(new KMTasks("random dao.Task 1"));
		tasksTest.add(new KMTasks("test dao.Task"));
		
		tasksPanel = new JPanel();
		tasksPanel.setLayout(new BoxLayout(tasksPanel, BoxLayout.Y_AXIS));
		
		setTitle("moving task test");
		setSize(300, 300);
		
		JScrollPane scrollPane = new JScrollPane(tasksPanel);
		add(scrollPane);
		
		refreshTasksUI();
	}
	
	/**
	 * method that after any panels have been changed, would refresh all the visuals to reflect changes.
	 * Inside there will also be pieces of code to help update the arrayList.
	 * NOTE: Most likely can put this inside the taskspanels code itself to be a lot easier and clean for code + easier to manipulate.
	 * TODO : figure what I want to do for NOTE and adjust that
	 */
	private void refreshTasksUI() {
		tasksPanel.removeAll();
		for (KMTasks task : tasksTest) {
			KMTasksPanels panel = new KMTasksPanels(task);
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					dragIndex = tasksPanel.getComponentZOrder(panel);
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					dragIndex = 0;
				}
			});
			panel.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					Point mousePoint = SwingUtilities.convertPoint(panel, e.getPoint(), tasksPanel);
					int targetIndex = getTargetIndex(mousePoint.y);
					
					if (targetIndex != -1 && targetIndex != dragIndex) {
						Collections.swap(tasksTest, dragIndex, targetIndex);
						// System.out.println(tasksTest);
						dragIndex = targetIndex;
						//recursive call to update any additional changes.
						refreshTasksUI();
					}
				}
			});
			tasksPanel.add(panel);
		}
		tasksPanel.revalidate();
	}
	
	
	//TODO : Need to fix this up as this whole thing is confusing.
	private int getTargetIndex(int mouseY) {
		for (int i = 0; i < tasksPanel.getComponentCount(); i++) {
			KMTasksPanels panel = (KMTasksPanels) (tasksPanel.getComponent(i));
			Rectangle bounds = panel.getBounds();
			if (mouseY < bounds.y + bounds.height / 2) {
				return i;
			}
		}
		return tasksPanel.getComponentCount();
	}
	
	
	//Code here is just way to show the actual display and everything, will delete eventually.
	// public static void main(String[] args) {
	//     tasks.MoveTasks testShow = new tasks.MoveTasks();
	//     testShow.show();
	// }
}