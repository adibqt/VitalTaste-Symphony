import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private double height; // in meters
    private double weight; // in kilograms
    private List<Recipe> recipes;
    private DailyCalorieTracker calorieTracker;

    public User(String username, String password, double height, double weight) {
        this.username = username;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.recipes = new ArrayList<>();
        this.calorieTracker = new DailyCalorieTracker();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public DailyCalorieTracker getCalorieTracker() {
        return calorieTracker;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public double calculateBMI() {
        return weight / (height * height);
    }
}