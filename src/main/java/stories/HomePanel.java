/**
 * This class shows the backlog and provides a button to open the New Story form.
 *
 * @author Jonathan Garcia
 * @version 1.0
 */

import stories.Backlog;
import stories.NewStoryListener;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    public HomePanel(CardLayout cards, JPanel root, Backlog backlog) {
        setLayout(new BorderLayout());

        JButton newStoryBtn = new JButton("+ USER STORY");
        newStoryBtn.setActionCommand("+ USER STORY");

        newStoryBtn.addActionListener(new NewStoryListener(backlog));
        newStoryBtn.addActionListener(e -> cards.show(root, "NEW"));

        add(newStoryBtn, BorderLayout.NORTH);
        add(new JScrollPane(backlog.getStoryList()), BorderLayout.CENTER);
    }
}