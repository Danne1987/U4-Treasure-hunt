package View;

import javax.swing.*;
import java.awt.*;

public class ScoreBar extends JPanel{
    public ScoreBar()
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(500, 50));
        JLabel scoreCount = new JLabel("Score kommer visas här!");
        scoreCount.setHorizontalAlignment(SwingConstants.CENTER);
        add(scoreCount);
    }
}
