
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReservationSystem {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Usage: java ReservationSystem filename.");
            System.exit(2);
        }
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("No such file " + args[0] + ", dummy!");
            System.exit(1);
        }

        String line = s.nextLine();
        while (!hasOnlyDashes(line)) {
            line = s.nextLine();
        }

        Resort firstResort = new Resort(s);
        System.out.println(firstResort);

        // to be continued...
    }

    private static boolean hasOnlyDashes(String x) {
        if (x.length() == 0) {
            return false;
        }
        for (int i=0; i<x.length(); i++) {
            if (x.charAt(i) != '-') {
                return false;
            }
        }
        return true;
    }
}
