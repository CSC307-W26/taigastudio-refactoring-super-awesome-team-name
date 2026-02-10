package project;

import dao.Project;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the panel for editing a project
 *
 * @author Owen Sam and Owen Ledrick
 * @version 1.0
 *
 */
public class EditProjectPanel extends JPanel {
	
	public EditProjectPanel(Project project, JFrame main) {
		EditProjectPanelNanny nanny = new EditProjectPanelNanny(main);
		JButton close = new JButton();
		JButton save = new JButton();
		JButton delete = new JButton();
		close.setText("Close");
		save.setText("Save");
		delete.setText("Delete");
		setLayout(new BorderLayout());
		
		//panel that holds the text fields
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		
		//title
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
		JLabel titleLabel = new JLabel("Project Name");
		JTextField title = new JTextField(20);
		title.setText(project.getTitle());
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		title.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		titlePanel.add(titleLabel);
		titlePanel.add(title);
		
		//description
		JPanel descriptionPanel = new JPanel();
		descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
		JLabel descriptionLabel = new JLabel("Description");
		JTextField description = new JTextField(20);
		description.setText(project.getDescription());
		description.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		descriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		descriptionPanel.add(descriptionLabel);
		descriptionPanel.add(description);
		
		center.add(titlePanel);
		center.add(descriptionPanel);
		this.add(center, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(close);
		buttonPanel.add(save);
		if(!project.getTitle().isEmpty() || !project.getDescription().isEmpty()){
			buttonPanel.add(delete);
			delete.addActionListener(e -> nanny.delete(project));
		}
		close.addActionListener(e -> nanny.close());
		save.addActionListener(e -> nanny.save(project, title.getText(), description.getText()));
		this.add(buttonPanel, BorderLayout.SOUTH);
	}

}