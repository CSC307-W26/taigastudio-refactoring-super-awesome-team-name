package stories; /**

 * This class enables drag-and-drop functionality
 * for stories in backlog
 *
 * @author Nick Grant
 * @version 1.1
 *
 */
import dao.Backlog;
import dao.Story;
import dao.UserStory;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StoryReorderHandler extends TransferHandler {

    private final Backlog backlog;
    private final BacklogPanel panel;

    public StoryReorderHandler(Backlog backlog, BacklogPanel panel) {
        this.backlog = backlog;
        this.panel = panel;
    }

    // 1. Start drag on mouse press
    public MouseAdapter createDragStarter(JComponent row) {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                row.getTransferHandler().exportAsDrag(row, e, MOVE);
            }
        };
    }

    // 2. What actions are allowed
    @Override
    public int getSourceActions(JComponent c) {
        return MOVE;
    }

    // 3. Package the Story into a Transferable
    @Override
    protected Transferable createTransferable(JComponent c) {
        StoryRow row = (StoryRow) c;
        return new BacklogStoryTransferable(row.getStory());
    }

    // 4. Can we import this drop?
    @Override
    public boolean canImport(TransferSupport support) {
        return support.isDataFlavorSupported(BacklogStoryTransferable.STORY_FLAVOR);
    }

    // 5. Handle the drop
    @Override
    public boolean importData(TransferSupport support) {
        try {
            UserStory dragged = (UserStory) support.getTransferable()
                    .getTransferData(BacklogStoryTransferable.STORY_FLAVOR);

            DropLocation dl = support.getDropLocation();
            Point dropPoint = dl.getDropPoint();

            // convert to listPanel coordinates
            SwingUtilities.convertPointToScreen(dropPoint, support.getComponent());
            SwingUtilities.convertPointFromScreen(dropPoint, panel.getListPanel());

            int dropIndex = panel.getDropIndex(dropPoint);

            java.util.List<UserStory> stories = backlog.getStories();
            int originalIndex = stories.indexOf(dragged);

            if (originalIndex == -1) return false;

            // adjust when dragging downward
            if (dropIndex > originalIndex) dropIndex--;

            if (dropIndex == originalIndex) return false;

            backlog.moveStory(dragged, dropIndex);
            panel.refresh();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}