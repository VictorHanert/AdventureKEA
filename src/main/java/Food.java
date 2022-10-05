public class Food extends Item {
    private int healthPoints;

    public Food(String itemName, String itemDescription, int healthPoints) {
        super(itemName, itemDescription);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public String toString() {
        return "\u001b[1m" + super.toString() + "\u001b[0m (" + healthPoints + " health-points)";
    }
}