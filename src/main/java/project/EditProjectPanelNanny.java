package project;
import java.util.UUID;

import dao.Blackboard;
import dao.Project;

import javax.swing.*;

/**
 * dao.Project Panel Nanny
 *
 * @author Owen Sam
 * @version 1.0
 *
 */
public class EditProjectPanelNanny {

	private static JFrame main;
	
	public EditProjectPanelNanny(JFrame m) {
		main = m;
	}
	
	public static void editScreen(Project project) {
		EditProjectPanel edit = new EditProjectPanel(project);
		main.setContentPane(edit);
		main.revalidate();
		main.repaint();
	}
	
	public static void close() {
		defaultScreen();
	}
	
	public static void save(Project project, String title, String description) {
		if(project.getId().isEmpty()){
			project.setId(UUID.randomUUID().toString());
			Blackboard.getInstance().addProject(project);
		}
		project.setTitle(title);
		project.setDescription(description);
		defaultScreen();
	}
	
	public static void defaultScreen() {
		ListProjectHomePanel panel = new ListProjectHomePanel(main);
		main.setContentPane(panel);
		main.revalidate();
		main.repaint();
	}
	
	public static void delete(Project project) {
		Blackboard.getInstance().deleteProject(project);
		defaultScreen();
	}

}