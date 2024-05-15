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

    public Controller(){
        scoreController = new ScoreController();
        map = new MapLogic();
        scoreController.writeToFile();
        field = new PlayField(map.getSpelPlan());
        viewer = new Viewer(field);
        String name1 = JOptionPane.showInputDialog("Enter Name for Player 1:");
        player1 = new Player(name1, 0);
        String name2 = JOptionPane.showInputDialog("Enter Name for Player 2:");
        player2 = new Player(name2, 0);
    }
}