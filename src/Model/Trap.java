package Model;
import java.util.Random;


public class Trap {
    static Random random = new Random();
    public static String[][] PlaceTraps(String[][] map)
    {
        boolean validTrapPlace = true;
        int counter = 0;
        while(validTrapPlace)
        {
            int x = random.nextInt(map.length);
            int y = random.nextInt(map[0].length);

            if(map[x][y] != "T")
            {
                map[x][y] = "D";
                counter++;
            }
            if(counter == 3) {
                validTrapPlace = false;
            }
            else {
                validTrapPlace = true;
            }
        }
        return map;
    }
}
