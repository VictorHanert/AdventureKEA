public class Enemy {
    private String enemyName;
    private String description;
    private int healthPoints;
    private int damage;
    private Weapon weapon;

    public Enemy(String enemyName, String description, int healthPoints, int damage, Weapon weapon){
        this.enemyName = enemyName;
        this.description = description;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.weapon = weapon;
    }

    public String getDescription() {
        return description;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        return enemyName;
    }
}
