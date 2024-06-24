package Model;

/**
 * This class keeps track of a player name and the players score for entry
 * @author Sarah
 */
public class ScoreEntry {
    /**
     * String containing player name.
     */
    private String playerName;
    /**
     * int containing player score
     */
    private int score;

    /**
     * Constructor for the ScoreEntry class, sets playerName and score
     * @param playerName
     * @param score
     * @author Sarah
     */
    public ScoreEntry(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    /**
     * Returns players name
     * @return String containing players name
     * @author Sarah
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Returns players score
     * @return int containing players score
     * @author Sarah
     */
    public int getScore() {
        return score;
    }
}
