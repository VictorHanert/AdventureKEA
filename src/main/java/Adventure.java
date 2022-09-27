public class Adventure {
    private Room currentRoom;


    public void createRooms() {
        Room room1 = new Room("a classroom", "There is tables and chairs");

        Room room2 = new Room("the toilet", "There is toilets and a hand wash");

        Room room3 = new Room("the game-room", "There is table tennis");

        Room room4 = new Room("4", "4");
        Room room5 = new Room("5", "5");
        Room room6 = new Room("6", "6");
        Room room7 = new Room("7", "7");
        Room room8 = new Room("8", "8");
        Room room9 = new Room("9", "9");

        room1.setEast(room2);
        room2.setWest(room1);

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
       currentRoom = currentRoom.getNorth();
    }

    public void goSouth() {
        currentRoom = currentRoom.getSouth();
    }

    public void goEast() {
        currentRoom = currentRoom.getEast();
    }

    public void goWest() {
        currentRoom = currentRoom.getWest();


    }
}
