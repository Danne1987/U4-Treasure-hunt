package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * This class places treasures on the map. The shapes are determined by a parameter from when the object was created.
 * @author Daniel & Sarah
 */
public class Treasure implements MapCell {
    /**
     * Random for placing the traps.
     */
    private Random random = new Random();
    /**
     * int array used to determine the shape of the treasure.
     */
    private int[][] shape;
    /**
     * List of coordinates for the placed treasure.
     */
    private List<int[]> coordinates = new ArrayList<>();
    /**
     * Boolean use to check if the entire treasure has been dug up.
     */
    private boolean isCompleted;
    /**
     * Boolean to check which parts of the treasure has been dug up.
     */
    private boolean[] dugPieces;

    private boolean isDug = false;

    /**
     * Constructor which holds the different shapes. Which shape is used is determined by the parameter.
     * @param
     * @author Daniel & Sarah
     */

    public Treasure(MapCell[][] map, int[][] shape) {
        placeOnMap(map, shape);
    }


    public Treasure(int x) {
        if (x == 0) {
            shape = new int[][]{{-1, 0}, {0, 0}, {1, 0}, {1, 1}};
        }
        if (x == 1){
            shape = new int[][]{{0,0}, {1,0}, {2,0}, {3,0}};
        }
        if (x == 2){
            shape = new int[][]{{-1, -1}, {0, -1}, {0, 0}, {0, 1}};
        }
        if (x == 3){
            shape = new int[][]{{0, 0}, {0, -1}, {1, -1}, {1, 0}};
        }
        if (x == 4){
            shape = new int[][]{{0, -1}, {0, 0}, {0, 1}, {1, 1}};
        }
    }



    public static int[][] getShape(int type) {
        switch (type) {
            case 0:
                return new int[][]{{-1, 0}, {0, 0}, {1, 0}, {1, 1}};
            case 1:
                return new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}};
            case 2:
                return new int[][]{{-1, -1}, {0, -1}, {0, 0}, {0, 1}};
            case 3:
                return new int[][]{{0, 0}, {0, -1}, {1, -1}, {1, 0}};
            case 4:
                return new int[][]{{0, -1}, {0, 0}, {0, 1}, {1, 1}};
            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }

    /**
     * This method places the treasures on the map and returns the map.
     * @param map
     * @return Returns the map after treasures have been placed on it.
     * @author Daniel & Sarah
     */
    //@Override
    //public String[][] placeOnMap() {//String[][] map) {
    public void placeOnMap(MapCell[][] map, int[][] shape) {
        //if (shape == null) { return map; }

        boolean isValidPlacement = false;

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
                    //map[newX][newY] = "T";
                    map[newX][newY] = this;
                    coordinates.add(new int[]{newX, newY});
                }
                dugPieces = new boolean[coordinates.size()];
            }
        } while (!isValidPlacement);

        //return map;
    }

    /**
     * This method marks an area on the map as "DUG".
     * @param map
     * @param row
     * @param col
     * @author Sarah
     */
    //@Override
    public void markDug(String[][] map, int row, int col) {
        for (int i = 0; i < coordinates.size(); i++) {
            int[] coords = coordinates.get(i);
            if (coords[0] == row && coords[1] == col) {
                map[row][col] = "DUG";
                dugPieces[i] = true;
                break;
            }
        }
    }

    /**
     * This method checks if the entire trap is dug up.
     * @return Boolean for checking if the treasure has been dug up
     */
    public boolean isComplete(){
        if (isCompleted) {
            return false;
        }
        for (boolean dug : dugPieces) {
            if (!dug) {
                return false;
            }
        }
        isCompleted = true;
        return true;
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
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean containsTrap() {
        return false;
    }
}
