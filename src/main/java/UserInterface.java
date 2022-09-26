import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public void start() {
        welcome();
        direction();
    }

    public void welcome() {
        System.out.println("Weclome to \u001b[1mKEA\u001b[0m!\nCan you finde the way to the canteen?");
    }

    public void direction() {
        String input = "";

        while (!input.equals("Exit")) {
            input = scan.nextLine().toLowerCase();
            switch (input) {
                case "north" -> System.out.println("Going north");
                case "south" -> System.out.println("Going south");
                case "east" -> System.out.println("Going east");
                case "west" -> System.out.println("Going west");
                case "look" -> System.out.println("Getting the room description and location");
                case "help" -> System.out.println("Get commands and instruction");
                case "exit" -> {
                    System.out.println("Shutting down.");
                    System.exit(1);
                }
                default -> System.out.println("Error");
            }
        }
    }
}