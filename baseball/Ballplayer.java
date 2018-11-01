
import java.util.Scanner;

public class Ballplayer {
    String name;
    String team;
    double battingAvg;
    int hrs;
    int rbis;

    Ballplayer(Scanner s) throws Exception {
        String st = s.nextLine();
        if (!st.contains(",")) {
            throw new NoPlayerException();
        }
        String parts[] = st.split(",");
        name = parts[0];
        team = parts[1];
        battingAvg = Double.valueOf(parts[2]);
        hrs = Integer.valueOf(parts[3]);
        rbis = Integer.valueOf(parts[4]);
    }

    public String toString() {
        return name + " (" + battingAvg + "," + hrs + "," + rbis + ")";
    }
}
