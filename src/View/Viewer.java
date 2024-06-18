package View;

import javax.swing.*;
import java.awt.*;

import Controller.Controller;

public class Viewer extends JFrame {
    private JLabel currentPlayerLabel;
    private Controller controller;

    public Viewer(PlayField pField, Controller controller) {
        this.controller = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLocation(200, 200);
        setResizable(false);
        ImageIcon icon = new ImageIcon(Viewer.class.getResource("/EasterEgg.png"));
        setIconImage(icon.getImage());
        setLayout(new BorderLayout());

        ScoreBar scoreBar = new ScoreBar();
        currentPlayerLabel = new JLabel("Current Player: ", SwingConstants.CENTER);
        scoreBar.add(currentPlayerLabel);

        PlayField playField = pField;
        Buttons buttons = new Buttons(this);

        add(scoreBar, BorderLayout.NORTH);
        add(playField, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setVisible(true);

    }

    public void updateCurrentPlayer(String playerName) {
        currentPlayerLabel.setText("Current Player: " + playerName);
    }

    public void onEndGameButtonPressed() {
        controller.endGame();
        controller.exitGame();
    }

    public void onStartNewGameButtonPressed() {
        controller.endGame();
        controller.startGame();
    }

    public void onHighscoreButtonPressed() {
        //TODO: add method for showing highscore list
    }
}
