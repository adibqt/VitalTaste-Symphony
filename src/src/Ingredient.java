public class Ingredient {
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

    public int getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbs() {
        return carbs;
    }

    @Override
    public String toString() {
        return name + " (Calories: " + calories + ", Protein: " + protein + "g, Fats: " + fats + "g, Carbs: " + carbs + "g)";
    }
}

