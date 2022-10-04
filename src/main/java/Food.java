public class Food {
    private String foodName;
    private String foodDescription;
    private int healthPoints;


    public Food(String foodName, String foodDescription, int healthPoints) {
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.healthPoints = healthPoints;
    }

    public String getFoodName(){
        return foodName.toLowerCase();
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public String toString(){
        return foodName;
    }
}
