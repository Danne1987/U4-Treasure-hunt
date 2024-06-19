package Model;

public interface HiddenObject {

    String[][] placeOnMap(String[][] map);

    void markDug(String[][] map, int row, int col);
}
