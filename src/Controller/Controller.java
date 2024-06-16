package Controller;
import View.*;
import Model.*;
import javax.swing.*;

public class Controller{
    ScoreController scoreController;
    MapLogic map;
    //Treasure treasure = new Treasure(map.getSpelPlan());
    PlayField field;
    Viewer viewer;
    Player player1;
    Player player2;
    private Player currentPlayer;
    private boolean gameOver = false;


    public Controller(){
        scoreController = new ScoreController();
        map = new MapLogic();
        scoreController.writeToFile();
        field = new PlayField(map.getSpelPlan());
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



        endTurn();
    }
}