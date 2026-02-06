package stories;

import dao.Story;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StoryEditorTest {

    @Test
    void constructor_populatesFieldsFromStory() throws Exception {
        Story story = new Story("My Subject", "My Desc", 8);
        NewStoryNanny nanny = null;

        StoryEditor[] editorRef = new StoryEditor[1];
        SwingUtilities.invokeAndWait(() -> editorRef[0] = new StoryEditor(nanny, story));
        StoryEditor editor = editorRef[0];

        List<JTextField> textFields = findAll(editor, JTextField.class);
        List<JTextArea> textAreas = findAll(editor, JTextArea.class);

        assertTrue(textFields.stream().anyMatch(tf -> "My Subject".equals(tf.getText())),
                "Expected a JTextField initialized with subject");
        assertTrue(textFields.stream().anyMatch(tf -> "8".equals(tf.getText())),
                "Expected a JTextField initialized with score");
        assertTrue(textAreas.stream().anyMatch(ta -> "My Desc".equals(ta.getText())),
                "Expected a JTextArea initialized with description");
    }
    private <T extends Component> List<T> findAll(Container container, Class<T> cls) {
        List<T> results = new ArrayList<>();
        for (Component comp : container.getComponents()) {
            if (cls.isInstance(comp)) {
                results.add(cls.cast(comp));
            }
            if (comp instanceof Container) {
                results.addAll(findAll((Container) comp, cls));
            }
        }
        return results;
    }
}
