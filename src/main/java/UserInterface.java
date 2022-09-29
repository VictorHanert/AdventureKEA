import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;
    private final Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public void start() {
        adventure = new Adventure();
        welcome();
        direction();
    }

    public void welcome() {
        System.out.println("Welcome to \u001b[1mKEA\u001b[0m!\nCan you find the way to the fredagsbar?");
    }

    public void direction() {
        String input = "";
        while (!input.equals("Exit")) {
            input = scan.nextLine().toLowerCase();
            switch (input) {
                case "n":
                case "north":
                case "go north":
                    System.out.println("Going north");
                    adventure.go("north");
                break;
                case "s":
                case "south":
                case "go south":
                    System.out.println("Going south");
                    adventure.go("south");
                break;
                case "e":
                case "east":
                case "go east":
                    System.out.println("Going east");
                    adventure.go("east");
                break;
                case "w":
                case "west":
                case "go west":
                    System.out.println("Going west");
                    adventure.go("west");
                break;
                case "look":
                    System.out.println("Looking around...");
                    System.out.println(adventure.getCurrentRoom().getDescription());
                    System.out.println(" ");
                    System.out.println("So you must be in \u001b[1m" + adventure.getCurrentRoom().getName() + "\u001b[0m");
                break;
                case "help":
                case "h":
                    System.out.println("Commands:");
                    System.out.println("Type 'help' for commands");
                    System.out.println("Type 'look' to look around in the room");
                    System.out.println("Type 'north' to go in a northern direction");
                    System.out.println("Type 'south' to go in a southern direction");
                    System.out.println("Type 'east' to go in an eastern direction");
                    System.out.println("Type 'west' to go in a western direction");
                    System.out.println("Type 'exit' to exit the adventure");
                break;
                case "inventory":
                case "inv":
                    System.out.println("Here is your inventory: ");
                    System.out.println(adventure.getCurrentRoom().getItemName());
                break;
                case "take":
                    System.out.println("Take the item.");
                break;
                case "drop":
                    System.out.println("Drop the item.");
                break;
                case "exit":
                    System.out.println("Shutting down.");
                    System.exit(1);
                break;
                default:
                    System.out.println("Error - wrong input. Type 'help' to see commands");
                break;
            }
        }
    }
}