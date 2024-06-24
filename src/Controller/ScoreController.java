package Controller;
import Model.ScoreEntry;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The ScoreController class. It keeps track of the high-score by reading and writing to a txt-file.
 * @author Sarah
 */
public class ScoreController {
    /**
     * String that contains the path to the highscore list.
     */
    private static final String HIGHSCORE_FILE_PATH = "files/Highscore.txt";

    /**
     * This method reads the names and score from the highscore txt-file.
     * @return Returns a list of players and their score
     * @author Sarah
     */
    public List<ScoreEntry> readScores() {
        List<ScoreEntry> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(HIGHSCORE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String playerName = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    scores.add(new ScoreEntry(playerName, score));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return scores;
    }

    /**
     * This method writes new high-scores achieved by players to the highscore txt-file.
     * @param scores
     * @author Sarah
     */
    public void writeScores(List<ScoreEntry> scores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HIGHSCORE_FILE_PATH))) {
            for (ScoreEntry score : scores) {
                writer.write(score.getPlayerName() + ": " + score.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Goes through the highscore list and compares to a new score achieved by the players to properly place the new score in the list.
     * @param playerName
     * @param score
     * @author Sarah
     */
    public void updateScores(String playerName, int score) {
        List<ScoreEntry> scores = readScores();
        scores.add(new ScoreEntry(playerName, score));
        scores.sort(Comparator.comparingInt(ScoreEntry::getScore).reversed());

        if (scores.size() > 10) {
            scores = scores.subList(0, 10);
        }
        writeScores(scores);
    }

    /**
     * This method gets the highscore list and returns it.
     * @return Returns the highscore list.
     * @author Sarah
     */
    public String getHighscoreList() {
        List<ScoreEntry> scores = readScores();
        StringBuilder highscoreList = new StringBuilder("Highscores: \n");
        for (ScoreEntry score : scores) {
            highscoreList.append(score.getPlayerName()).append(": ").append(score.getScore()).append("\n");
        }
        return highscoreList.toString();
    }

}

