package project;
import java.util.UUID;

import dao.Blackboard;
import dao.Project;

import javax.swing.*;

/**
 * dao.Project Panel Nanny
 *
 * @author Owen Sam and Owen Ledrick
 * @version 1.0
 *
 */
public class EditProjectPanelNanny {

	private JFrame main;
	
	public EditProjectPanelNanny(JFrame m) {
		main = m;
	}
	
	public void editScreen(Project project) {
		EditProjectPanel edit = new EditProjectPanel(project, main);
		main.setContentPane(edit);
		main.revalidate();
		main.repaint();
	}
	
	public void close() {
		defaultScreen();
	}
	
	public void save(Project project, String title, String description) {
		if(project.getId().isEmpty()){
			project.setId(UUID.randomUUID().toString());
			Blackboard.getInstance().addProject(project);
		}
		project.setTitle(title);
		project.setDescription(description);
		defaultScreen();
	}
	
	public void defaultScreen() {
		ListProjectHomePanel panel = new ListProjectHomePanel(main);
		main.setContentPane(panel);
		main.revalidate();
		main.repaint();
	}
	
	public void delete(Project project) {
		Blackboard.getInstance().deleteProject(project);
		defaultScreen();
	}

}