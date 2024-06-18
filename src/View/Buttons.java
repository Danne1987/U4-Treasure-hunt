package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JPanel {
    private Viewer viewer;

    public Buttons(Viewer viewer) {
        this.viewer = viewer;
        setLayout(new GridLayout(1,2));
        setPreferredSize((new Dimension(200,50)));

        JButton endGameButton = new JButton("End Game");
        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewer.onEndGameButtonPressed();
            }
        });

        JButton startNewGameButton = new JButton("Start New Game");
        startNewGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewer.onStartNewGameButtonPressed();
            }
        });
        JButton highscoreButton = new JButton("Highscore List");
        highscoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewer.onHighscoreButtonPressed();
            }
        });

        add(endGameButton);
        add(startNewGameButton);
        add(highscoreButton);
    }
}
