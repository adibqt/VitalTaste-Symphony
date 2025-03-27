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

// FoodJournal class to log and view daily meals.
class FoodJournal {
    private List<Recipe> loggedMeals;

    public FoodJournal() {
        loggedMeals = new ArrayList<>();
    }

    public void logMeal(Recipe recipe) {
        loggedMeals.add(recipe);
        System.out.println("Meal logged: " + recipe.getName());
    }

    public void viewJournal() {
        if (loggedMeals.isEmpty()) {
            System.out.println("No meals logged yet.");
            return;
        }
        System.out.println("Food Journal:");
        for (Recipe recipe : loggedMeals) {
            System.out.println("- " + recipe.getName());
        }
    }
}
