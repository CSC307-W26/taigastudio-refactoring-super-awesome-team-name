package stories;

import dao.Story;

import javax.swing.*;

/**
 * This class creates the backend and visual data structures
 * for the backlog, also has functionally to add story to backlog
 *
 * @author Nick Grant
 * @version 1.0
 *
 */
public class Backlog {

    private final DefaultListModel<Story> model = new DefaultListModel<>();
    private final JList<Story> storyList = new JList<>(model);

    public Backlog() {
        storyList.setCellRenderer(new BacklogStoryRenderer());
        storyList.setFixedCellHeight(110);
        storyList.setFixedCellWidth(400);
    }

    public void addStory(Story story) {
        model.addElement(story);
    }

    public JList<Story> getStoryList() {
        return storyList;
    }

    public int getBacklogSize() {
        return model.size();
    }

}
