public class Adventure {
    private Room currentRoom;

    public void createRooms() {
        Room room1 = new Room("a classroom", "There is tables and chairs");

        Room room2 = new Room("the toilet", "There is toilets and a hand wash");

        Room room3 = new Room("the game-room", "There is table tennis");

        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
