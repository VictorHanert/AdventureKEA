import java.nio.file.Watchable;
import java.util.ArrayList;

public class Room {
    private ArrayList<Item> roomItems = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();


    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setNorth(Room room) {
        this.north = room;
    }

    public void setSouth(Room room) {
        this.south = room;
    }

    public void setEast(Room room) {
        this.east = room;
    }

    public void setWest(Room room) {
        this.west = room;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }


    public void createItem(String itemName, String itemDescription) {
        Item item = new Item(itemName, itemDescription);
        roomItems.add(item);
    }

    public void createFood(String foodName, String foodDescription, int healthPoints) {
        Food food = new Food(foodName, foodDescription, healthPoints);
        roomItems.add(food);
    }

    public void createMeleeWeapon(String weaponName, String weaponDescription, int damage) {
        MeleeWeapon meleeWeapon = new MeleeWeapon(weaponName, weaponDescription, damage);
        roomItems.add(meleeWeapon);
    }

    public void createRangedWeapon(String weaponName, String weaponDescription, int damage, int ammo) {
        RangedWeapon rangedWeapon = new RangedWeapon(weaponName, weaponDescription, damage, ammo);
        roomItems.add(rangedWeapon);
    }

    public void createEnemy(String name, String description, int healthPoints, int damage, Weapon weapon) {
        Enemy enemy = new Enemy(name, description, healthPoints, damage, weapon);
        addEnemy(enemy);
    }

    private void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public ArrayList<Item> getRoomItems() {
        return roomItems;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void addItem(Item item) {
        roomItems.add(item);
    }

    public Item removeItem(String itemName) {
        for (Item item : roomItems) {
            if (item.getItemName().equals(itemName)) {
                roomItems.remove(item);
                return item;
            }
        }
        return null;
    }
}