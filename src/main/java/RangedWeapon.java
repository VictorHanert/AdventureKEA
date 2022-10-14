public class RangedWeapon extends Weapon{
    private int ammo;

    public RangedWeapon(String name, String description, int damage, int ammo) {
        super(name, description, damage);
        this.ammo = ammo;
    }

    @Override
    public int getAmmoLeft() {
        return ammo;
    }

    @Override
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

   @Override
    public boolean hasAmmo() {
        if (ammo <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
