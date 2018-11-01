
import java.io.*;
import java.util.*;

public class Simulator {
    public static void main(String args[]) {
        Hashtable<String,Team> teams = new Hashtable<String,Team>();
        ArrayList<Ballplayer> players = new ArrayList<Ballplayer>();

        try {
            Scanner s = new Scanner(new FileReader("1941.data"));

            s.nextLine();
            s.nextLine();
            s.nextLine();
            s.nextLine();
            boolean moreTeams = true;
            while (moreTeams) {
                try {
                    Team t = new Team(s);
                    teams.put(t.name, t);
                } catch (NoTeamException e) {
                    moreTeams = false;
                }
            }
            boolean morePlayers = true;
            while (morePlayers) {
                try {
                    Ballplayer b = new Ballplayer(s);
                    players.add(b);
                } catch (NoPlayerException e) {
                    morePlayers = false;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Here are my players:");
        for (Ballplayer p: players) {
            System.out.println(p);
        }
    }
}
