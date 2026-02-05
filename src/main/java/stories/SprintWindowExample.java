package stories; /**
 * This class creates an example window
 * to show window chaning functionality
 *
 * @author Nick Grant
 * @version 1.0
 *
 */
import java.awt.BorderLayout;
import javax.swing.*;

public class SprintWindowExample extends JPanel {
    public SprintWindowExample() {
        this.setLayout(new BorderLayout());
        JPanel SprintWindowHeader = new JPanel(new BorderLayout());
        SprintWindowHeader.add(new JLabel("Sprint"), "West");
        this.add(SprintWindowHeader, "North");
    }
}