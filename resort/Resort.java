
import java.util.Scanner;

class Resort {

    private String name;
    private String phone;
    private int rating;
    private String description;

    Resort(Scanner s) {
        this.name = s.nextLine();
        this.phone = s.nextLine();
        this.rating = Integer.valueOf(s.nextLine());

        String line = s.nextLine();
        while (!line.equals(".")) {
            this.description = this.description + line + "\n";
            line = s.nextLine();
        }
    }

}
