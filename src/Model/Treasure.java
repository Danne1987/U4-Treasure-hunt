package Model;

import java.util.Random;

public class Treasure {
    public static String[][] placeTreasures(String[][] map) {
        // Define tetris-like shapes
        int[][][] shapes = {
                // L shape
                {{-1, 0}, {0, 0}, {1, 0}, {1, 1}},
                {{0, -1}, {0, 0}, {0, 1}, {1, 1}},
                {{-1, 1}, {-1, 0}, {0, 0}, {1, 0}},
                {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
                // S shape
                //{{0, 0}, {1, 0}, {-1, 1}, {0, 1}},
                //{{0, 0}, {0, -1}, {1, -1}, {1, 0}},

                //Straight shape
                {{0,0}, {1,0}, {2,0}, {3,0}}


        };

        // Place treasures on the map
        Random random = new Random();
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

        return map;
    }
}