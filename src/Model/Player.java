package Model;

/**
 * The Player class. It contains a player name and score.
 * @author Daniel & Sarah
 */
public class Player {
    /**
     * A string containing the player name.
     */
    private String name;
    /**
     * An int containing the players score.
     */
    private int score;

    /**
     * Constructor for the Player class.
     * @param name
     * @param score
     * @author Daniel & Sarah
     */
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Returns players name.
     * @return String containing players name.
     * @author Sarah
     */
    public String getName() {
        return name;
    }

    /**
     * Returns player score
     * @return int containing player score
     * @author Sarah
     */
    public int getScore() {
        return score;
    }

    /**
     * Method to add score to the player
     * @param points the score that will be added
     * @author Sarah
     */
    public void addScore(int points) {
        score += points;
    }
}
