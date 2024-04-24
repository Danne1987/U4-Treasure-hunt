package View;

import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {
    public Viewer(PlayField pField)
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLocation(200, 200);
        setResizable(false);
        ImageIcon icon = new ImageIcon(Viewer.class.getResource("/EasterEgg.png"));
        setIconImage(icon.getImage());
        setLayout(new BorderLayout());

        ScoreBar scoreBar = new ScoreBar();
        PlayField playField = pField;
        Buttons buttons = new Buttons();

        add(scoreBar, BorderLayout.NORTH);
        add(playField, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setVisible(true);

    }
}
