package stories;

import dao.Story;

import javax.swing.*;
import java.awt.*;

/**
 * This class helps the backlog panel render in the window, also creates format of stories
 *
 * @author Nick Grant
 * @version 1.0
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
		setPreferredSize(new Dimension(300, 60));
		return this;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Draw a nice rectangle with padding
		int padding = 10;
		int w = getWidth() - padding * 2;
		int h = getHeight() - padding * 2;
		int x = padding + 10;
		int y = padding + 20;
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(padding, padding, w, h);
		
		g.setColor(Color.BLACK);
		g.drawString("#" + story.getStoryAttribute("id"), x, y);
		
		x += 30; // shift right
		//g.drawString((String) story.getStoryAttribute("title"), x, y);
		x += 60;
		//g.drawString((String) story.getStoryAttribute("tag"), x, y);
		x += 400;
		//g.drawString((String) story.getStoryAttribute("status"), x, y);
		x += 100;
		g.drawString(String.valueOf(story.getStoryAttribute("points")), x, y);
		
	}
}