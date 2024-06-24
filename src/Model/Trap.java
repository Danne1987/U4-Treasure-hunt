package Model;
import java.util.Objects;
import java.util.Random;

/**
 * This class creates the traps on the map.
 * @author Daniel & Sarah
 */
public class Trap implements HiddenObject {
    /**
     * Random for placing traps randomly on the map. Implements the HiddenObject interface
     */
    private static Random random = new Random();

    /**
     * This method places the trap on the map
     * @param map For having something to place the traps on
     * @return Returns the modified map
     * @author Daniel & Sarah
     */
    @Override
    public String[][] placeOnMap(String[][] map) {
        boolean validTrapPlace = true;

        while(validTrapPlace) {
            int x = random.nextInt(map.length);
            int y = random.nextInt(map[0].length);

            if(!Objects.equals(map[x][y], "T")) {
                map[x][y] = "D";
                validTrapPlace = false;
            }
        }
        return map;
    }

    /**
     * Marks a dug area on the map as "DUG"
     * @param map
     * @param row
     * @param col
     * @author Sarah
     */
    @Override
    public void markDug(String[][] map, int row, int col) {
        map[row][col] = "DUG";
    }
}
