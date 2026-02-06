package stories;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import dao.Story;
/**
 * This class represents a user story editor for editing story details
 *
 * @author Luis Garcia
 * @version 1.0
 */

public class StoryEditor extends JPanel {
    public StoryEditor(NewStoryNanny nanny, Story storyToEdit) {
        String subjectText = storyToEdit.getSubject();
        String descriptionText = storyToEdit.getDescription();
        int scoreValue = storyToEdit.getScore();

        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Edit Story", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 28f));

        JPanel center = new JPanel();
        center.setLayout(new BorderLayout(10, 10));

        // Subject field
        JTextField subject = new JTextField(subjectText);
        subject.setBorder(new LineBorder(Color.blue));

        // Description field
        JTextArea description = new JTextArea(descriptionText);
        description.setLineWrap(true);
        description.setBorder(new LineBorder(Color.blue));

        // Score field
        JTextField score = new JTextField(String.valueOf(scoreValue));
        score.setBorder(new LineBorder(Color.blue));

        // Panel for score
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BorderLayout(5, 5));
        JLabel scoreLabel = new JLabel("Score:");
        scorePanel.add(scoreLabel, BorderLayout.WEST);
        scorePanel.add(score, BorderLayout.CENTER);

        // Center panel layout
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BorderLayout(10, 10));
        fieldsPanel.add(subject, BorderLayout.NORTH);
        fieldsPanel.add(description, BorderLayout.CENTER);
        fieldsPanel.add(scorePanel, BorderLayout.SOUTH);

        center.add(fieldsPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("SAVE");
        saveButton.addActionListener(e -> {
            try {
                int newScore = Integer.parseInt(score.getText());
                Story updatedStory = new Story(subject.getText(), description.getText(), newScore);
            } catch (NumberFormatException ex) {
                // Handle invalid score input
            }
        });

        add(title, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);
    }
}
