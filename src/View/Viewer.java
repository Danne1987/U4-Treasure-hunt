package View;

import javax.swing.*;
import java.awt.*;

import Controller.*;

public class Viewer extends JFrame {
    private JLabel currentPlayerLabel;
    private JLabel scoreCount;
    private Controller controller;
    private ScoreController scoreController;

    public Viewer(PlayField pField, Controller controller, ScoreController scoreController) {
        this.controller = controller;
        this.scoreController = scoreController;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLocation(200, 200);
        setResizable(false);
        ImageIcon icon = new ImageIcon(Viewer.class.getResource("/EasterEgg.png"));
        setIconImage(icon.getImage());
        setLayout(new BorderLayout());

        ScoreBar scoreBar = new ScoreBar();
        scoreCount = new JLabel("Score: 0");
        currentPlayerLabel = new JLabel("Current Player: ", SwingConstants.CENTER);
        //JLabel scoreCountPlayer2 = new JLabel("Score kommer visas här!");

        scoreBar.add(scoreCount);
        scoreBar.add(currentPlayerLabel);
        //scoreBar.add(scoreCountPlayer2);

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
    public void updateCurrentPlayerScore(int playerScore){scoreCount.setText("Player score: " + playerScore);}

    public void onEndGameButtonPressed() {
        controller.endGame();
        controller.exitGame();
    }

    public void onStartNewGameButtonPressed() {
        dispose();
        new Controller();
    }

    public void onHighscoreButtonPressed() {
        String highscoreList = scoreController.getHighscoreList();
        JOptionPane.showMessageDialog(this, highscoreList);
    }
}
