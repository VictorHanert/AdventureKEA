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

    public Weapon getWeapon() {
        return weapon;
    }

    public int playerAttacks(int damage) {
        this.enemyHp -= damage;
        return this.enemyHp;
    }

    @Override
    public String toString() {
        return enemyName;
    }
}
