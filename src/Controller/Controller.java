package Controller;
import View.*;
import Model.*;
import javax.swing.*;

public class Controller{
    private ScoreController scoreController;
    private MapLogic map;
    private PlayField field;
    private Viewer viewer;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameOver = false;


    public Controller(){
        scoreController = new ScoreController();
        map = new MapLogic();
        field = new PlayField(map.getSpelPlan(), this);
        viewer = new Viewer(field, this, scoreController);

        startGame();
    }

    public void startGame() {
        String name1 = JOptionPane.showInputDialog("Enter Name for Player 1:");
        player1 = new Player(name1, 0);
        String name2 = JOptionPane.showInputDialog("Enter Name for Player 2:");
        player2 = new Player(name2, 0);

        currentPlayer = player1;
        viewer.updateCurrentPlayer(currentPlayer.getName());
    }

    public void endGame() {
        String player1Name = player1.getName();
        int player1Score = player1.getScore();

        String player2Name = player2.getName();
        int player2Score = player2.getScore();

        JOptionPane.showMessageDialog(viewer, "Game Over!\n" +
                player1Name + ": " + player1Score + "\n" +
                player2Name + ": " + player2Score);

        scoreController.updateScores(player1Name, player1Score);
        scoreController.updateScores(player2Name, player2Score);
    }

    public void exitGame() {
        System.exit(0);
    }

    public void checkGameOver() {
        boolean allTreasureDug = true;

        String[][] mapSpelPlan = map.getSpelPlan();

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
        }
        else {
            endGame();
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void dig(int row, int col) {
        String[][] mapSpelPlan = map.getSpelPlan();
        String cell = mapSpelPlan[row][col];

        String type = "";
        currentPlayer = getCurrentPlayer();

        if (!cell.equals("DUG")) {
            if (cell.equals("T")) {
                JOptionPane.showMessageDialog(null, "You found Treasure! You get points");
                currentPlayer.addScore(10);
                type = "T";
                for (Treasure treasure : map.getTTests()) {
                    treasure.markDug(mapSpelPlan, row, col);
                    if (treasure.isComplete()){     //(mapSpelPlan)) {
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

    public void isDug(String[][] map, int row, int col) {
        map[row][col] = "DUG";
        System.out.println("The square has been dug");
    }
}
