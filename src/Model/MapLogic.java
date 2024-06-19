package Model;

public class MapLogic {
    private String[][] spelPlan;
    private Treasure[] treasures;
    private Trap[] traps;

    public MapLogic() {
        spelPlan = new String[10][10];
        for(int i = 0; i < spelPlan.length; i++) {
            for(int j = 0; j < spelPlan[i].length; j++) {
                spelPlan[i][j] = "";
            }
        }
        treasures = new Treasure[5];
        for (int i = 0; i < treasures.length; i++) {
            treasures[i] = new Treasure(i); // Assuming x = 0 for all objects
            spelPlan = treasures[i].placeOnMap(spelPlan);
        }
        //Treasure.placeTreasures(spelPlan); //place treasures
        traps = new Trap[3];
        for(int i = 0; i < traps.length; i++) {
            traps[i] = new Trap();
            traps[i].placeOnMap(spelPlan);
        }
    }

    public String[][] getSpelPlan() {
        return spelPlan;
    }

    public Treasure[] getTTests() {
        return treasures;
    }
}
