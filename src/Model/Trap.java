package Model;
import java.util.Random;


public class Trap {
    Random random = new Random();
    public String[][] PlaceTraps(String[][] map)
    {
        boolean pt = true;
        while(pt)
        {
            int x = randomizer();
            int y = randomizer();

            if(map[x][y] != "T")
            {
                map[x][y] = "D";
                pt = false;
            }
        }
        return map;
    }

    public int randomizer()
    {
        int x = random.nextInt(10);
        return x;
    }

}
