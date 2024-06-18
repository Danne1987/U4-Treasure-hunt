package View;

import javax.swing.*;
import java.awt.*;

public class Buttons extends JPanel {
    public Buttons()
    {
        setLayout(new GridLayout(1,2));
        setPreferredSize((new Dimension(200,50)));

        JButton endGameButton = new JButton("End Game");
        JButton startNewGameButton = new JButton("Start New Game");
        JButton highscoreButton = new JButton("Highscore List");

        add(endGameButton);
        add(startNewGameButton);
        add(highscoreButton);
    }
}
