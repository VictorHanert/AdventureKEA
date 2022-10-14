public abstract class Weapon extends Item {
    private int damage;


    public Weapon(String weaponName, String weaponDescription, int damage) {
        super(weaponName, weaponDescription);
        this.damage = damage;
    }

    public String getName() {
        return super.getItemName();
    }

    public int getDamage() {
        return damage;
    }

    public abstract int getAmmoLeft();

    public abstract void setAmmo(int ammo);

    public boolean hasAmmo() {
        return true;
    }


    public void attack(Enemy enemy, Weapon weapon) {
        int damageDealt = enemy.dealDamage(weapon);
        enemy.hit(damageDealt);
        setAmmo(getAmmoLeft()-1);
    }




    public String toString() {
        return "\u001b[1m" + super.toString() + "\u001b[0m (" + damage + " damage)";
    }

}
