package tasks;

import dao.KMTasks;

import java.awt.*;
import javax.swing.*;

/**
 * This class is just mostly making the panels themselves.
 * Making separately to make things much more easily accessible and readable
 *
 * @author Kevin Mokarapiromya
 * @version 1.0
 */
public class KMTasksPanels extends JPanel {
	private KMTasks tasks;
	
	public KMTasksPanels(KMTasks tasks) {
		this.tasks = tasks;
		
		JLabel label = new JLabel(tasks.getTaskInfo());
		
		add(label, BorderLayout.EAST);
	}
	
	public KMTasks getTask() {
		return tasks;
	}
	
}