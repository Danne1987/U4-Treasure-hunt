package Controller;
import java.io.*;

public class ScoreController {

    public void writeToFile(){
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("files/Highscore.txt")))){
            writer.write("Testing!!!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
