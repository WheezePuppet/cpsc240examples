
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ReservationSystem {

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Usage: java ReservationSystem filename.");
            System.exit(1);   // the 1 means nothing. ignore it.
        }
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("No such file " + args[0] + ", dummy!");
            System.exit(1);   // the 1 means nothing. ignore it.
        }

        String line = s.nextLine();
        while (!hasOnlyDashes(line)) {
            line = s.nextLine();
        }

        // Let's make an ArrayList of Resort objects, and hydrate them from
        // the file.
        ArrayList<Resort> resorts = new ArrayList<Resort>();

        try {
            while (true) {
                Resort r = new Resort(s);
                resorts.add(r);
            }
        } catch (NoResortException e) { 
            // This catch block left intentionally blank!
        }

        System.out.println("We successfully read " + resorts.size() +
            " resorts!");

        // Now let's persist them back to a (different) file.
        try {
            PrintWriter pw = new PrintWriter("some_data.out");
            for (Resort r: resorts) {
                r.store(pw);
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("We got an error! " + e);
        }
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
