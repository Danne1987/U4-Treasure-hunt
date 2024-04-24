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
        Trap.placeTraps(spelPlan);
        //TODO make the trap placement logic, and make sure it does not overlap with treasue
        Treasure.placeTreasures(spelPlan);

    }

    public String[][] getSpelPlan() {
        return spelPlan;
    }
}
