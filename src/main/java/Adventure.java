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

    public Room getWinningRoom() {
        return map.getEndRoom();
    }

    public boolean go(String direction) {
        return player.move(direction);
    }

    public Item takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public Item dropItem(String itemName) {
        return player.dropItem(itemName);
    }

    public Status playerEat(String itemName) {
        return player.eatFood(itemName);
    }
}

