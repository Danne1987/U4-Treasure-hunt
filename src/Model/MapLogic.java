package Model;

public class MapLogic {
    String[][] spelPlan;
    TreasureTest[] tTests;
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
        tTests = new TreasureTest[5];
        for (int i = 0; i < tTests.length; i++) {
            tTests[i] = new TreasureTest(i); // Assuming x = 0 for all objects
            spelPlan = tTests[i].returnTreasureToMap(spelPlan);
        }
        //Treasure.placeTreasures(spelPlan); //place treasures
        Trap.PlaceTraps(spelPlan); //place treasures, check if the spaces are filled or not


    }

    public String[][] getSpelPlan() {
        return spelPlan;
    }
}
