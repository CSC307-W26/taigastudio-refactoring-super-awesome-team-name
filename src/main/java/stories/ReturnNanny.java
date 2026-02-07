package stories;

/**
 * Button Nanny to return to the home panel from the Scrum Screen.
 *
 * @author Johnny Parini
 * @version 1.0
 */

import project.ListProjectHomePanel;

import javax.swing.*;

public class ReturnNanny {


        public ReturnNanny(){

        }

        public void returnHome(JFrame main){
            ListProjectHomePanel hp = new ListProjectHomePanel(main);
            main.setContentPane(hp);
            main.revalidate();
            main.repaint();
        }
}
