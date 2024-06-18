package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TreasureTest {
    private Random random = new Random();
    private int[][] shape;
    int xCoord;
    int yCoord;
    private List<int[]> coordinates = new ArrayList<>();
    private boolean isCompleted;
    private boolean[] dugPieces;

    public TreasureTest(int x) {
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

    public String[][] returnTreasureToMap(String[][] map) {
        if (shape == null) {
            return map;
        }

        boolean isValidPlacement = false;

        do {
            xCoord = random.nextInt(map.length);
            yCoord = random.nextInt(map[0].length);

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
                dugPieces = new boolean[coordinates.size()];
            }
        } while (!isValidPlacement);

        return map;
    }

    public void markDug(String[][] map, int row, int col) {
        for (int i = 0; i < coordinates.size(); i++) {
            int[] coords = coordinates.get(i);
            if (coords[0] == row && coords[1] == col) {
                map[row][col] = "DUG";
                dugPieces[i] = true;
                break;
            }
        }


        /*
        for(int[] coord : coordinates) {
            if (coord[0] == row && coord[1] == col) {
                map[row][col] = "DUG";
                break;
            }
        }

         */
    }

    public boolean isComplete(){ //String[][] map) {
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

        /*
        for (int[] coord : coordinates) {
            if(!map[coord[0]][coord[1]].equals("DUG")) {
                return false;
            }
        }
        return true;

         */
    }
}