package project;

import dao.Project;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * This class represents a panel that lists a project
 *
 * @author Johnny Parini
 * @version 1.1
 */
public class ListProjectPanel extends JPanel{

    private Project project;

    public ListProjectPanel(Project project, ListProjectPanelMouseNanny mouseNanny, JFrame main){
        this.project = project;

        //establish bounds and color of the panel
        setLayout(new BorderLayout());
        setBackground(new Color(220, 220, 220));
        setBorder(BorderFactory.createEtchedBorder());
        setMinimumSize(new Dimension(100, 130));
        setPreferredSize(new Dimension(1000, 130));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 130));

        //create title and description display
        JLabel title = new JLabel();
        title.setText(project.getTitle());
        JTextPane description = new JTextPane();
        description.setEditable(false);
        description.setText(project.getDescription());
        description.setBackground(new Color(220, 220, 220));
        JScrollPane descWrapper = new JScrollPane(description);
        descWrapper.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        descWrapper.add(description);

        //panel to align text to the left
        JPanel textOrg = new JPanel();
        textOrg.setBackground(new Color(220, 220, 220));
        textOrg.setLayout(new BoxLayout(textOrg, BoxLayout.Y_AXIS));
        textOrg.add(title);
        textOrg.add(description);
        textOrg.setAlignmentX(Component.LEFT_ALIGNMENT);;
        add(textOrg, BorderLayout.WEST);

        //button to edit project
        JButton editButton = new JButton();
        editButton.setText("Edit");
        EditProjectPanelNanny nanny = new EditProjectPanelNanny(main);
        editButton.addActionListener(e -> nanny.editScreen(project));
        add(editButton, BorderLayout.EAST);
        addMouseListener(mouseNanny);
    }

    public Project getProject() {
        return project;
    }


}
