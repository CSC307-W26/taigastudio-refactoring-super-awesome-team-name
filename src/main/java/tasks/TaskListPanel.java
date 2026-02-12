package tasks;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.border.Border;

import dao.Task;
import dao.UserStory;

/**
 * Panel that displays a list of tasks with edit buttons and a create button for new tasks.
 * Panel has drag and drop functionality that will move the tasks around.
 * 
 *
 * @author Alexander Bloomer, Collin Howard
 * @author Kevin Mokarapiromya - Refactoring and drag and drop functionality 
 * @version 1.0
 */
public class TaskListPanel extends JPanel {
	private JPanel taskPanel;
	
	public TaskListPanel(JFrame main, TaskNanny nanny, UserStory story) {
		List<Task> tasks = story.getTasks();
		
		setLayout(new BorderLayout());

		taskPanel = new JPanel();
		
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

		for (int i = 0; i < tasks.size(); i++) {
			Task t = tasks.get(i);
			taskPanel.add(createTaskEntry(t,nanny,story));
		}

		JButton create = new JButton("Create");
		create.addActionListener(e -> nanny.OpenCreateTaskPanel(e, story));
		add(taskPanel, BorderLayout.CENTER);
        add(create, BorderLayout.SOUTH);

	}

	/**
	 * Method to convert the task into an entry inside the panel
	 * Includes drag and drop and an edit button made.
	 * Refreshing would be done by the nanny
	 * @param t
	 * @param nanny
	 * @param story
	 * @return
	 */
	private JPanel createTaskEntry(Task t, TaskNanny nanny, UserStory story) {
        JPanel entry = new JPanel(new BorderLayout());
        entry.setBorder(BorderFactory.createEtchedBorder());
        
        JLabel drag = new JLabel(" * "); 
        drag.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JTextField taskText = new JTextField(t.getSubject() + ": " + t.getBody());
        taskText.setEditable(false);
        
        JButton edit = new JButton("Edit");
		edit.setActionCommand(t.getId());
        edit.addActionListener(e -> nanny.OpenEditTaskPanel(e, story));

        entry.add(drag, BorderLayout.WEST);
        entry.add(taskText, BorderLayout.CENTER);
        entry.add(edit, BorderLayout.EAST);

        entry.setTransferHandler(new TaskTransferHandler());
        
        // Start drag when mouse is pressed on the handle
        drag.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JComponent comp = (JComponent) e.getComponent();
                TransferHandler handler = ((JPanel)comp.getParent()).getTransferHandler();
                handler.exportAsDrag((JPanel)comp.getParent(), (InputEvent) e, TransferHandler.MOVE);
            }
        });
        return entry;
    }

	/**
	 * Code that acts as a helper method to do new drag and drop from an icon
	 * Structure on using transferHandler and anything similar came from video: 
	 * https://youtu.be/I19_Yv2AsJM?si=t9KmnA-8j-vxqZoG
	 * 
	 */
    private class TaskTransferHandler extends TransferHandler {
        @Override
        public int getSourceActions(JComponent component) {
            return MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent component) {
            return new StringSelection("");
        }

        @Override
        public boolean canImport(TransferSupport support) {
            return true;
        }

		//import data will be what's allowing things to be dragged and dropped
        @Override
        public boolean importData(TransferSupport support) {
            Component src = support.getComponent();
            Point dropPoint = support.getDropLocation().getDropPoint();
            int index = taskPanel.getComponentAt(dropPoint) != null ? 
                        java.util.Arrays.asList(taskPanel.getComponents()).indexOf(taskPanel.getComponentAt(dropPoint)) : -1;

            if (index != -1) {
                taskPanel.remove(src);
                taskPanel.add(src, index);
                taskPanel.revalidate();
                return true;
            }
            return false;
        }
	}
}
