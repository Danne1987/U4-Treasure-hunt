package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private MapCell[][] map;
    private Treasure[] treasures;
    private Trap[] traps;
    private Random random = new Random();
    private List<int[]> coordinates = new ArrayList<>();

    public Map() {
        map = new MapCell[10][10];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new EmptyCell();
                System.out.println("placed an empty space");
            }
        }

        treasures = new Treasure[5];
        for (int i = 0; i < treasures.length; i++) {
            treasures[i] = new Treasure(i);
            int[][] shape = treasures[i].getShape();
            placeTreasureOnMap(treasures[i], map, shape);
            System.out.println("placed a treasure");
        }

        traps = new Trap[3];
        for (int i = 0; i < traps.length; i++) {
            int[][] shape = {{0, 0}};
            traps[i] = new Trap();
            placeTrapOnMap(traps[i], map, shape);
            System.out.println("placed a trap");
        }
    }

    public MapCell[][] getMap() {
        return map;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void placeTreasureOnMap(Treasure treasure, MapCell[][] map, int[][] shape) {
        boolean isValidPlacement = false;

        do {
            int xCoord = random.nextInt(map.length);
            int yCoord = random.nextInt(map[0].length);
            treasure.setXCoord(xCoord);
            treasure.setYCoord(yCoord);

            System.out.println(xCoord);
            System.out.println(yCoord);

            isValidPlacement = true;
            for (int[] coords : shape) {
                int x = xCoord + coords[0];
                int y = yCoord + coords[1];

                if (x < 0 || x >= map.length || y < 0 || y >= map[0].length || !(map[x][y] instanceof EmptyCell)) {
                    isValidPlacement = false;
                    break;
                }
            }

            if (isValidPlacement) {
                for (int[] coords : shape) {
                    int newX = xCoord + coords[0];
                    int newY = yCoord + coords[1];
                    map[newX][newY] = treasure;
                    coordinates.add(new int[]{newX, newY});
                }
            }
        } while (!isValidPlacement);
    }
    public void placeTrapOnMap(Trap trap, MapCell[][] map, int[][] shape) {
        boolean isValidPlacement = false;

        do {
            int xCoord = random.nextInt(map.length);
            int yCoord = random.nextInt(map[0].length);

            System.out.println(xCoord);
            System.out.println(yCoord);

            isValidPlacement = true;
            for (int[] coords : shape) {
                int x = xCoord + coords[0];
                int y = yCoord + coords[1];

                if (x < 0 || x >= map.length || y < 0 || y >= map[0].length || !(map[x][y] instanceof EmptyCell)) {
                    isValidPlacement = false;
                    break;
                }
            }

            if (isValidPlacement) {
                for (int[] coords : shape) {
                    int newX = xCoord + coords[0];
                    int newY = yCoord + coords[1];
                    map[newX][newY] = trap;
                    coordinates.add(new int[]{newX, newY});
                }
            }
        } while (!isValidPlacement);
    }
}