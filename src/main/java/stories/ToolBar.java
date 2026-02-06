package stories; /**

 * This class creates toolbar for the main
 * window, showing scrum options
 *
 * @author Nick Grant
 * @version 1.0
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ToolBar extends JPanel {
    public ToolBar(ScrumScreen frame) {
        this.setBackground(new Color(75, 81, 99));
        JLabel title = new JLabel("Taiga Studio");
        title.setForeground(new Color(37, 168, 157));
        this.setLayout(new BorderLayout());
        String[] scrumOptions = new String[]{"Backlog", "Sprint"};
        JComboBox<String> scrum = new JComboBox(scrumOptions);
        ViewListener viewListener = new ViewListener(scrum, frame);
        scrum.addActionListener(viewListener);
        this.add(title, "North");
        this.add(scrum, "Center");
    }
}
