import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;
    private final Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private String input = "";
    private String commands = "";

    public void start() {
        adventure = new Adventure();
        welcome();
        commands();
    }

    public void welcome() {
        System.out.println("Welcome to \u001b[1mKEA\u001b[0m!\nCan you find the way to the fredagsbar?");
        System.out.println("Type 'help' for all commands.");
    }

    public void commands() {
        while (!input.equals("Exit")) {
            input = scan.nextLine().toLowerCase();

            String[] inputSplit = input.split(" ");
            String command = inputSplit[0];

            if (inputSplit.length > 1){
                commands = inputSplit[1];
            }

            switch (command) {
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

                    if (adventure.getCurrentRoom().getRoomItems().size() > 1) {
                        System.out.println("There is also some items in here: " + adventure.getCurrentRoom().getRoomItems());
                    } else if (adventure.getCurrentRoom().getRoomItems().size() == 1) {
                        System.out.println("There is also an item in here: " + adventure.getCurrentRoom().getRoomItems());
                    }
                    else {
                        System.out.println("There is no items in this room.");
                    }
                }
                case "help", "h" -> {
                    helpMenu();
                }
                case "inventory", "inv" -> {
                    if (adventure.getPlayer().getPlayerInventory().isEmpty()){
                        System.out.println("Your inventory is empty.");
                    }else{
                        System.out.println("Your inventory contains: " + adventure.getPlayer().getPlayerInventory());
                    }
                }
                case "take" -> {
                    Item itemPickedUp = adventure.takeItem(commands);
                    if (itemPickedUp == null){
                        System.out.println("There is no such item..");
                    } else {
                        System.out.println("You have picked up " + itemPickedUp + " in " + adventure.getCurrentRoom().getName());
                    }
                }
                case "drop" -> {
                    Item itemDropped = adventure.dropItem(commands);
                    if (itemDropped == null){
                        System.out.println("There is no such item...");
                    } else {
                        System.out.println("You have dropped " + itemDropped + " in " + adventure.getCurrentRoom().getName());
                    }
                }
                case "exit" -> {
                    System.out.println("Shutting down the adventure...");
                    System.exit(1);
                }
                default -> System.out.println("Error - wrong input. Type 'help' to see commands");
            }
        }
    }

    private void helpMenu() {
        System.out.println("Commands:");
        System.out.println("Type 'help' for commands");
        System.out.println("Type 'look' to look around in the room");
        System.out.println("Type 'north' to go in a northern direction");
        System.out.println("Type 'south' to go in a southern direction");
        System.out.println("Type 'east' to go in an eastern direction");
        System.out.println("Type 'west' to go in a western direction");
        System.out.println("Type 'inventory' to see your current items");
        System.out.println("Type 'take + (the item name)' to take an item in your current room");
        System.out.println("Type 'drop + (the item name)' to drop an item from your inventory in your current room");
        System.out.println("Type 'exit' to quit the adventure");
    }
}