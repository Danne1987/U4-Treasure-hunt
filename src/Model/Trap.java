package Model;
import java.util.Objects;
import java.util.Random;


public class Trap implements HiddenObject {
    private static Random random = new Random();

    /**
     * @param map
     * @return
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
     * @param map
     * @param row
     * @param col
     */
    @Override
    public void markDug(String[][] map, int row, int col) {
        map[row][col] = "DUG";
    }
}
