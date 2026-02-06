package stories; /**

 * This class creates window for the backlog and toolbar
 *
 * @author Nick Grant
 * @version 1.1
 *
 */
import dao.Backlog;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BacklogScreen extends JFrame implements SwitchWindow{
    final Backlog backlog = new Backlog();
    private JPanel window = new BacklogWindow(this);

    public BacklogScreen() {
        super("Window");
        setSize(800, 600);
        setResizable(false);
        setLayout(new BorderLayout());
        JPanel header = new JPanel();
        ToolBar toolbar = new ToolBar(this);
        add(toolbar, "West");
        add(header, "North");
        add(this.window, "Center");
        setVisible(true);
    }

    static void main(String[] args) {
        new BacklogScreen();
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
