package stories;
/**
 * This class creates window for the backlog and toolbar
 *
 * @author Nick Grant
 * @version 1.3
 *
 */

import dao.Backlog;

import java.awt.BorderLayout;
import javax.swing.*;

public class ScrumScreen extends JPanel implements SwitchWindow{
    final Backlog backlog = new Backlog();
    private JPanel window = new BacklogView(backlog, this::changeWindow);

    public ScrumScreen() {
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.add(new JLabel("Header"));

        add(header, "North");
        add(new ToolBar(backlog, this::changeWindow), "West");
        add(this.window, "Center");
    }


    @Override
    public void changeWindow(JPanel newWindow) {
        remove(this.window);
        window = newWindow;
        add(this.window, "Center");
        revalidate();
        repaint();
    }
}

