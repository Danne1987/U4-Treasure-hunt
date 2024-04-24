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
                spelPlan[i][j] = "0";
            }
        }
        Treasure.placeTreasures(spelPlan);
    }

    public String[][] getSpelPlan() {
        return spelPlan;
    }
}
