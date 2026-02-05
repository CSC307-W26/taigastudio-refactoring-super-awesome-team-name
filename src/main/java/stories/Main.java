/**
 * This class starts the app and switches between screens.
 *
 * @author Jonathan Garcia
 * @version 1.0
 */

import stories.Backlog;
import stories.NewStoryListener;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        CardLayout cards = new CardLayout();
        JPanel root = new JPanel(cards);
        Backlog backlog = new Backlog();
        NewStoryNanny nanny = new NewStoryNanny();
        HomePanel home = new HomePanel(cards, root, backlog);
        NewStoryPanel newStory = new NewStoryPanel(
                nanny,
                () -> cards.show(root, "HOME"),
                () -> cards.show(root, "HOME"),
                backlog
        );
        root.add(home, "HOME");
        root.add(newStory, "NEW");
        setContentPane(root);
        cards.show(root, "HOME");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main m = new Main();
            m.setDefaultCloseOperation(EXIT_ON_CLOSE);
            m.setSize(900, 700);
            m.setLocationRelativeTo(null);
            m.setVisible(true);
        });
    }
}