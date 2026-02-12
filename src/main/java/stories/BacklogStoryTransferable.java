package stories;

import dao.Story;
import dao.UserStory;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.*;

/**
 * This class supports StoryReorderHandler
 *
 * @author Nick Grant
 * @version 1.1
 *
 */


public class BacklogStoryTransferable implements Transferable {

	public static final DataFlavor STORY_FLAVOR =
			new DataFlavor(Story.class, "Story");

	private static final DataFlavor[] SUPPORTED_FLAVORS = { STORY_FLAVOR };

	private final UserStory story;

	public BacklogStoryTransferable(UserStory story) {
		this.story = story;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return SUPPORTED_FLAVORS;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.equals(STORY_FLAVOR);
	}

	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException {
		if (!isDataFlavorSupported(flavor)) {
			throw new UnsupportedFlavorException(flavor);
		}
		return story;
	}
}