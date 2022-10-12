public class Enemy {
    private String enemyName;
    private String description;
    private int enemyHp;
    private int damage;
    private Weapon weapon;

    public Enemy(String enemyName, String description, int enemyHp, int damage, Weapon weapon){
        this.enemyName = enemyName;
        this.description = description;
        this.enemyHp = enemyHp;
        this.damage = damage;
        this.weapon = weapon;
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


    public void enemyAttacks(Player player) {
        player.setPlayerHp(player.getPlayerHp() - weapon.getDamage());
    }
    public int dealDamage(Weapon weapon) {
        int damageDealt = enemyHp - weapon.getDamage();
        return damageDealt;
    }

    public boolean enemyDead() {
        if (enemyHp < 1) {
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
