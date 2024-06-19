package Controller;
import Model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreController {
    private static final String HIGHSCORE_FILE_PATH = "files/Highscore.txt";

    /*
    public void writeToFile(String playerName, int score){
        try(BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(HIGHSCORE_FILE_PATH, true)))){
            writer.write(playerName + ": " + score);
            writer.newLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    public void updateScores(String playerName, int score) {
        List<ScoreEntry> scores = readScores();
        scores.add(new ScoreEntry(playerName, score));
        scores.sort(Comparator.comparingInt(ScoreEntry::getScore).reversed());

        if (scores.size() > 10) {
            scores = scores.subList(0, 10);
        }
        writeScores(scores);
    }
}

class ScoreEntry {
    private String playerName;
    private int score;

    public ScoreEntry(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }
}