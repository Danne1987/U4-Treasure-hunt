package Model;

import java.util.Objects;
import java.util.Random;

public class Treasure {
    public static void placeTreasures(String[][] map) {
        // Define tetris-like shapes
        int[][][] shapes = {
                {{-1, 0}, {0, 0}, {1, 0}, {1, 1}}, //standing L-block
                {{-1, 1}, {-1, 0}, {0, 0}, {1, 0}}, //standing J-block
                {{0, -1}, {0, 0}, {0, 1}, {1, 1}}, // pointing down J-block
                {{-1, -1}, {0, -1}, {0, 0}, {0, 1}}, // J-block normal
                {{0, 0}, {1, 0}, {-1, 1}, {0, 1}}, //standing "Z"
                {{0, 0}, {0, -1}, {1, -1}, {1, 0}}, //square
                {{0,0}, {1,0}, {2,0}, {3,0}} // Straight up I-block

        };

        // Place treasures on the map
        Random random = new Random();

        for (int[][] shape : shapes) {
            boolean isValidPlacement = false;

            while (!isValidPlacement) {
                int startX = random.nextInt(map.length);
                int startY = random.nextInt(map[0].length);

                isValidPlacement = true; //true until proven false
                for (int[] coords : shape) {
                    int x = coords[0] + startX;
                    int y = coords[1] + startY;

                    //check if out of bounds, or if there is already something else there
                    if (x < 0 || x >= map.length || y < 0 || y >= map[0].length || !Objects.equals(map[x][y], "")) {
                        isValidPlacement = false; //there was something on the index or it ended out of bounds
                        break;
                    }
                }
                if (isValidPlacement) { //nothing out of bounds or filled in the previous check
                    for (int[] coords : shape) {
                        int newX = coords[0] + startX;
                        int newY = coords[1] + startY;
                        map[newX][newY] = "T";
                    }
                }
            }
        }


        /*
        for (int[][] shape : shapes) {
            int startX = random.nextInt(map.length);
            int startY = random.nextInt(map[0].length);
            for (int[] coord : shape) {
                int x = coord[0];
                int y = coord[1];

                int newX = startX + x;
                int newY = startY + y;

                //int newX = x + map.length / 2; // Adjusting to place shape in the middle of the map
                //int newY = y + map[0].length / 2; // Adjusting to place shape in the middle of the map

                if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length) {
                    map[newX][newY] = "T"; // Place 'T' to represent treasure
                }
            }
        }

         */
    }
}