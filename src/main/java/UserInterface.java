import java.util.ArrayList;
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
                case "go north","north", "n" -> {
                    if (adventure.go("north")){
                        System.out.println("Going north");
                    }else{
                        System.out.println("You cannot go that way");
                    }
                }
                case "go south","south", "s" -> {
                    if (adventure.go("south")){
                        System.out.println("Going south");
                    }else{
                        System.out.println("You cannot go that way");
                    }
                }
                case "go east","east","e" -> {
                    if (adventure.go("east")){
                        System.out.println("Going east");
                    }else{
                        System.out.println("You cannot go that way");
                    }
                }
                case "go west","west","w" -> {
                    if (adventure.go("west")){
                        System.out.println("Going west");
                    }else{
                        System.out.println("You cannot go that way");
                    }
                }
                case "look" -> {
                    System.out.println("Looking around...");
                    System.out.println(adventure.getCurrentRoom().getDescription());
                    System.out.println("\nSo you must be in \u001b[1m" + adventure.getCurrentRoom().getName() + "\u001b[0m");
                }
                case "help", "h" -> {
                    System.out.println("Commands:");
                    System.out.println("Type 'help' for commands");
                    System.out.println("Type 'look' to look around in the room");
                    System.out.println("Type 'north' to go in a northern direction");
                    System.out.println("Type 'south' to go in a southern direction");
                    System.out.println("Type 'east' to go in an eastern direction");
                    System.out.println("Type 'west' to go in a western direction");
                    System.out.println("Type 'exit' to exit the adventure");
                }
                case "inventory", "inv" -> {
                    System.out.println("Here is your inventory: ");
                    System.out.println("Items: " + adventure.getCurrentRoom().getRoomItems());
                }
                case "take" -> System.out.println("Take the item.");
                case "drop" -> System.out.println("Drop the item.");
                case "exit" -> {
                    System.out.println("Shutting down the adventure...");
                    System.exit(1);
                }
                default -> System.out.println("Error - wrong input. Type 'help' to see commands");
            }
        }
    }
}