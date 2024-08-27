package Model;
import java.util.Objects;
import java.util.Random;

/**
 * This class creates the traps on the map.
 * @author Daniel & Sarah
 */
public class Trap implements MapCell {
    /**
     * Random for placing traps randomly on the map. Implements the HiddenObject interface
     */
    private static Random random = new Random();

    private boolean isDug = false;

    /**
     * This method places the trap on the map
     * @param map For having something to place the traps on
     * @return Returns the modified map
     * @author Daniel & Sarah
     */
    //@Override
    //public String[][] placeOnMap(String[][] map) {
    public void placeOnMap(MapCell[][] map) {
        boolean validTrapPlace = true;

        while(validTrapPlace) {
            int x = random.nextInt(map.length);
            int y = random.nextInt(map[0].length);

            //if(!Objects.equals(map[x][y], "T")) {
            if(!map[x][y].containsTreasure() && !map[x][y].containsTrap()) {
                //map[x][y] = "D";
                map[x][y] = this;
                validTrapPlace = false;
            }
        }
        //return map;
    }

    /**
     * Marks a dug area on the map as "DUG"
     * @param map
     * @param row
     * @param col
     * @author Sarah
     */
    //@Override
    public void markDug(String[][] map, int row, int col) {
        map[row][col] = "DUG";
    }

    /**
     * @return
     */
    @Override
    public boolean isDug() {
        return isDug;
    }

    /**
     *
     */
    @Override
    public void dig() {
        this.isDug = true;
    }

    /**
     * @return
     */
    @Override
    public boolean containsTreasure() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean containsTrap() {
        return true;
    }
}
