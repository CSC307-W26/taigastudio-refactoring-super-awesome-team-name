import javax.swing.*;
import java.awt.*;

import project.*;

/**
 * The beginnings of the final Main class
 * Intended for full integration
 *
 * @author Johnny Parini
 * @version 1.0
 */

public class IntegratedMain extends JFrame {

    private static final long MILLIS_PER_DAY = 86400000;

    public static void main(String[] args){
        IntegratedMain main = new IntegratedMain();
        main.setSize(1470, 600);
        main.setTitle("Projects");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

    }

    public IntegratedMain(){
        EditProjectPanelNanny editNanny = new EditProjectPanelNanny(this);
        ListProjectHomePanel home = new ListProjectHomePanel(this);
        add(home, BorderLayout.CENTER);
    }
}
