package Controller;
import View.*;
import Model.*;

import javax.swing.*;

public class Controller{
    MapLogic map = new MapLogic();
    //Treasure treasure = new Treasure(map.getSpelPlan());
    PlayField field = new PlayField(map.getSpelPlan());
    Viewer viewer = new Viewer(field);

    String name1 = JOptionPane.showInputDialog("Enter Name for Player 1:");
    Player player1 = new Player(name1, 0);

    String name2 = JOptionPane.showInputDialog("Enter Name for Player 2:");
    Player player2 = new Player(name2, 0);

}