package Controller;

import Model.*;
import View.PlayField;
import View.Viewer;

import javax.swing.*;
import java.util.Arrays;

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
     * Integer to count the amount of completed treasures
     */
    private int countingTreasuresForTheWin = 0;

    /**
     * Integer for the amount of pieces in each treasure
     */
    private final int amountOfTreasurePiecesPerTreasure = 4;

    /**
     * Constructor, starts the ScoreController, the map logic and the viewer.
     * @author Daniel & Sarah
     */
    public Controller(){
        scoreController = new ScoreController();
        map = new Map();

        String[][] stringMap = convertMapCellToString(map.getMap());
        System.out.println(Arrays.deepToString(stringMap));

        field = new PlayField(stringMap, this);
        viewer = new Viewer(field, this, scoreController);

        startGame();
    }

    /**
     * Method to convert the MapCell array to Strings for the PlayField
     * @param mapCells
     * @return
     */
    private String[][] convertMapCellToString(MapCell[][] mapCells){
        int rows = mapCells.length;
        int cols = mapCells[0].length;
        String[][] stringMap = new String[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                MapCell cell = mapCells[i][j];
                if (cell.isDug()) {
                    if (cell.containsTreasure()) {
                        stringMap[i][j] = "T";
                    }
                    else if (cell.containsTrap()) {
                        stringMap[i][j] = "D";
                    }
                    else {
                        stringMap[i][j] = "DUG";
                    }
                }
                else {
                    stringMap[i][j] = "";
                }
            }
        }
        return stringMap;
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
        if (countingTreasuresForTheWin == 5) {
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
        MapCell[][] mapSpelPlan = map.getMap();
        MapCell cell = mapSpelPlan[row][col];

        String type = "";
        currentPlayer = getCurrentPlayer();

        if (!cell.isDug()) {

            if (cell.containsTreasure()) {
                JOptionPane.showMessageDialog(null, "You found Treasure! You get points");
                currentPlayer.addScore(10);
                type = "T";

                for (Treasure treasure : map.getTreasures()) {
                    int[][] shape = treasure.getShape();
                    int xCoord = treasure.getXCoord();
                    int yCoord = treasure.getYCoord();
                    boolean match = false;

                    for (int[] offset : shape) {
                        int shapeX = xCoord + offset[0];
                        int shapeY = yCoord + offset[1];

                        if (shapeX == row && shapeY == col) {
                            System.out.println("You found a treasure piece at row " + shapeX + ", column " + shapeY);

                            treasure.addDugPieces();
                            match = true;
                            break;
                        }
                    }

                    if (match) {
                        if (treasure.getDugPiece() == amountOfTreasurePiecesPerTreasure) {
                            JOptionPane.showMessageDialog(null, "You completed a Treasure! Additional points rewarded");
                            currentPlayer.addScore(50);
                            countingTreasuresForTheWin++;
                        }
                        break;
                    }
                }
            }
            else if (cell.containsTrap()) {
                JOptionPane.showMessageDialog(null, "You fell in a Trap!");
                currentPlayer.addScore(-5);
                type = "D";
                cell.dig();
            }
            else if (cell instanceof EmptyCell){
                JOptionPane.showMessageDialog(null, "Nothing here");
                cell.dig();
            }

            field.updateButton(row, col, type);

            endTurn();
        }
        else if (cell.isDug()){
            JOptionPane.showMessageDialog(null, "Try again");
        }
    }
}
