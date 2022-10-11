import java.util.ArrayList;

public class Player {
    private int playerHp;
    private int playerDamage;

    public Player() {
        playerHp = 100;
        playerDamage = 0;
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public int getPlayerDamage() {
        return playerDamage;
    }

    private Room currentRoom;
    private ArrayList<Item> playerInventory = new ArrayList<>();
    Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean move(String direction) {
        Room requestedRoom = null;
        if (direction.charAt(0) == 'n') {
            requestedRoom = currentRoom.getNorth();
        } else if (direction.charAt(0) == 'e') {
            requestedRoom = currentRoom.getEast();
        } else if (direction.charAt(0) == 'w') {
            requestedRoom = currentRoom.getWest();
        } else if (direction.charAt(0) == 's') {
            requestedRoom = currentRoom.getSouth();
        }

        if (requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    public void addItem(Item item){
        playerInventory.add(item);
    }

    public Item removeItem(String itemName){
        for (Item item : playerInventory){
            if (item.getItemName().equals(itemName)){
                playerInventory.remove(item);
                return item;
            }
        }
       return null;
    }

    public Item takeItem(String itemName) {
        Item pickedUpItem = getCurrentRoom().removeItem(itemName);
        addItem(pickedUpItem);
        return pickedUpItem;
    }

    public Item dropItem(String itemName) {
        Item droppedItem = removeItem(itemName);
        currentRoom.addItem(droppedItem);
        return droppedItem;
    }

    public Item findItem(String itemName) {
        for (Item item : playerInventory) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Status eatFood(String itemName) {
        Item item = findItem(itemName);
        if (item == null) {
            return Status.NOT_FOUND;
        }
        else if (item instanceof Food food) {
            playerHp += food.getHealthPoints();
            removeItem(itemName);
            return Status.OK;
        } else {
            return Status.NOT_OK;
        }
    }

    public Status equipWeapon(String itemName) {
        Item item = findItem(itemName);
        if (item == null) {
            return Status.NOT_FOUND;
        }
        else if (item instanceof Weapon weapon) {
            playerDamage += weapon.getDamage() - getPlayerDamage();
            return Status.OK;
        } else {
            return Status.NOT_OK;
        }
    }


    public int enemyAttacks(int damage) {
        this.playerHp -= damage;
        return this.playerHp;
    }
}
