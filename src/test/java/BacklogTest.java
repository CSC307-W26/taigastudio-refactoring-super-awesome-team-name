import dao.Story;
import stories.Backlog;

import javax.swing.*;
import java.awt.*;

/**
 * Test class for Backlog + Story rendering
 *
 * @author Jonathan Garcia
 * @version 2026.02.04
 */
public class BacklogTest extends JFrame {

    public static void main(String[] a) {
        BacklogTest app = new BacklogTest();

        Backlog backlog = new Backlog();
        backlog.addStory(new Story("Login page", "Create login UI", 3, "New",
                1));
        backlog.addStory(new Story("DB schema", "Build tables + keys", 8, "In Progress",
                2));
        backlog.addStory(new Story("Fix crash", "Null pointer in controller", 2, "Ready",
                1));
        backlog.addStory(new Story("Polish UI", "Spacing + alignment", 5, "Done",
                3));

        app.setTitle("Backlog Test");
        app.setSize(900, 700);
        app.setLayout(new BorderLayout());
        app.add(new JScrollPane(backlog.getStoryList()), BorderLayout.CENTER);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
