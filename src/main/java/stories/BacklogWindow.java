package stories; /**

 * This class creates the backlog window including
 * a header (with a title and button to add new stories)
 * and a panel for the backlog list
 *
 * @author Nick Grant
 * @version 1.1
 *
 */
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class BacklogWindow extends JPanel {

    public BacklogWindow(BacklogScreen frame) {
        setLayout(new BorderLayout());

        // HEADER
        JPanel backlogHeader = new JPanel(new BorderLayout());
        backlogHeader.add(new JLabel("Backlog"), "West");
        add(backlogHeader, "North");
        // MAIN LIST PANEL
        BacklogPanel backlogPanel = new BacklogPanel(frame.backlog, frame::changeWindow);
        add(backlogPanel, "Center");

        JButton newStoryBtn = new JButton("+ USER STORY");
        newStoryBtn.addActionListener(new NewStoryListener(backlogPanel, frame.backlog));
        backlogHeader.add(newStoryBtn, "East");
    }
}
