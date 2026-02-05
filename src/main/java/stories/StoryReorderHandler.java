package stories; /**

 * This class enables drag-and-drop functionality
 * for stories in backlog
 *
 * @author Nick Grant
 * @version 1.0
 *
 */
import dao.Story;

import javax.swing.*;
import java.awt.datatransfer.Transferable;

public class StoryReorderHandler extends TransferHandler {
    private final Backlog backlog;
    private final BacklogPanel panel;

    public StoryReorderHandler(Backlog backlog, BacklogPanel panel) {
        this.backlog = backlog;
        this.panel = panel;
    }

    @Override
    public int getSourceActions(JComponent c) {
        return MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        StoryRow row = (StoryRow) c;
        return new BacklogStoryTransferable(row.getStory());
    }

    @Override
    public boolean canImport(TransferSupport support) {
        return support.isDataFlavorSupported(BacklogStoryTransferable.STORY_FLAVOR);
    }

    @Override
    public boolean importData(TransferSupport support) {
        try {
            Story dragged = (Story) support.getTransferable()
                    .getTransferData(BacklogStoryTransferable.STORY_FLAVOR);

            DropLocation dl = support.getDropLocation();
            int dropIndex = panel.getDropIndex(dl.getDropPoint());

            backlog.moveStory(dragged, dropIndex);
            panel.refresh();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}