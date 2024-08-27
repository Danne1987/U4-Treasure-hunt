package Model;

public interface MapCell {
    boolean isDug();
    void dig();
    boolean containsTreasure();
    boolean containsTrap();
}
