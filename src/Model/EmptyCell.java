package Model;

public class EmptyCell implements MapCell {
    private boolean isDug = false;
    /**
     * Check if cell has been dug
     * @return boolean
     */
    @Override
    public boolean isDug() {
        return isDug;
    }

    /**
     * Change boolean isDug to true
     */
    @Override
    public void dig() {
        this.isDug = true;
    }

    /**
     * Check if cell contains Treasure
     * @return boolean
     */
    @Override
    public boolean containsTreasure() {
        return false;
    }

    /**
     * Check if cell contains Trap
     * @return boolean
     */
    @Override
    public boolean containsTrap() {
        return false;
    }
}
