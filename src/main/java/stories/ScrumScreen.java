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

public class ScrumScreen extends JFrame implements SwitchWindow{
    final Backlog backlog = new Backlog();
    private JPanel window = new BacklogWindow(backlog, this::changeWindow);

    public ScrumScreen() {
        super("Window");
        setSize(1000, 800);
        setResizable(false);
        setLayout(new BorderLayout());
        JPanel header = new JPanel();
        JLabel label = new JLabel("Header");
        header.add(label);
        ToolBar toolbar = new ToolBar(this);
        add(toolbar, "West");
        add(header, "North");
        add(this.window, "Center");
        setVisible(true);
    }

    static void main(String[] args) {
        new ScrumScreen();
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
