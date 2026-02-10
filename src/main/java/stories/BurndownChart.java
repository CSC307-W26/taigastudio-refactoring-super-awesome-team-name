package stories;

import dao.Blackboard;
import dao.Sprint;
import dao.Task;
import dao.UserStory;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

/**
 * Burndown Chart Panel for TaigaStudio Application
 *
 * @author Isaac-Pruett
 * @version 2026.02.03
 */
public class BurndownChart extends JPanel {
	
	private Sprint currentSprint;
	private static final int POINT_SIZE = 6;
	private int maxPoints;
	private final int sprintLengthDays;
	private static final long MILLIS_PER_DAY = 86400000;
	private final int leftPadding = 70;
	private final int rightPadding = 20;
	private final int topPadding = 20;
	private final int bottomPadding = 70;
	
	public BurndownChart() {
		Blackboard blackboard = Blackboard.getInstance();

		int pts = 0;
		for (UserStory s : blackboard.getAllUserStories()) {
			pts += s.getPoints();
		}
		this.maxPoints = pts;

		this.currentSprint = blackboard.getActiveSprint();
		long end = currentSprint.getExpiration().getTime();
		long start = currentSprint.getBeginning().getTime();
		this.sprintLengthDays = (int) ((end - start) / MILLIS_PER_DAY);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);


		Blackboard blackboard = Blackboard.getInstance();

		int pts = 0;
		for (UserStory s : blackboard.getAllUserStories()) {
			pts += s.getPoints();
		}
		if (pts > 0) {
			this.maxPoints = pts;
		}
		else {
			this.maxPoints = 1;
		}


		Point origin = new Point(this.leftPadding, this.topPadding);
		Dimension dims = this.getSize();
		this.currentSprint = blackboard.getActiveSprint();
		List<dao.Task> allTasks = blackboard.getAllTasks().stream().toList();
		this.drawAxes(g);
		this.drawProjectedLine(origin, g);
		g.setColor(Color.GREEN);
		this.drawCompletionLine(g, allTasks);
	}
	
	private void drawCompletionLine(Graphics g, List<Task> allTasks) {
		Dimension dims = this.getSize();
		int graphWidth = dims.width - this.rightPadding;
		int graphHeight = dims.height - this.bottomPadding;
		int intervalWidth = (graphWidth - leftPadding) / this.sprintLengthDays;
		int intervalHeight = (graphHeight - topPadding) / this.maxPoints;
		for (int i = 0; i < this.sprintLengthDays; i++) {
			int priorCompletedTasks = 0;
			int tasksCompletedToday = 0;
			for (Task task : allTasks) {
				Date today = new Date(this.currentSprint.getBeginning().getTime() + (i) * MILLIS_PER_DAY);
				Date dayBefore = new Date(this.currentSprint.getBeginning().getTime() + (i - 1) * MILLIS_PER_DAY);
				try {
					if (task.getCompletionDate().before(today)) {
						priorCompletedTasks++;
						if (task.getCompletionDate().after(dayBefore) || task.getCompletionDate().compareTo(dayBefore) == 0) {
							tasksCompletedToday++;
						}
					}
				} catch (NullPointerException e) {
					// do nothing, the task is not completed.
				}
			}
			int x = leftPadding + (i * intervalWidth);
			int y = topPadding + (intervalHeight * (priorCompletedTasks - tasksCompletedToday));
			int x2 = x + intervalWidth;
			int y2 = topPadding + (intervalHeight * (priorCompletedTasks));
			
			g.drawLine(x, y, x2, y2);
			g.drawOval(x - (POINT_SIZE / 2), y - (POINT_SIZE / 2), POINT_SIZE, POINT_SIZE);
		}
	}
	
	private void drawProjectedLine(Point origin, Graphics g) {
		Dimension dims = this.getSize();
		int x2 = dims.width - this.rightPadding;
		int y2 = dims.height - this.bottomPadding;
		
		int intervalWidth = (x2 - leftPadding) / this.sprintLengthDays;
		int intervalHeight = (y2 - topPadding) / this.sprintLengthDays;
		
		g.setColor(Color.GRAY);
		
		for (int i = 0; i < this.sprintLengthDays; i++) {
			g.drawLine(leftPadding + (i * intervalWidth), topPadding + (i * intervalHeight), leftPadding + ((i + 1) * intervalWidth), topPadding + ((i + 1) * intervalHeight));
			int x = leftPadding + (i * intervalWidth);
			int y = topPadding + (i * intervalHeight);
			g.drawOval(x - (POINT_SIZE / 2), y - (POINT_SIZE / 2), POINT_SIZE, POINT_SIZE);
		}
	}
	
	private void drawAxes(Graphics g) {
		g.setColor(Color.BLACK);
		Dimension dims = this.getSize();
		// shrink x-axis label font
		g.setFont(new Font("SansSerif", Font.PLAIN, 10));

		g.drawLine(this.leftPadding, this.topPadding, this.leftPadding, dims.height - this.bottomPadding);
		g.drawLine(this.leftPadding, dims.height - this.bottomPadding, dims.width - this.rightPadding, dims.height - this.bottomPadding);
		
		
		int x2 = dims.width - this.rightPadding;
		int y2 = dims.height - this.bottomPadding;
		
		int intervalWidth = (x2 - leftPadding) / this.sprintLengthDays;
		int intervalHeight = (y2 - rightPadding) / this.sprintLengthDays;
		
		
		for (int i = 0; i < this.sprintLengthDays; i++) {
			g.drawLine(leftPadding + (i * intervalWidth), topPadding + (i * intervalHeight), leftPadding + ((i+1) * intervalWidth), topPadding + ((i+1) * intervalHeight));
			int x = leftPadding + (i * intervalWidth);
			int y = topPadding + (i * intervalHeight);
			Date current = this.currentSprint.getBeginning();
			current = new Date(current.getTime() + (MILLIS_PER_DAY * i));
			
			byte[] bytes = current.toString().getBytes();
			
			int fh = g.getFontMetrics().getHeight();
			g.drawBytes(bytes, 0, 10, x - 32, y2 + fh);
		}
	}
	
}
