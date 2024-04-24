package Model;

import java.util.Objects;
import java.util.Random;

public class TreasureTest {
    private int[][] shape;
    int xCoord;
    int yCoord;
    private Random random = new Random();

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
                }
            }
        } while (!isValidPlacement);

        return map;
    }
}