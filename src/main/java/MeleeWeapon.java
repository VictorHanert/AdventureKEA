public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String name, String description, int damage) {
        super(name, description, damage);
    }
    @Override
    public int getAmmoLeft() {
        return 0;
    }

    @Override
    public void setAmmo(int ammo) {
        ammo = 0;
    }
}
