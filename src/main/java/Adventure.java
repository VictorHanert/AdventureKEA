public class Adventure {
    private Room currentRoom;

    public void createRooms() {
        Room room1 = new Room("a classroom", "There is tables and chairs");

        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
