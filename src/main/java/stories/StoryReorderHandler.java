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

class StoryReorderHandler extends TransferHandler {

    private int fromIndex = -1;

    @Override
    public int getSourceActions(JComponent c) {
        return MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        JList<?> list = (JList<?>) c;
        fromIndex = list.getSelectedIndex();
        Story story = (Story) list.getSelectedValue();
        return new BacklogStoryTransferable(story);
    }

    @Override
    public boolean canImport(TransferSupport support) {
        return support.isDataFlavorSupported(BacklogStoryTransferable.STORY_FLAVOR);
    }

    @Override
    public boolean importData(TransferSupport support) {
        try {
            JList.DropLocation dl = (JList.DropLocation) support.getDropLocation();
            int toIndex = dl.getIndex();

            JList list = (JList) support.getComponent();
            DefaultListModel model = (DefaultListModel) list.getModel();

            Story moved = (Story) support.getTransferable()
                    .getTransferData(BacklogStoryTransferable.STORY_FLAVOR);

            // Remove old position
            model.remove(fromIndex);

            // Adjust index if needed
            if (toIndex > fromIndex) toIndex--;

            // Insert at new position
            model.add(toIndex, moved);

            list.setSelectedIndex(toIndex);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}