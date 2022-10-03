import java.util.ArrayList;

public class Adventure {
    private Map map = new Map();
    private Player player;

    public Adventure() {
        map.createRooms();
        player = new Player();
        player.setCurrentRoom(map.getCurrentRoom());
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public boolean go(String direction) {
        return player.move(direction);
    }
}

