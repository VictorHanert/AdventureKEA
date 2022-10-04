public class Map {
    private Room currentRoom;
    private Room endRoom;

    public void createRooms() {
        Room room1 = new Room("a classroom", "In this room you see tables and chairs. There is also a projector and a whiteboard.");
        Room room2 = new Room("the toilet", "It smells bad in here. There are mirrors and a sink.");
        Room room3 = new Room("the game-room", "The room has a tennis table and a small kitchen.");
        Room room4 = new Room("the bicycle-basement", "You are in a big dark basement with dim lights. There are a lot of bicycles parked.");
        Room room5 = new Room("the 'fredags-bar'", "You have arrived at the party. There are cheap 'buca-shots' and hot girls.");
        Room room6 = new Room("the library", "The room you are in has a lot of bookshelves.");
        Room room7 = new Room("the canteen", "This big room has an overpriced shop and plenty of tables and chairs.");
        Room room8 = new Room("the office", "In this room you see a lot of older people and they are all drinking coffee.");
        Room room9 = new Room("the code-lab", "Before entering this room you saw a sign on the window that said 'Code Lab'. There are people programming.");

        // Setting directions for each room
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.createItem("lamp", "A metal thing that lights up the room.");
        room1.createFood("apple", "A shiny red round fruit", 10);
        room1.createFood("biscuit", "A dry piece of some sort", 2);

        room2.setWest(room1);
        room2.setEast(room3);
        room2.createItem("bottle", "A glass bottle with cold water");

        room3.setWest(room2);
        room3.setSouth(room6);
        room3.createItem("beer", "A green can with the name 'Carlsberg' on it");

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.createItem("bicycle", "An iron horse with two wheels.");

        room5.setSouth(room8);
        room5.createItem("sambuca", "A big glass-bottle with a transparent liquid inside");

        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.createItem("book", "A heavy leather cover with pages inside.");

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.createItem("knife", "A shiny metal thing with sharper blade at the end.");
        room7.createFood("Cake", "A sweet piece of a chocolate cake", -5);
        room7.createFood("Sandwich", "Bread with pieces of cheese and ham inside. But look very rotten and nasty", -40);
        room7.createFood("Bread", "A nice warm piece of bread with butter on top", 25);

        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);

        room9.setWest(room8);
        room9.setNorth(room6);

        currentRoom = room1;
        endRoom = room5;
    }

    public Room getCurrentRoom() {
        return  currentRoom;
    }

    public Room getEndRoom(){
        return endRoom;
    }

}
