package Model;

public interface HiddenObject extends MapCell {
    String[][] placeOnMap(String[][] map);
    void markDug(String[][] map, int row, int col);
}
