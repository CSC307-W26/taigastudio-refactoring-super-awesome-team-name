package stories;

import dao.Backlog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Opens the New Story form from BacklogWindow button.
 *
 * @author Jonathan Garcia
 * @version 3.1
 */
public class NewStoryListener implements ActionListener {
    private final BacklogPanel backlogPanel;
    private final Backlog backlog;

    public NewStoryListener(BacklogPanel backlogPanel, Backlog backlog) {
        this.backlogPanel = backlogPanel;
        this.backlog = backlog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        NewStoryNanny nanny = new NewStoryNanny();

        JFrame f = new JFrame("New Story");
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Runnable onSuccess = () -> {
            backlogPanel.refresh();
            f.dispose();
        };

        Runnable onCancel = f::dispose;

        NewStoryPanel panel = new NewStoryPanel();
        NewStoryController.connect(panel, nanny, backlog, onSuccess, onCancel);

        f.setContentPane(panel);
        f.setSize(800, 800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
