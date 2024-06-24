package View;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates the scorebar at the top of the window.
 * @author Daniel & Sarah
 */
public class ScoreBar extends JPanel{
    /**
     * This method creates and places the scorebar.
     * @author Daniel & Sarah
     */
    public ScoreBar() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(500, 50));
        //JLabel scoreCount = new JLabel("Score kommer visas här!");
        //scoreCount.setHorizontalAlignment(SwingConstants.CENTER);
        //add(scoreCount);
    }
}
