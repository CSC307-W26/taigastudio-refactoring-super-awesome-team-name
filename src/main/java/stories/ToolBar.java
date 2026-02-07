package stories;
/**

 * This class creates toolbar for the main
 * window, showing scrum options
 *
 * @author Nick Grant
 * @version 1.1
 *
 */
import dao.Backlog;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ToolBar extends JPanel {
    private final Backlog backlog;
    private final SwitchWindow windowSwitcher;

    public ToolBar(Backlog backlog, SwitchWindow windowSwitcher) {
        this.backlog = backlog;
        this.windowSwitcher = windowSwitcher;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(75, 81, 99));
        JLabel title = new JLabel("Taiga Studio");
        title.setForeground(new Color(37, 168, 157));

        String[] viewOptions = new String[]{"Backlog", "Sprint"};
        JButton menuBtn = new JButton("Scrum");
        JPopupMenu menu = buildMenu(viewOptions);
        menuBtn.addActionListener(_ -> menu.show(menuBtn, 0, menuBtn.getHeight()));

        menuBtn.setForeground(Color.WHITE);
        menuBtn.setBorderPainted(false);
        menuBtn.setContentAreaFilled(false);
        menuBtn.setFocusable(false);

        title.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        menuBtn.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        add(title);
        add(Box.createVerticalStrut(20)); // 10px gap
        add(menuBtn);
    }
    private JPopupMenu buildMenu(String[] viewOptions) {
        JPopupMenu menu = new JPopupMenu();
        List<JMenuItem> viewOptionBtns = new ArrayList<>();

        for (String option : viewOptions){
            JMenuItem menuItem = new JMenuItem(option);
            viewOptionBtns.add(menuItem);
            if (option.equals("Backlog")){
                menuItem.addActionListener(_ -> {
                    windowSwitcher.changeWindow(new BacklogView(backlog, windowSwitcher));
                });
            } else if (option.equals("Sprint")){
                menuItem.addActionListener(_ -> {
                    windowSwitcher.changeWindow(new SprintWindowExample());
                });
            }
        }
        for (JMenuItem option : viewOptionBtns) {
            menu.add(option);
        }
        return menu;
    }
}
