package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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

    private Random random = new Random();

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
            //map = treasures[i].placeOnMap(map);
            placeTreasure(treasures[i]);
        }
        traps = new Trap[3];
        for(int i = 0; i < traps.length; i++) {
            traps[i] = new Trap();
            //traps[i].placeOnMap(map);
            placeTrap(traps[i]);
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

    private void placeTrap(Trap trap) {
        boolean validTrapPlace = false;

        while (!validTrapPlace) {
            int x = random.nextInt(map.length);
            int y = random.nextInt(map[0].length);

            if (map[x][y].isEmpty()) {
                map[x][y] = "D";
                validTrapPlace = true;
            }
        }
    }
    private void placeTreasure(Treasure treasure) {
        boolean isValidPlacement = false;
        int[][] shape = treasure.getShape();
        List<int[]> coordinates = new ArrayList<>();

        do {
            int xCoord = random.nextInt(map.length);
            int yCoord = random.nextInt(map[0].length);

            isValidPlacement = true;
            for (int[] coords : shape) {
                int x = xCoord + coords[0];
                int y = yCoord + coords[1];

                if (x < 0 || x >= map.length || y < 0 || y >= map[0].length || !Objects.equals(map[x][y], "")) {
                    isValidPlacement = false;
                    break;
                }
            }

            if (isValidPlacement) {
                for (int[] coords : shape) {
                    int newX = xCoord + coords[0];
                    int newY = yCoord + coords[1];
                    map[newX][newY] = "T";
                    coordinates.add(new int[]{newX, newY});
                }
                treasure.setCoordinates(coordinates);
            }
        } while (!isValidPlacement);
    }

}
