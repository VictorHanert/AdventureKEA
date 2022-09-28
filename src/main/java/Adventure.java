public class Adventure {
    private Room currentRoom;
    private Map map = new Map();
    private Player player;

    public Adventure() {
        map.createRooms();
        player = new Player();
        player.setCurrentRoom(map.getCurrentRoom());
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
    public boolean go(String direction) {
        return player.move(direction);
    }
}

