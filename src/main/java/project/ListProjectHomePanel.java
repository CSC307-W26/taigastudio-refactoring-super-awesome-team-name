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
 * @version 1.1
 */
public class ListProjectHomePanel extends JPanel {


	public ListProjectHomePanel(JFrame main) {
		Collection<Project> projects = Blackboard.getInstance().getAllProjects();
		this.setLayout(new BorderLayout());
		JPanel projectRows = new JPanel();
		projectRows.setLayout(new BoxLayout(projectRows, BoxLayout.Y_AXIS));
		for (Project project : projects) {
			ListProjectPanel p = new ListProjectPanel(project, new ListProjectPanelMouseNanny(main), main);
			projectRows.add(p);
		}
		JScrollPane scrollPane = new JScrollPane(projectRows);
		add(scrollPane);
		Panel topPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));
		JButton newProjectButton = new JButton();
		EditProjectPanelNanny nanny = new EditProjectPanelNanny(main);
		newProjectButton.setText("New Project");
		newProjectButton.addActionListener(e -> nanny.editScreen(new Project("","","")));
		topPanel.add(newProjectButton);
		add(topPanel, BorderLayout.NORTH);
	}
	
}
