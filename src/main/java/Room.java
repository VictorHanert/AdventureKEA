import java.nio.file.Watchable;
import java.util.ArrayList;

public class Room {
    private ArrayList<Item> roomItems = new ArrayList<>();
    private ArrayList<Food> roomFood = new ArrayList<>();
    private ArrayList<Food> roomWeapon = new ArrayList<>();

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

    public void createWeapon(String weaponName, String weaponDescription, int damage) {
        Weapon weapon = new Weapon(weaponName, weaponDescription, damage);
        roomItems.add(weapon);
    }

    public ArrayList<Item> getRoomItems(){
        return roomItems;
    }

    public void addItem(Item item){
        roomItems.add(item);
    }

    public Item removeItem(String itemName){
        for (Item item : roomItems){
            if (item.getItemName().equals(itemName)){
                roomItems.remove(item);
                return item;
            }
        }
        return null;
    }
}