import java.util.ArrayList;
import java.util.List;

public class MealPlanner {
    private List<Recipe> recipes;

    public MealPlanner(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> generateMealPlanBasedOnBMI(double bmi) {
        List<Recipe> plan = new ArrayList<>();
        int calorieTarget;

        if (bmi < 18.5) {
            calorieTarget = 2500; // Underweight
        } else if (bmi < 24.9) {
            calorieTarget = 2000; // Normal weight
        } else if (bmi < 29.9) {
            calorieTarget = 1500; // Overweight
        } else {
            calorieTarget = 1200; // Obesity
        }

        int currentCalories = 0;
        for (Recipe recipe : recipes) {
            int recipeCalories = recipe.getIngredients().stream().mapToInt(Ingredient::getCalories).sum();
            if (currentCalories + recipeCalories <= calorieTarget) {
                plan.add(recipe);
                currentCalories += recipeCalories;
            }
        }

        if (plan.isEmpty()) {
            System.out.println("No recipe found.");
        }

        return plan;
    }
}