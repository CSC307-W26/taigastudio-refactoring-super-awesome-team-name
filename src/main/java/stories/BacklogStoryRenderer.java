package stories;

import dao.Story;

import javax.swing.*;
import java.awt.*;

/**
 * This class helps the backlog panel render in the window, also creates format of stories
 *
 * @author Nick Grant
 * @version 2.0
 *
 */
public class BacklogStoryRenderer extends JPanel implements ListCellRenderer<Story> {

    private Story story;

    public BacklogStoryRenderer() {
        setOpaque(false);
    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Story> list,
            Story value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        story = value;
        setPreferredSize(new Dimension(300, 110));
        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(10, 10, getWidth() - 21, getHeight() - 3 );

        g.setColor(Color.BLACK);

        g.drawString("Title: " + story.getTitle(), 25, 30);
        g.drawString("Desc: " + story.getDescription(), 25, 50);
        g.drawString("Points: " + story.getPoints(), 25, 70);
        g.drawString("Priority: " + story.getPriority(), 25, 90);
        g.drawString("Status: " + story.getStatus(), 25, 110);
    }
}
