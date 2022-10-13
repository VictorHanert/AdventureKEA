public class Enemy {
    private String enemyName;
    private String description;
    private int enemyHp;
    private int damage;
    private Weapon weapon;
    private Room room;

    public Enemy(String enemyName, String description, int enemyHp, int damage, Weapon weapon, Room room){
        this.enemyName = enemyName;
        this.description = description;
        this.enemyHp = enemyHp;
        this.damage = damage;
        this.weapon = weapon;
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyHp() {
        return enemyHp;
    }

    public void setEnemyHp(int enemyHp) {
        this.enemyHp = enemyHp;
    }

    public int getDamage() {
        return damage;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void hit(int newHp) {
        this.enemyHp = newHp;
    }

    public void attack(Player player) {
        player.setPlayerHp(player.getPlayerHp() - weapon.getDamage());
    }

    public int dealDamage(Weapon weapon) {
        int damageDealt = enemyHp - weapon.getDamage();
        return damageDealt;
    }

    public boolean enemyDied() {
        if (enemyHp < 1) {
            room.addItem(weapon);
            room.removeEnemy(this);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return enemyName;
    }
}
