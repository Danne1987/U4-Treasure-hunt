package Controller;
import View.*;
import Model.*;
import javax.swing.*;

/**
 * The controller class deals with the games logic, and calls for the map to be made.
 * @author Daniel & Sarah
 */
public class Controller{
    /**
     * Object of ScoreController which keeps track of highscores.
     */
    private ScoreController scoreController;
    /**
     * Object of Map, which uses an array used to make the map.
     */
    private Map map;
    /**
     * Object of PlayField, which is a boundary class containing the field the game is played on.
     */
    private PlayField field;
    /**
     * Object of Viewer, the boundary class that shows the entire game.
     */
    private Viewer viewer;
    /**
     * Object of Player for player 1.
     */
    private Player player1;
    /**
     * Object of Player for player 2.
     */
    private Player player2;
    /**
     * Object of Player for the current player.
     */
    private Player currentPlayer;
    /**
     * Boolean which determines if the game is over, if true the game is over, if false the game continues.
     */
    private boolean gameOver = false;

    /**
     * Constructor, starts the ScoreController, the map logic and the viewer.
     * @author Daniel & Sarah
     */
    public Controller(){
        scoreController = new ScoreController();
        map = new Map();
        field = new PlayField(map.getMap(), this);
        viewer = new Viewer(field, this, scoreController);

        startGame();
    }

    /**
     * Starts the game, lets you input names for players.
     * @author Daniel & Sarah
     */
    public void startGame() {
        String name1 = JOptionPane.showInputDialog("Enter Name for Player 1:");
        player1 = new Player(name1, 0);
        String name2 = JOptionPane.showInputDialog("Enter Name for Player 2:");
        player2 = new Player(name2, 0);

        currentPlayer = player1;
        viewer.updateCurrentPlayer(currentPlayer.getName());
    }

    /**
     * Methods that runs at the end of the game, checks which player has the highest score and shows a message for the winner.
     * @author Sarah
     */
    public void endGame() {
        String player1Name = player1.getName();
        int player1Score = player1.getScore();

        String player2Name = player2.getName();
        int player2Score = player2.getScore();

        if (player1Score > player2Score) {
            scoreController.updateScores(player1Name, player1Score);
            JOptionPane.showMessageDialog(viewer, "Game Over!\n" +
                    "You Win!\n" +
                    player1Name + ": " + player1Score + "\n");
        }
        else if (player2Score > player1Score) {
            scoreController.updateScores(player2Name, player2Score);
            JOptionPane.showMessageDialog(viewer, "Game Over!\n" +
                    "You Win!\n" +
                    player2Name + ": " + player2Score + "\n");
        }
    }

    /**
     * Exits the game.
     * @author Sarah
     */
    public void exitGame() {
        System.exit(0);
    }

    /**
     * This method checks if all treasure is dug up. If all treasure is dug up, the game ends.
     * @author Sarah
     */
    public void checkGameOver() {
        boolean allTreasureDug = true;

        String[][] mapSpelPlan = map.getMap();

        for (int row = 0; row < mapSpelPlan.length; row++) {
            for (int col = 0; col < mapSpelPlan[row].length; col++) {
                if (mapSpelPlan[row][col].equals("T")) {
                    allTreasureDug = false;
                    break;
                }
            }
            if (!allTreasureDug) {
                break;
            }
        }
        if (allTreasureDug) {
            gameOver = true;
        }
    }

    /**
     * Ends the players turn and switches player
     * @author Sarah
     */
    public void endTurn() {
        checkGameOver();
        if (!gameOver) {
            if (currentPlayer == player1) {
                currentPlayer = player2;
            }
            else {
                currentPlayer = player1;
            }
            viewer.updateCurrentPlayer(currentPlayer.getName());
            viewer.updateCurrentPlayerScore(currentPlayer.getScore());
        }
        else {
            endGame();
        }
    }

    /**
     * Returns the current player
     * @return currentPlayer
     * @author Sarah
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * This method does the "Dig" function. It checks the type of tile dug on. If a treasure it dug up, score is given to the player.
     * If a trap is dug up, the player looses score. If the tile is empty, a message is shown. Updates the map to show what was on the
     * specific tile.
     * @param row
     * @param col
     * @author Sarah
     */
    public void dig(int row, int col) {
        String[][] mapSpelPlan = map.getMap();
        String cell = mapSpelPlan[row][col];

        String type = "";
        currentPlayer = getCurrentPlayer();

        if (!cell.equals("DUG")) {
            if (cell.equals("T")) {
                JOptionPane.showMessageDialog(null, "You found Treasure! You get points");
                currentPlayer.addScore(10);
                type = "T";
                for (Treasure treasure : map.getTreasures()) {
                    treasure.markDug(mapSpelPlan, row, col);
                    if (treasure.isComplete()){
                        JOptionPane.showMessageDialog(null, "You completed a Treasure! Additional points rewarded");
                        currentPlayer.addScore(50);
                    }
                }
            }
            else if (cell.equals("D")) {
                JOptionPane.showMessageDialog(null, "You fell in a Trap!");
                isDug(mapSpelPlan, row, col);
                currentPlayer.addScore(-5);
                type = "D";
            }
            else {
                JOptionPane.showMessageDialog(null, "Nothing here");
                isDug(mapSpelPlan, row, col);
            }

            field.updateButton(row, col, type);

            endTurn();
        }
        else {
            JOptionPane.showMessageDialog(null, "Try again");
        }
    }

    /**
     * Sets a position on the map as "DUG" and prints a message.
     * @param map
     * @param row
     * @param col
     * @author Sarah
     */
    public void isDug(String[][] map, int row, int col) {
        map[row][col] = "DUG";
        System.out.println("The square has been dug");
    }
}
