public class Map {
    private Room currentRoom;
    private Room endRoom;

    public void createRooms() {
        Room room1 = new Room("a classroom", "In this room you see tables and chairs. There is also a projector and a whiteboard.");
        Room room2 = new Room("the toilet", "It smells bad in here. There are mirrors and a sink.");
        Room room3 = new Room("the game-room", "The room has a tennis table and a small kitchen.");
        Room room4 = new Room("the bicycle-basement", "You are in a big dark basement with dim lights. There are a lot of bicycles parked.");
        Room room5 = new Room("the 'fredags-bar'", "You have arrived at the party. There are cheap 'buca-shots' and hot girls behind the closed doors.");
        Room room6 = new Room("the library", "The room you are in has a lot of bookshelves.");
        Room room7 = new Room("the canteen", "This big room has an overpriced shop and plenty of tables and chairs.");
        Room room8 = new Room("the office", "In this room you see a lot of older people and they are all drinking coffee.");
        Room room9 = new Room("the code-lab", "Before entering this room you saw a sign on the window that said 'Code Lab'. There are people programming.");

        // Setting directions for each room
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.createItem("lamp", "A metal thing that lights up the room.");
        room1.createFood("apple", "A shiny red round fruit", 10);
        room1.createFood("biscuit", "A dry piece of some sort", 6);
        room1.createMeleeWeapon("sword", "A heavy shiny sword", 20);
        room1.createEnemy("anders", "He is very big and strong.", 50, 2, new MeleeWeapon("axe", "A huge axe that can be used to cut down trees (or heads..)", 17), room1);

        room2.setWest(room1);
        room2.setEast(room3);
        room2.createFood("bottle", "A glass bottle with cold water", 3);

        room3.setWest(room2);
        room3.setSouth(room6);
        room3.createEnemy("slikhair", "The biggest table tennis tryhard", 20, 5, new RangedWeapon("tabletennis-bat", "Slikhairs own bat", 5, 10), room3);
        room3.createRangedWeapon("chopping board", "A chopping board in plastic, it is one of the best bats for table tennis", 10, 10);
        room3.createFood("beer", "A green can with the name 'Carlsberg' on it", 8);

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.createItem("bicycle", "An iron horse with two wheels.");
        room4.createMeleeWeapon("hammer", "A wood-handle with a heavy iron-head", 5);

        room5.setSouth(room8);
        room5.createFood("sambuca", "A big glass-bottle with a transparent liquid inside", 999);
        room5.createEnemy("the orc", "A very scary creature that protects the 'Fredags-bar' against strangers.", 99, 50, new MeleeWeapon("Fists", "His hands are huge.", 50), room5);

        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.createItem("book", "A heavy leather cover with pages inside.");

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.createMeleeWeapon("knife", "A shiny metal thing with sharper blade at the end.", 10);
        room7.createFood("cake", "A sweet piece of a chocolate cake", -5);
        room7.createFood("sandwich", "Bread with pieces of cheese and ham inside. But look very rotten and nasty", -40);
        room7.createFood("bread", "A nice warm piece of bread with butter on top", 25);

        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.createItem("paper", "a blank white peace of paper");
        room8.createEnemy("teacher", "A old boring teacher who hates her students", 5, 10, new MeleeWeapon("pencil", "A sharp pencil that can make you blind", 10), room8);

        room9.setWest(room8);
        room9.setNorth(room6);
        room9.createItem("computer", "a grey Intel laptop");
        room9.createEnemy("nerd", "A very scary creature that sits with his head deep down in the computer-screen", 9, 0, new MeleeWeapon("hacked-computer", "The nerds personal computer that can kill everyone with the right commands", 40), room9);

        currentRoom = room1;
        endRoom = room5;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getEndRoom() {
        return endRoom;
    }

}
