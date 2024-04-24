package Model;

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
                {{0, 0}, {1, 0}, {-1, 1}, {0, 1}},
                {{0, 0}, {0, -1}, {1, -1}, {1, 0}}
                // Define more shapes as needed
        };

        // Place treasures on the map
        for (int[][] shape : shapes) {
            for (int[] coord : shape) {
                int x = coord[0];
                int y = coord[1];
                int newX = x + map.length / 2; // Adjusting to place shape in the middle of the map
                int newY = y + map[0].length / 2; // Adjusting to place shape in the middle of the map

                if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length) {
                    map[newX][newY] = "T"; // Place 'T' to represent treasure
                }
            }
        }

        return map;
    }
}