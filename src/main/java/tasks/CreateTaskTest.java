package tasks;

import dao.Blackboard;
import dao.Task;

import javax.swing.*;
import java.awt.*;

/**
 * Create Task Test Application
 *
 * @author Collin Howard
 * @version 1.0
 */
public class CreateTaskTest extends JFrame {
	
	private CreateTaskNanny nanny;
	private Blackboard blackboard;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			CreateTaskTest app = new CreateTaskTest();
			app.setSize(800, 600);
			app.setTitle("Taiga - Create dao.Task");
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setLocationRelativeTo(null);
			app.setResizable(false);
			app.setVisible(true);
		});
	}
	
	public CreateTaskTest() {
		blackboard = new Blackboard();
		nanny = new CreateTaskNanny(this, blackboard);
		
		blackboard.addTask(new Task("0", "Sample dao.Task 1", "This is an existing task"));
		blackboard.addTask(new Task("1", "Sample dao.Task 2", "Another existing task"));
		
		showCreateTaskPanel();
	}
	
	public void showCreateTaskPanel() {
		setContentPane(new CreateTaskPanel(nanny, blackboard));
		revalidate();
		repaint();
	}
	
	public void showTaskList() {
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		listPanel.setBackground(Color.WHITE);
		
		JLabel title = new JLabel("All Tasks (" + blackboard.getTaskCount() + ")", SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));
		title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
		listPanel.add(title, BorderLayout.NORTH);
		
		JPanel tasksPanel = new JPanel();
		tasksPanel.setLayout(new BoxLayout(tasksPanel, BoxLayout.Y_AXIS));
		tasksPanel.setBackground(Color.WHITE);
		tasksPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		
		for (Task task : blackboard.getAllTasks()) {
			JPanel taskRow = new JPanel(new BorderLayout(10, 5));
			taskRow.setBackground(Color.WHITE);
			taskRow.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
			));
			taskRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
			
			JLabel taskLabel = new JLabel("<html><b>" + task.getSubject() + "</b>: " + task.getBody() + "</html>");
			taskRow.add(taskLabel, BorderLayout.CENTER);
			
			tasksPanel.add(taskRow);
			tasksPanel.add(Box.createVerticalStrut(5));
		}
		
		JScrollPane scrollPane = new JScrollPane(tasksPanel);
		scrollPane.setBorder(null);
		listPanel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		JButton createNewButton = new JButton("Create New dao.Task");
		createNewButton.addActionListener(e -> showCreateTaskPanel());
		buttonPanel.add(createNewButton);
		listPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		setContentPane(listPanel);
		revalidate();
		repaint();
	}
}
