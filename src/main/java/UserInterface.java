import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
    Adventure adventure = new Adventure();

    public void start() {
        adventure.createRooms();
        welcome();
        direction();
    }

    public void welcome() {
        System.out.println("Welcome to \u001b[1mKEA\u001b[0m!\nCan you finde the way to the canteen?");
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
                case "look" -> {
                    System.out.println("Looking around...");
                    System.out.println(adventure.getCurrentRoom().getDescription());
                    System.out.println("So you must be in \u001b[1m" + adventure.getCurrentRoom().getName() + "\u001b[0m");
                }
                case "help" -> {
                    System.out.println("Commands:");
                    System.out.println("Type 'help' for commands");
                    System.out.println("Type 'look' to look around in the room");
                    System.out.println("Type 'north' for going north direction");
                    System.out.println("Type 'south' for going south direction");
                    System.out.println("Type 'east' for going east direction");
                    System.out.println("Type 'west' for going west direction");
                    System.out.println("Type 'exit' for going exiting the adventure");

                }
                case "exit" -> {
                    System.out.println("Shutting down.");
                    System.exit(1);
                }
                default -> System.out.println("Error");
            }
        }
    }
}