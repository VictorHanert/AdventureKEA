public class Item {
    private String itemName;
    private String itemDescription;

    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }
    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public String toString() {
        return "\u001b[1m" + itemName + "\u001b[0m";
    }
}
