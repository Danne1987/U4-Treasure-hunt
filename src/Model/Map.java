package Model;

/**
 * This class creates the map by placing the treasures and traps.
 * @author Daniel & Sarah
 */
public class Map {
    /**
     * String array used as a map for the game.
     */
    private String[][] map;
    /**
     * Object of treasures, used to place treasures on the map.
     */
    private Treasure[] treasures;
    /**
     * Object of trap, used to place traps on the map.
     */
    private Trap[] traps;

    /**
     * This method draws the map by creating empty slots and then filling them randomly with treasures and traps.
     * @author Daniel & Sarah
     */
    public Map() {
        map = new String[10][10];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = "";
            }
        }
        treasures = new Treasure[5];
        for (int i = 0; i < treasures.length; i++) {
            treasures[i] = new Treasure(i); // Assuming x = 0 for all objects
            map = treasures[i].placeOnMap(map);
        }
        traps = new Trap[3];
        for(int i = 0; i < traps.length; i++) {
            traps[i] = new Trap();
            traps[i].placeOnMap(map);
        }
    }

    /**
     * Returns the map.
     * @return Returns the string array for the map.
     * @author Sarah
     */
    public String[][] getMap() {
        return map;
    }

    /**
     * Returns treasures.
     * @return Returns object of Treasure.
     * @author Sarah
     */
    public Treasure[] getTreasures() {
        return treasures;
    }
}
