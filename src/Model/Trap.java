package Model;
import java.util.Random;

/**
 * This class represents the traps on the map.
 * @author Daniel & Sarah
 */
public class Trap implements MapCell {
    /**
     * Random for placing traps randomly on the map. Implements the HiddenObject interface
     */
    private static Random random = new Random();
    /**
     * boolean for status if cell has been dug
     */
    private boolean isDug = false;

    /**
     * check if the cell is dug
     * @return
     */
    @Override
    public boolean isDug() {
        return isDug;
    }

    /**
     * change isDug to true when cell has been dug
     */
    @Override
    public void dig() {
        this.isDug = true;
    }

    /**
     * check if cell contains Treasure
     * @return
     */
    @Override
    public boolean containsTreasure() {
        return false;
    }

    /**
     * check if cell contains Trap
     * @return
     */
    @Override
    public boolean containsTrap() {
        return true;
    }
}
