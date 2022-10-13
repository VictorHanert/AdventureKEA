public class Adventure {

    private Player player;
    private Map map = new Map();
    private Enemy enemy;

    public Adventure() {
        map.createRooms();
        player = new Player(100);
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

    public Status equip(String itemName) {
        return player.equipWeapon(itemName);
    }

    public AttackStatus attack(String enemyName) {
        return player.attackStatus(enemyName);
    }


}

