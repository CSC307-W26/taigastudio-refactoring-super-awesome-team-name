import dao.Backlog;
import dao.Story;
import stories.NewStoryNanny;

import javax.swing.*;
import java.awt.*;

/**
 * Tests that stories can be created correctly and added to the backlog. Also checks invalid inputs.
 * Story info is printed in the terminal.
 *
 * Run this file with "Run CreateStoryTest.main()".
 *
 * @author Jonathan Garcia
 * @version 2.0
 */
public class CreateStoryTest extends JFrame {

    public static void main(String[] args) {
        CreateStoryTest app = new CreateStoryTest();

        Backlog backlog = new Backlog();
        NewStoryNanny nanny = new NewStoryNanny();

        NewStoryNanny.Result r1 = nanny.createStory("", "desc", 5, 3);
        printResult("missing title", r1);

        NewStoryNanny.Result r2 = nanny.createStory("title", "", 5, 3);
        printResult("missing description", r2);

        NewStoryNanny.Result r3 = nanny.createStory("title", "desc", 0, 3);
        printResult("bad points", r3);

        NewStoryNanny.Result r4 = nanny.createStory("title", "desc", 5, 6);
        printResult("bad priority", r4);

        NewStoryNanny.Result r5 = nanny.createStory("Login", "User can log in", 8, 2);
        printResult("success", r5);
        if (r5.isOk()) {
            backlog.addStory(r5.getStory());
        }

        app.setTitle("CreateStoryTest (Jonathan)");
        app.setSize(600, 250);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea out = new JTextArea();
        out.setEditable(false);
        out.setFont(new Font("Monospaced", Font.PLAIN, 14));

        out.append("Backlog size: " + backlog.size() + "\n");
        if (backlog.size() > 0) {
            Story s = backlog.get(0);
            out.append("First story:\n");
            out.append("  ID: " + s.getID() + "\n");
            out.append("  Title: " + s.getTitle() + "\n");
            out.append("  Desc: " + s.getDescription() + "\n");
            out.append("  Points: " + s.getPoints() + "\n");
            out.append("  Status: " + s.getStatus() + "\n");
            out.append("  Priority: " + s.getPriority() + "\n");
        }

        app.add(new JScrollPane(out));
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }

    private static void printResult(String label, NewStoryNanny.Result r) {
        System.out.println("-" + label + "-");
        System.out.println("ok? " + r.isOk());
        System.out.println("msg: " + r.getMessage());
        System.out.println("story null? " + (r.getStory() == null));
        System.out.println();
    }
}
