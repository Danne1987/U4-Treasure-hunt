package Model;

public class Map {
    private String[][] map;
    private Treasure[] treasures;
    private Trap[] traps;

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

    public String[][] getMap() {
        return map;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }
}
