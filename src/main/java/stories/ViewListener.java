package stories;
/**
author: nick grant
listens for button on toolbar
to change windows
 version 1.1
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class ViewListener implements ActionListener {
    private final JComboBox<String> scrumBtn;
    private final ScrumScreen frame;

    public ViewListener(JComboBox<String> btn, ScrumScreen frame) {
        scrumBtn = btn;
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("comboBoxChanged")) {
            String scrumBtnChoice = (String)scrumBtn.getSelectedItem();

            assert scrumBtnChoice != null;
            if (scrumBtnChoice.equals("Backlog")) {
                frame.changeWindow(new BacklogWindow(frame.backlog, frame::changeWindow));
            } else if (scrumBtnChoice.equals("Sprint")) {
                frame.changeWindow(new SprintWindowExample());
            }
        }

    }
}
