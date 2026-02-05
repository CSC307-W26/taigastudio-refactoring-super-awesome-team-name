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
        backlog.addStory(new Story("Login page", 3, "New", "Create login UI"));
        backlog.addStory(new Story("DB schema", 8, "In Progress", "Build tables + keys"));
        backlog.addStory(new Story("Fix crash", 2, "Ready", "Null pointer in controller"));
        backlog.addStory(new Story("Polish UI", 5, "Done", "Spacing + alignment"));

        app.setTitle("Backlog Test");
        app.setSize(900, 700);
        app.setLayout(new BorderLayout());
        app.add(new JScrollPane(backlog.getStoryList()), BorderLayout.CENTER);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
