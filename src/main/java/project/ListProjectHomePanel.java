package project;

import dao.Blackboard;
import dao.Project;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * dao.Project Home Panel
 *
 * @author Johnny Parini
 * @version 1.0
 */
public class ListProjectHomePanel extends JPanel {
	
	private Collection<Project> projects;
	private JFrame main;
	
	public ListProjectHomePanel(JFrame main) {
		this.main = main;
		this.projects = Blackboard.getInstance().getAllProjects();
		
		this.setLayout(new BorderLayout());
		JPanel projectRows = new JPanel();
		projectRows.setLayout(new BoxLayout(projectRows, BoxLayout.Y_AXIS));
		for (Project project : projects) {
			ListProjectPanel p = new ListProjectPanel(project, new ListProjectPanelMouseNanny(main));
			projectRows.add(p);
		}
		JScrollPane scrollPane = new JScrollPane(projectRows);
		add(scrollPane);
		Panel topPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));
		JButton newProjectButton = new JButton();
		newProjectButton.setText("New dao.Project");
		newProjectButton.addActionListener(e -> EditProjectPanelNanny.editScreen(new Project("","","")));
		topPanel.add(newProjectButton);
		add(topPanel, BorderLayout.NORTH);
	}
	
}
