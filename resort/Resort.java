
import java.util.Scanner;
import java.io.PrintWriter;

class Resort {

    private String name;
    private String phone;
    private int rating;
    private int price;
    private String description;

    // Hydrate a Resort object from a Scanner that is queued up to point to
    // the beginning of a resort entry. If no such object can be created
    // (since we're at the end of the file) throw an Exception instead.
    Resort(Scanner s) throws NoResortException {
        this.name = s.nextLine();
        if (this.name.equals("END")) {
            throw new NoResortException();
        }
        this.phone = s.nextLine();
        this.rating = Integer.valueOf(s.nextLine());
        this.price = s.nextLine().length();

        this.description = "";
        String line = s.nextLine();
        while (!line.equals(".")) {
            this.description = this.description + line + "\n";
            line = s.nextLine();
        }
    }

    // Persist this Resort object to the PrintWriter passed. Store it in
    // exactly the same format that we hydrate from.
    public void store(PrintWriter pw) {
        pw.println(this.name + "\n" + this.phone + "\n" + this.rating);
        String dollars = "";
        for (int i=0; i<price; i++) {
            dollars += "$";
        }
        pw.println(dollars + "\n" + this.description);
    }

    public String toString() {
        return this.name + " (" + this.rating + " stars)";
    }
}

