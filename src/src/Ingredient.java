import java.io.Serializable;

public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int calories;
    private double protein;
    private double fats;
    private double carbs;

    public Ingredient(String name, int calories, double protein, double fats, double carbs) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fats = fats;
        this.carbs = carbs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    @Override
    public String toString() {
        return name + " (Calories: " + calories + ", Protein: " + protein + "g, Fats: " + fats + "g, Carbs: " + carbs + "g)";
    }
}