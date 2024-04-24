package Model;
import java.util.Objects;
import java.util.Random;


public class Trap {
    static Random random = new Random();
    int x;
    int y;
    public String[][] PlaceTraps(String[][] map)
    {
        boolean validTrapPlace = true;

        while(validTrapPlace)
        {
            x = random.nextInt(map.length);
            y = random.nextInt(map[0].length);

            if(!Objects.equals(map[x][y], "T"))
            {
                map[x][y] = "D";
                validTrapPlace = false;
            }
        }
        return map;
    }
}
