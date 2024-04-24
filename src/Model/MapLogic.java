package Model;

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
        Treasure.placeTreasures(spelPlan); //place treasures
        Trap.PlaceTraps(spelPlan); //place treasures, check if the spaces are filled or not


    }

    public String[][] getSpelPlan() {
        return spelPlan;
    }
}
