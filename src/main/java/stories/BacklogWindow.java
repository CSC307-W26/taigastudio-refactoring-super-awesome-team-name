package stories; /**

 * This class creates the backlog window including
 * a header (with a title and button to add new stories)
 * and a panel for the backlog list
 *
 * @author Nick Grant
 * @version 1.0
 *
 */

import dao.Story;

import javax.swing.*;
import java.awt.*;

public class BacklogWindow extends JPanel {
    private JList<Story> storyList;

    public BacklogWindow(JFrame frame){
        //stories.Backlog backlog = frame.backlog;
        setLayout(new BorderLayout());

        JPanel backlogheader = new JPanel(new BorderLayout());
        JPanel backlogpanel = new JPanel(new BorderLayout());

        backlogheader.add(new JLabel("stories.Backlog"), BorderLayout.WEST);

        JButton newStoryBtn = new JButton("+ USER STORY");
        //stories.NewStoryListener newStoryListener = new stories.NewStoryListener(backlog);
        //newStoryBtn.addActionListener(newStoryListener);
        backlogheader.add(newStoryBtn, BorderLayout.EAST);

        backlogpanel.add(backlogheader, BorderLayout.NORTH);
        //storyList = backlog.getStoryList();
        storyList.setDragEnabled(true);
        storyList.setDropMode(DropMode.INSERT);
        storyList.setTransferHandler(new StoryReorderHandler());
        backlogpanel.add(storyList, BorderLayout.CENTER);

        add(backlogpanel, BorderLayout.CENTER);
    }

    /*
    public void changeWindow(JPanel newWindow){
        remove(window);
        window = newWindow;
        add(window, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
     */


}
