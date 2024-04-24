package Model;

import java.util.TreeSet;

public class MapLogic {
    String[][] spelPlan;
    public MapLogic()
    {
        spelPlan = new String[10][10];
        for(int i = 0; i < spelPlan.length; i++)
        {
            for(int j = 0; j < spelPlan[i].length; j++)
            {
                spelPlan[i][j] = "";
            }
        }
        //TODO make the trap placement logic, and make sure it does not overlap with treasure
        Treasure.placeTreasures(spelPlan);
        //Trap.placeTraps(spelPlan);


    }

    public String[][] getSpelPlan() {
        return spelPlan;
    }
}
