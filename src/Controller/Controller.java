package Controller;
import View.*;
import Model.*;

public class Controller{
    MapLogic map = new MapLogic();
    //Treasure treasure = new Treasure(map.getSpelPlan());
    PlayField field = new PlayField(map.getSpelPlan());
    Viewer viewer = new Viewer(field);

}