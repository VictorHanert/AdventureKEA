import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);


    public void start() {
        welcome();
    }

    public void welcome() {
        System.out.println("Velkommen til KEA!");
        direction();
    }

    public void direction() {
        String input = "";

        while (!input.equals("Exit")) {
            input = scan.nextLine();
            switch (input) {
                case "North" -> System.out.println("Going North");
                case "South" -> System.out.println("Going south");
                case "East" -> System.out.println("Going east");
                case "West" -> System.out.println("Going west");
                case "Exit" -> {
                    System.exit(1);
                }
                default -> System.out.println("Error");
            }
        }
    }
}