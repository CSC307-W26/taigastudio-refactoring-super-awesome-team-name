package project;

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
		System.out.println("Button: Close");
		defaultScreen();
	}
	
	public static void save(Project project, String title, String description) {
		Project newProject = new Project(title, description);
		Blackboard.getInstance().deleteProject(project);
		Blackboard.getInstance().addProject(newProject);
		System.out.println("Button: Save");
		//System.out.println("Title: " + dao.Blackboard.getInstance().getProject(title).getTitle());
		//System.out.println("Description: " + dao.Blackboard.getInstance().getProject(title).getDescription());
		System.out.println("dao.Project Data Size: " + Blackboard.getInstance().getAllProjects().size());
		defaultScreen();
	}
	
	public static void defaultScreen() {
		StartingPanel panel = new StartingPanel();
		main.setContentPane(panel);
		main.revalidate();
		main.repaint();
	}
	
	public static void delete(Project project) {
		Blackboard.getInstance().deleteProject(project);
		System.out.println("dao.Project deleted");
		defaultScreen();
	}

}