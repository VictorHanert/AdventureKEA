public class Adventure {
    private Room currentRoom;


    public void createRooms() {
        Room room1 = new Room("a classroom", "You enter a room. It looks like a classroom.");
        Room room2 = new Room("the toilet", "It smells bad in here. There are mirrors and a sink.");
        Room room3 = new Room("the game-room", "You enter a room. The room has a tennis table and a small kitchen.");
        Room room4 = new Room("the bicycle-basement", "You enter a big dark basement with dim lights. There are a lot of bicycles parked.");
        Room room5 = new Room("the 'fredags-bar'", "You have arrived at the party. There are cheap 'buca-shots' and horny girls.");
        Room room6 = new Room("the library", "You enter a big room with a lot of bookshelves. It looks like a library.");
        Room room7 = new Room("the canteen", "You enter a big room with an overpriced shop and plenty of tables and chairs. It looks like a canteen.");
        Room room8 = new Room("the office", "You enter a room. You see a lot of older people and they are all drinking coffee.");
        Room room9 = new Room("the code-lab", "You enter a room. The room smells like ass, and there are zero bitches. There are people programming.");

        // Setting directions for each room
        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);

        room9.setWest(room8);
        room9.setNorth(room6);

        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void goNorth() {
        if (currentRoom.getNorth() != null){
            currentRoom = currentRoom.getNorth();
        } else {
            System.out.println("you cannot go that way");
        }
    }

    public void goSouth() {
        if (currentRoom.getSouth() != null){
            currentRoom = currentRoom.getSouth();
        } else {
            System.out.println("you cannot go that way");
        }
    }

    public void goEast() {
        if (currentRoom.getEast()!=null) {
            currentRoom = currentRoom.getEast();
        } else {
            System.out.println("you can't go that way");
        }
    }

    public void goWest() {
        if (currentRoom.getWest()!=null) {
            currentRoom = currentRoom.getWest();
        } else {
            System.out.println("you can't go that way");
        }
    }

}
