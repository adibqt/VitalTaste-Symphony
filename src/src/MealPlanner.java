import java.util.ArrayList;
import java.util.List;

public class MealPlanner {
    private List<Recipe> recipes;

    public MealPlanner(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    // This simple planner returns recipes whose total calories are less than or equal to the target.
    public List<Recipe> generateMealPlan(int calorieTarget) {
        List<Recipe> plan = new ArrayList<>();
        for (Recipe recipe : recipes) {
            int totalCalories = 0;
            for (Ingredient ing : recipe.getIngredients()) {
                totalCalories += ing.getCalories();
            }
            if (totalCalories <= calorieTarget) {
                plan.add(recipe);
            }
        }
        return plan;
    }
}


