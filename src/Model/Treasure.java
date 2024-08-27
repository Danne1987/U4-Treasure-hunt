package Model;

import java.util.Random;

/**
 * This class represents treasures on the map. The shapes are determined by a parameter from when the object was created.
 * @author Daniel & Sarah
 */
public class Treasure implements MapCell {
    /**
     * Random for placing the traps.
     */
    private Random random = new Random();
    /**
     * int array used to determine the shape of the treasure.
     */
    private int[][] shape;
    /**
     * X-coordinates
     */
    private int xCoord;
    /**
     * Y-coordinates
     */
    private int yCoord;
    /**
     * Boolean use to check if the entire treasure has been dug up.
     */
    private boolean isCompleted;
    /**
     * Boolean to check which parts of the treasure has been dug up.
     */
    private boolean[] dugPieces;
    /**
     * Boolean for state of cell to check if it has been dug
     */
    private boolean isDug = false;
    /**
     * Integer to count amount of dug pieces in one treasure
     */
    private int dugPiece = 0;
    /**
     * Constructor which holds the different shapes. Which shape is used is determined by the parameter.
     * @param
     * @author Daniel & Sarah
     */
    public Treasure(int x) {
        if (x == 0) {
            shape = new int[][]{{-1, 0}, {0, 0}, {1, 0}, {1, 1}};
        }
        if (x == 1){
            shape = new int[][]{{0,0}, {1,0}, {2,0}, {3,0}};
        }
        if (x == 2){
            shape = new int[][]{{-1, -1}, {0, -1}, {0, 0}, {0, 1}};
        }
        if (x == 3){
            shape = new int[][]{{0, 0}, {0, -1}, {1, -1}, {1, 0}};
        }
        if (x == 4){
            shape = new int[][]{{0, -1}, {0, 0}, {0, 1}, {1, 1}};
        }
    }

    /**
     * Method to add amount of dug pieces within a treasure
     */
    public void addDugPieces() {
        dugPiece++ ;
    }

    /**
     * Returns how many pieces of a treasure has been dug
     * @return dugPiece
     */
    public int getDugPiece() {
        return dugPiece;
    }

    /**
     * Check if the cell is dug
     * @return boolean
     */
    @Override
    public boolean isDug() {
        return isDug;
    }

    /**
     * Sets the isDug boolean to true when a cell has been dug
     */
    public void dig() {
        this.isDug = true;
    }

    /**
     * Check cell contents for Treasure
     * @return boolean
     */
    @Override
    public boolean containsTreasure() {
        return true;
    }

    /**
     * Check cell contents for Trap
     * @return
     */
    @Override
    public boolean containsTrap() {
        return false;
    }

    /**
     * Method to return the treasure shape
     * @return int[][]
     */
    public int[][] getShape() {
        return shape;
    }

    /**
     * Sets the X-coordinate
     * @param xCoord
     */
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     * Sets the Y-coordinate
     * @param yCoord
     */
    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    /**
     * Gets the X-coordinate
     * @return
     */
    public int getXCoord() {
        return xCoord;
    }

    /**
     * Gets the Y-coordinate
     * @return
     */
    public int getYCoord() {
        return yCoord;
    }
}


