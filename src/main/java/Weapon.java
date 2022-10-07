public class Weapon extends Item {
    private int damage;

    public Weapon(String weaponName, String weaponDescription, int damage) {
        super(weaponName, weaponDescription);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "\u001b[1m" + super.toString() + "\u001b[0m (" + damage + " damage)";
    }
}
