package Controller;
import View.*;
import Model.*;
import javax.swing.*;

public class Controller{
    private ScoreController scoreController;
    private MapLogic map;
    //Treasure treasure = new Treasure(map.getSpelPlan());
    private PlayField field;
    private Viewer viewer;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameOver = false;


    public Controller(){
        scoreController = new ScoreController();
        map = new MapLogic();
        scoreController.writeToFile();
        field = new PlayField(map.getSpelPlan(), this);
        viewer = new Viewer(field);

        /*String name1 = JOptionPane.showInputDialog("Enter Name for Player 1:");
        player1 = new Player(name1, 0);
        String name2 = JOptionPane.showInputDialog("Enter Name for Player 2:");
        player2 = new Player(name2, 0);

         */

        startGame();
    }

    public void startGame() {
        String name1 = JOptionPane.showInputDialog("Enter Name for Player 1:");
        player1 = new Player(name1, 0);
        String name2 = JOptionPane.showInputDialog("Enter Name for Player 2:");
        player2 = new Player(name2, 0);

        currentPlayer = player1;
        viewer.updateCurrentPlayer(currentPlayer.getName());

        while (!gameOver) {

        }
    }

    public void endTurn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
        viewer.updateCurrentPlayer(currentPlayer.getName());
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void dig(int row, int col) {
        //TODO logic for the digging consequences

        String[][] mapSpelPlan = map.getSpelPlan();
        String cell = mapSpelPlan[row][col];

        if (cell.equals("T")) {
            JOptionPane.showMessageDialog(null, "You found Treasure");
            //implement something to indicate if full treasure or only part of it
            currentPlayer.addScore(10);
        }
        else if (cell.equals("D")) {
            JOptionPane.showMessageDialog(null, "You fell in a Trap!");
            currentPlayer.addScore(-5);
        }
        else {
            JOptionPane.showMessageDialog(null, "Nothing here");
        }

        field.updateButton(row, col);

        endTurn();
    }
}