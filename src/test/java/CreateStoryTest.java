import dao.Backlog;
import dao.UserStory;
import stories.NewStoryNanny;
import stories.NewStoryResult;

import javax.swing.*;
import java.awt.*;

/**
 * Tests that stories can be created correctly and added to the backlog. Also checks invalid inputs.
 * Story info is printed in the terminal.
 *
 * @author Jonathan Garcia
 * @version 2.0
 */
public class CreateStoryTest extends JFrame {

    public static void main(String[] args) {
        CreateStoryTest app = new CreateStoryTest();

        Backlog backlog = new Backlog();
        NewStoryNanny nanny = new NewStoryNanny();

        // --- invalid cases ---
        NewStoryResult r1 = nanny.createStory("", "desc", 5, 3);
        printResult("missing title", r1);

        NewStoryResult r2 = nanny.createStory("title", "", 5, 3);
        printResult("missing description", r2);

        NewStoryResult r3 = nanny.createStory("title", "desc", 0, 3);
        printResult("bad points", r3);

        NewStoryResult r4 = nanny.createStory("title", "desc", 5, 6);
        printResult("bad priority", r4);

        // --- valid case ---
        NewStoryResult r5 = nanny.createStory("Login", "User can log in", 8, 2);
        printResult("success", r5);

        if (r5.isOk() && r5.getStory() != null) {
            UserStory created = r5.getStory();
            backlog.addStory(created);
        }

        // --- UI output ---
        app.setTitle("CreateStoryTest (Jonathan)");
        app.setSize(650, 320);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea out = new JTextArea();
        out.setEditable(false);
        out.setFont(new Font("Monospaced", Font.PLAIN, 14));

        out.append("Backlog size: " + backlog.size() + "\n\n");

        if (backlog.size() > 0) {
            UserStory s = backlog.get(0);
            out.append("First story:\n");
            out.append("  ID:       " + s.getId() + "\n");
            out.append("  Title:    " + s.getTitle() + "\n");
            out.append("  Desc:     " + s.getDescription() + "\n");
            out.append("  Points:   " + s.getPoints() + "\n");
            out.append("  Status:   " + s.getStatus() + "\n");
            out.append("  Priority: " + s.getPriority() + "\n");
        } else {
            out.append("No stories were added to the backlog.\n");
        }

        app.add(new JScrollPane(out), BorderLayout.CENTER);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }

    private static void printResult(String label, NewStoryResult r) {
        System.out.println("- " + label + " -");
        System.out.println("ok? " + r.isOk());
        System.out.println("msg: " + r.getMessage());
        System.out.println("story null? " + (r.getStory() == null));
        System.out.println();
    }
}
