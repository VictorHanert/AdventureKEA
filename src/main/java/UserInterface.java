import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;
    private final Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public void start() {
        adventure = new Adventure();
        String input = "";
        welcome();
        userInput(input);
    }

    public void welcome() {
        System.out.println("Welcome to \u001b[1mKEA\u001b[0m!\nCan you find the way to the fredagsbar?");
        System.out.println("Type 'help' for all commands.");
    }

    public void userInput(String input) {
        boolean gameRunning = true;
        while (gameRunning) {
            input = scan.nextLine().toLowerCase();

            String[] inputSplit = input.split(" ");
            String userChoice = "";
            String command = inputSplit[0];

            if (inputSplit.length > 1){
                userChoice = inputSplit[1];
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
                case "look" -> lookInTheRoom();
                case "help", "h" -> helpMenu();
                case "inventory", "inv" -> {
                    if (adventure.getPlayer().getPlayerInventory().isEmpty()){
                        System.out.println("Your inventory is empty.");
                    }else{
                        System.out.println("Your inventory contains:");
                        for (Item item : adventure.getPlayer().getPlayerInventory()) {
                            System.out.println("A \u001b[1m" + item.getItemName() +"\u001b[0m - "+ item.getItemDescription());
                        }
                    }
                }
                case "take", "add", "pick" -> {
                    Item itemPickedUp = adventure.takeItem(userChoice);
                    if (itemPickedUp == null){
                        System.out.println("There is no item in the room of that name.");
                    } else {
                        System.out.println("You pick up: " + "\u001b[1m" + itemPickedUp + "\u001b[0m");
                    }
                }
                case "drop" -> {
                    Item itemDropped = adventure.dropItem(userChoice);
                    if (itemDropped != null){
                        System.out.println("You drop: " + "\u001b[1m" +  itemDropped + "\u001b[0m");
                        adventure.getPlayer().getCurrentRoom().addItem(itemDropped);
                    } else {
                        System.out.println("You have no item of that name.");
                    }
                }
                case "health", "hp" -> {
                    System.out.println("Your health: " + adventure.getPlayer().getPlayerHp());
                    if (adventure.getPlayer().getPlayerHp() < 25) {
                        System.out.println("Your health are at a critical level!");
                    } else if (adventure.getPlayer().getPlayerHp() < 50 && adventure.getPlayer().getPlayerHp() > 25) {
                        System.out.println("Your health are a little low, avoid fighting now...");
                    } else {
                        System.out.println("Your health is good, you can go in battle!");
                    }
                }
                case "eat" -> {
                    Status result = adventure.playerEat(userChoice);
                    switch (result) {
                        case OK -> {
                            System.out.println("Eating " + userChoice);
                            System.out.println("Current hp: " + adventure.getPlayer().getPlayerHp());
                        }
                        case NOT_OK -> System.out.println("You cant eat a " + userChoice);
                        case NOT_FOUND -> System.out.println("No item was found: " + userChoice);
                    }
                }
                case "equip", "use" -> {
                    Status result = adventure.playerEquip(userChoice);
                    switch (result) {
                        case OK -> {
                            System.out.println("Equipping the weapon \u001b[1m" + userChoice + "\u001b[0m");
                            System.out.println("Current damage pr. hit: " + adventure.getPlayer().getPlayerDamage());
                        }
                        case NOT_OK -> System.out.println("You cant equip a " + userChoice);
                        case NOT_FOUND -> System.out.println("No item was found with the name: " + userChoice);
                    }
                }
                case "attack", "kill", "fight" -> {
                    if (adventure.playerEquip(userChoice) != null) {
                        System.out.println("Attacking the enemy...");
                    } else if (adventure.playerEquip(userChoice) == null) {
                        System.out.println("You have no weapon equipped");
                    }
                }
                case "damage" -> System.out.println("Current damage pr hit: " + adventure.getPlayer().getPlayerDamage());
                case "exit", "quit", "leave" -> {
                    System.out.println("Shutting down the adventure...");
                    gameRunning = false;
                }
                default -> System.out.println("Error - wrong userChoice. Type 'help' to see commands");
            }

            if (adventure.getCurrentRoom() == adventure.getWinningRoom()) {
                System.out.println("You have found the FREDAGS-BAR!.");
                gameRunning = false;
            }
        }
    }

    private void lookInTheRoom() {
        System.out.println("Looking around...");
        System.out.println(adventure.getCurrentRoom().getDescription());
        System.out.println("\nSo you must be in \u001b[1m" + adventure.getCurrentRoom().getName() + "\u001b[0m, and you see: ");

        //Print items in currentRoom
        for (Item item : adventure.getCurrentRoom().getRoomItems()) {
            System.out.println("A \u001b[1m" + item.getItemName() +"\u001b[0m - "+ item.getItemDescription());
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