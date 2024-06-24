package View;

import javax.swing.*;
import java.awt.*;

import Controller.*;

/**
 * This class is the boundary for the game. It keeps track of all buttons and labels.
 * @author Daniel & Sarah
 */
public class Viewer extends JFrame {
    /**
     * Label meant to show the name of the current player.
     */
    private JLabel currentPlayerLabel;
    /**
     * Label meant to show the current players score.
     */
    private JLabel scoreCount;
    /**
     * Object of the controller.
     */
    private Controller controller;
    /**
     * Object of the ScoreController.
     */
    private ScoreController scoreController;

    /**
     * The constructor for the Viewer class. It collects the buttons and scorebar from the other boundary classes and places them in the window.
     * @param pField
     * @param controller
     * @param scoreController
     * @author Daniel & Sarah
     */
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

    /**
     * Updates the current player label to show the current players name.
     * @param playerName
     * @author Sarah
     */
    public void updateCurrentPlayer(String playerName) {
        currentPlayerLabel.setText("Current Player: " + playerName);
    }

    /**
     * Updates the score label for the current player.
     * @param playerScore
     * @author Daniel
     */
    public void updateCurrentPlayerScore(int playerScore){scoreCount.setText("Player score: " + playerScore);}

    /**
     * Method to end the game.
     * @author Sarah
     */
    public void onEndGameButtonPressed() {
        controller.endGame();
        controller.exitGame();
    }

    /**
     * Method to start a new game.
     * @author Sarah.
     */
    public void onStartNewGameButtonPressed() {
        dispose();
        new Controller();
    }

    /**
     * Method to show the highscore list.
     * @author Sarah
     */
    public void onHighscoreButtonPressed() {
        String highscoreList = scoreController.getHighscoreList();
        JOptionPane.showMessageDialog(this, highscoreList);
    }
}
