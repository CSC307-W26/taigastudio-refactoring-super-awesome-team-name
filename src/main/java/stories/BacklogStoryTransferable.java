package stories;

import dao.Story;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

/**
 * This class supports StoryReorderHandler
 *
 * @author Nick Grant
 * @version 1.0
 *
 */
class BacklogStoryTransferable implements Transferable {
	
	static final DataFlavor STORY_FLAVOR =  new DataFlavor(Story.class, "dao.Story");
 
	private final Story story;
	
	public BacklogStoryTransferable(Story story) {
		this.story = story;
	}
	
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[]{STORY_FLAVOR};
	}
	
	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.equals(STORY_FLAVOR);
	}
	
	@Override
	public Object getTransferData(DataFlavor flavor) {
		return story;
	}
 
}