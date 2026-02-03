package project;

import javax.swing.*;
import java.awt.*;

/**
 * Panel for creating a new project
 *
 * @author Owen Ledrick
 * @version 1.0
 */
public class NewProjectPanel extends JPanel {
	
    public NewProjectPanel() {
		JButton close = new JButton();
		JButton save = new JButton();
		close.setText("Close");
		save.setText("Save");
		setLayout(new BorderLayout());
		
		//panel that holds the text fields
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		
		//title
		JPanel field1 = new JPanel();
		field1.setLayout(new BoxLayout(field1, BoxLayout.Y_AXIS));
		JLabel label1 = new JLabel("dao.Project Name");
		JTextField title = new JTextField(20);
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		title.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		field1.add(label1);
		field1.add(title);
		
		//description
		JPanel field2 = new JPanel();
		field2.setLayout(new BoxLayout(field2, BoxLayout.Y_AXIS));
		JLabel label2 = new JLabel("Description");
		JTextField description = new JTextField(20);
		description.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		field2.add(label2);
		field2.add(description);
		
		center.add(field1);
		center.add(field2);
		this.add(center, BorderLayout.CENTER);
		
		//bottom panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(close);
		buttonPanel.add(save);
		close.addActionListener(e -> NewProjectPanelNanny.close());
		save.addActionListener(e -> NewProjectPanelNanny.save(title.getText(), description.getText()));
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
 
}
