package stories;
/**
 * This class creates window for the backlog and toolbar
 *
 * @author Nick Grant
 * @version 1.3
 *
 */

import dao.Backlog;
import dao.Project;
import project.EditProjectPanelNanny;

import java.awt.BorderLayout;
import javax.swing.*;

public class ScrumScreen extends JPanel implements SwitchWindow{

    final Backlog backlog;
    private JPanel window;
    private JFrame main;

    public ScrumScreen(JFrame main, Backlog backlog) {
        this.main = main;
        this.backlog = backlog;
        this.window = new BacklogView(this.backlog, this::changeWindow);

        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.add(new JLabel("Header"));

        add(header, "North");
        add(new ToolBar(backlog, this::changeWindow), "West");
        add(this.window, "Center");

        // exit button to return to the homepage
        JButton exit = new JButton();
        ReturnNanny returnNanny = new ReturnNanny();
        exit.setText("Return");
        exit.addActionListener(e -> returnNanny.returnHome(main));
        header.add(exit, BorderLayout.EAST);
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

