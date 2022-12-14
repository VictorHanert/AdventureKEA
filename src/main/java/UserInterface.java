import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private Adventure adventure;
    private final Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private boolean gameRunning = true;
    private String userChoice = "";

    public UserInterface() {
    }

    public void start() {
        adventure = new Adventure();
        welcome();
        userInput();
    }

    public void welcome() {
        System.out.println(RED + "WELCOME TO:" + RESET);
        System.out.println(GREEN + kea + RESET);
        System.out.println(RED + "Can you find way to the fredagsbar?" + RESET);
        System.out.println(RED + "Type 'help' for all commands." + RESET);
    }

    public void userInput() {
        while (gameRunning) {
            String input = scan.nextLine().toLowerCase();

            String[] inputSplit = input.split(" ");
            String command = inputSplit[0];

            if (inputSplit.length > 1) {
                userChoice = inputSplit[1];
            }

            switch (command) {
                case "go north", "north", "n" -> {
                    if (adventure.go("north")) {
                        System.out.println("Going north");
                    } else {
                        System.out.println("You cannot go that way");
                    }
                }
                case "go south", "south", "s" -> {
                    if (adventure.go("south")) {
                        System.out.println("Going south");
                    } else {
                        System.out.println("You cannot go that way");
                    }
                }
                case "go east", "east", "e" -> {
                    if (adventure.go("east")) {
                        System.out.println("Going east");
                    } else {
                        System.out.println("You cannot go that way");
                    }
                }
                case "go west", "west", "w" -> {
                    if (adventure.go("west")) {
                        System.out.println("Going west");
                    } else {
                        System.out.println("You cannot go that way");
                    }
                }
                case "look" -> lookInTheRoom();
                case "help", "h" -> helpMenu();
                case "inventory", "inv" -> {
                    if (adventure.getPlayer().getPlayerInventory().isEmpty()) {
                        System.out.println("Your inventory is empty.");
                    } else {
                        System.out.println("Your inventory contains:");
                        for (Item item : adventure.getPlayer().getPlayerInventory()) {
                            System.out.println("A \u001b[1m" + item.getItemName() + "\u001b[0m - " + item.getItemDescription());
                        }
                    }
                }
                case "take", "add", "pick" -> {
                    Item itemPickedUp = adventure.takeItem(userChoice);
                    if (itemPickedUp == null) {
                        System.out.println("There is no item in the room of that name.");
                    } else {
                        System.out.println("You pick up: " + "\u001b[1m" + userChoice + "\u001b[0m");
                    }
                }
                case "drop" -> {
                    Item itemDropped = adventure.dropItem(userChoice);
                    if (itemDropped != null) {
                        System.out.println("You drop: " + "\u001b[1m" + userChoice + "\u001b[0m");
                    } else {
                        System.out.println("You have no item of that name.");
                    }
                }
                case "eat", "drink" -> {
                    Status result = adventure.playerEat(userChoice);
                    switch (result) {
                        case OK -> {
                            System.out.println("Eating " + userChoice);
                            //if food will get you HP to 0 or below print:
                            if (adventure.getPlayer().getPlayerHp() < 1) {
                                System.out.println("\u001b[1m\u001B[31mYou died! This food was bad for your health.\u001b[0m");
                                gameRunning = false;
                            }
                            else {
                                System.out.println("Current hp: " + adventure.getPlayer().getPlayerHp());
                            }
                        }
                        case NOT_OK -> System.out.println("You cant eat a " + userChoice);
                        case NOT_FOUND -> System.out.println("No item was found: " + userChoice);
                    }
                }
                case "equip", "use" -> {
                    Status result = adventure.equip(userChoice);
                    switch (result) {
                        case OK -> {
                            System.out.println("Equipping the weapon \u001b[1m" + userChoice + "\u001b[0m");
                            System.out.println("Current damage pr. hit: " + adventure.getPlayer().getEquippedWeapon().getDamage());
                        }
                        case NOT_OK -> System.out.println("You cant equip a " + userChoice);
                        case NOT_FOUND -> System.out.println("No item was found with the name: " + userChoice);
                    }
                }
                case "attack", "kill", "fight" -> attackEnemy();
                case "damage" -> System.out.println("Current damage pr hit: " + adventure.getPlayer().getPlayerDamage());
                case "health", "hp" -> currentHealth();
                case "exit", "quit", "leave" -> {
                    System.out.println("Shutting down the adventure...");
                    gameRunning = false;
                }
                default -> System.out.println("Error - wrong userChoice. Type 'help' to see commands");
            }
        }
    }

    private void lookInTheRoom() {
        System.out.println("Looking around...");
        System.out.println(adventure.getCurrentRoom().getDescription());
        System.out.println("\nSo you must be in \u001b[1m" + adventure.getCurrentRoom().getName() + "\u001b[0m, and you see: ");

        //Print items in currentRoom
        for (Item item : adventure.getCurrentRoom().getRoomItems()) {
            System.out.println("A \u001b[1m" + item.getItemName() + "\u001b[0m - " + item.getItemDescription());
        }
        //Only printing message if you're in final room
        if (adventure.getCurrentRoom() == adventure.getWinningRoom()) {
            System.out.println("But before you can enter the party, you need to defeat: ");
            for (Enemy enemy : adventure.getCurrentRoom().getEnemies()) {
                System.out.println("\u001b[1m\u001B[31m" + enemy.getEnemyName() + "\u001b[0m - " + enemy.getDescription());
                System.out.println("The enemy has: " + RED + enemy.getEnemyHp() + RESET + "HP");
            }
        } else {
            //Print enemies in currentRoom
            for (Enemy enemy : adventure.getCurrentRoom().getEnemies()) {
                System.out.println("\n\u001b[1mAn enemy is in the room: " + enemy.getEnemyName() + "\u001b[0m - " + enemy.getDescription());
                System.out.println("The enemy has: " + RED + enemy.getEnemyHp() + RESET + "HP");
            }
        }
    }

    private void attackEnemy() {
        AttackStatus result = adventure.attack(userChoice);
        switch (result) {
            case NO_ENEMY -> System.out.println("There is no enemy of that name.");
            case NO_WEAPON -> System.out.println("You need to equip a weapon before starting a fight.");
            case ATTACK_ENEMY -> {
                // printing if player is alive:
                if (!adventure.getPlayer().died()) {
                    // printing if you attack enemy and enemy not dying from the attack:
                    if (!adventure.getCurrentRoom().getEnemies().isEmpty()) {
                        System.out.println("Attacking " + userChoice + "...");
                        for (Enemy enemy : adventure.getCurrentRoom().getEnemies()) {
                            System.out.println(enemy.getEnemyName() + " is now: " + RED +  enemy.getEnemyHp() + RESET + " hp");
                            if (!enemy.enemyDied()) {
                                currentHealth();
                            }
                        }
                    } // if you kill the enemy in currentRoom:
                    else {
                        System.out.println("You killed the enemy with your attack!");
                        // if you're in winning-room and the orc is dead, printing:
                        if (adventure.getCurrentRoom().getEnemies().isEmpty() && adventure.getCurrentRoom() == adventure.getWinningRoom()) {
                            System.out.println("Wow! You've defeated the orc, and won access to the party!");
                            System.out.println("-=-=-=-\u001b[1m ENJOY YOUR NIGHT! \u001b[0m-=-=-=-");
                            gameRunning = false;
                        }
                        else {
                            currentHealth();
                            System.out.println("The enemy also dropped their weapon!");
                        }
                    }
                } // printing if player is dead:
                else {
                    System.out.println(RED + dead + RESET);
                    System.out.println(RED + "Restart game to start over." + RESET);
                    gameRunning = false;
                }
            }
        }
    }

    private void currentHealth() {
        System.out.println("Your health: " + GREEN + adventure.getPlayer().getPlayerHp() + RESET);
        if (adventure.getPlayer().getPlayerHp() < 25) {
            System.out.println("\u001b[1m\u001B[31mYour health are at a critical level!\u001b[0m");
        } else if (adventure.getPlayer().getPlayerHp() < 51 && adventure.getPlayer().getPlayerHp() > 25) {
            System.out.println("\u001b[1mYour health are a little low, avoid fighting now...\u001b[0m");
        } else {
            System.out.println("Your health is good, you can go in battle!");
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
        System.out.println("Type 'eat' + (the item name)' to eat an item from your inventory");
        System.out.println("Type 'equip' + (the item name)' to equip an item from your inventory");
        System.out.println("Type 'health' to get your current health-points");
        System.out.println("Type 'damage' to get your current damage pr. hit");
        System.out.println("Type 'exit' to quit the adventure");
    }

    String kea = """
                8 8888     ,88' 8 8888888888            .8.         \s
                8 8888    ,88'  8 8888                 .888.        \s
                8 8888   ,88'   8 8888                :88888.       \s
                8 8888  ,88'    8 8888               . `88888.      \s
                8 8888 ,88'     8 888888888888      .8. `88888.     \s
                8 8888 88'      8 8888             .8`8. `88888.    \s
                8 888888<       8 8888            .8' `8. `88888.   \s
                8 8888 `Y8.     8 8888           .8'   `8. `88888.  \s
                8 8888   `Y8.   8 8888          .888888888. `88888. \s
                8 8888     `Y8. 8 888888888888 .8'       `8. `88888.\s""";
    String dead = """
            

            ?????????   ????????? ??????????????????   ???    ??????    ?????????????????????  ??????????????????????????? ?????????????????????\s
             ?????????  ?????????????????????  ????????? ??????  ????????????   ???????????? ???????????????????????????   ??? ???????????? ?????????
              ????????? ?????????????????????  ??????????????????  ????????????   ?????????   ??????????????????????????????   ?????????   ??????
              ??? ????????????????????????   ??????????????????  ????????????   ????????????   ????????????????????????  ??? ????????????   ???
              ??? ?????????????????? ?????????????????????????????????????????????    ????????????????????? ??????????????????????????????????????????????????????\s
               ??????????????? ??? ?????????????????? ???????????? ??? ???     ?????????  ??? ??????  ?????? ?????? ??? ?????????  ???\s
             ????????? ?????????   ??? ??? ?????? ???????????? ??? ???     ??? ???  ???  ??? ??? ??? ???  ??? ??? ???  ???\s
             ??? ??? ??????  ??? ??? ??? ???   ????????? ??? ???     ??? ???  ???  ??? ???   ???    ??? ???  ???\s
             ??? ???         ??? ???     ???           ???     ???     ???  ???   ???   \s
             ??? ???                           ???                  ???     \s""";
    }
