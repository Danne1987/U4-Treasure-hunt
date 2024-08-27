package Model;

public class EmptyCell implements MapCell {
    private boolean isDug = false;
    /**
     * @return
     */
    @Override
    public boolean isDug() {
        return isDug;
    }

    /**
     *
     */
    @Override
    public void dig() {
        this.isDug = true;
    }

    /**
     * @return
     */
    @Override
    public boolean containsTreasure() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean containsTrap() {
        return false;
    }
}
