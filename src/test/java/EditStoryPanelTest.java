import dao.Backlog;
import dao.UserStory;
import stories.BacklogPanel;
import stories.EditStoryPanel;
import stories.SwitchWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Manual test for EditStoryPanel: programmatically set fields and press Save.
 *
 * @author Luis Garcia
 * @version 1.0
 *
 */
public class EditStoryPanelTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Backlog backlog = new Backlog();
            UserStory story = new UserStory("old title", "old desc");
            backlog.addStory(story);

            JFrame frame = new JFrame("EditStoryPanel Test");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(600, 600);

            // simple SwitchWindow that swaps panel in the frame
            SwitchWindow switcher = panel -> {
                frame.setContentPane(panel);
                frame.revalidate();
                frame.repaint();
            };

            BacklogPanel backlogPanel = new BacklogPanel(backlog, switcher);

            EditStoryPanel edit = new EditStoryPanel(story, backlogPanel, switcher);

            frame.setContentPane(edit);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // find the form (first child) then set fields in order
            Component[] topChildren = edit.getComponents();
            JPanel form = null;
            for (Component c : topChildren) {
                if (c instanceof JPanel) {
                    form = (JPanel) c;
                    break;
                }
            }

            if (form == null) {
                System.err.println("Could not find form panel");
                return;
            }

            Component[] comps = form.getComponents();
            // Expected order: JLabel, JTextField, JLabel, JScrollPane, JLabel, JSpinner, JLabel, JSpinner, JLabel, JComboBox
            for (Component c : comps) {
                if (c instanceof JTextField) {
                    ((JTextField) c).setText("new title");
                } else if (c instanceof JScrollPane) {
                    JScrollPane sp = (JScrollPane) c;
                    JViewport vp = sp.getViewport();
                    Component inner = vp.getView();
                    if (inner instanceof JTextArea) {
                        ((JTextArea) inner).setText("new description");
                    }
                } else if (c instanceof JSpinner) {
                    Object val = ((JSpinner) c).getValue();
                    if (val instanceof Integer) {
                        ((JSpinner) c).setValue(5);
                    }
                } else if (c instanceof JComboBox) {
                    ((JComboBox<?>) c).setSelectedItem("In Progress");
                }
            }

            // find Save button in the buttons panel (last child)
            Component[] all = edit.getComponents();
            JButton saveBtn = null;
            for (Component c : all) {
                if (c instanceof JPanel) {
                    Component[] inner = ((JPanel) c).getComponents();
                    for (Component ic : inner) {
                        if (ic instanceof JButton) {
                            JButton b = (JButton) ic;
                            if ("Save".equals(b.getText())) saveBtn = b;
                        }
                    }
                }
            }

            if (saveBtn == null) {
                System.err.println("Save button not found");
                return;
            }

            // click save and then print story fields to verify
            saveBtn.doClick();

            System.out.println("After save:");
            System.out.println("Title: " + story.getTitle());
            System.out.println("Description: " + story.getDescription());
            System.out.println("Points: " + story.getPoints());
            System.out.println("Priority: " + story.getPriority());
            System.out.println("Status: " + story.getStatus());
        });
    }
}
