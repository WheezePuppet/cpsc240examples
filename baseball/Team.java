
import java.util.Scanner;

public class Team {
    String city;
    String name;
    int wins, losses;

    Team(Scanner s) throws Exception {
        name = s.nextLine();
        if (name.contains("*")) {
            throw new NoTeamException();
        }
        city = s.nextLine();
        String winloss[] = s.nextLine().split("-");
        wins = Integer.valueOf(winloss[0]);
        losses = Integer.valueOf(winloss[1]);
    }
}
