import java.util.ArrayList;
import java.util.List;

public class FoodJournal {
    private List<Recipe> loggedMeals = new ArrayList<>();

    public void logMeal(Recipe recipe) {
        loggedMeals.add(recipe);
        System.out.println("Meal logged: " + recipe.getName());
    }

    public void viewJournal() {
        if (loggedMeals.isEmpty()) {
            System.out.println("No meals logged yet.");
        } else {
            System.out.println("Food Journal:");
            for (Recipe recipe : loggedMeals) {
                System.out.println("- " + recipe.getName());
            }
        }
    }
}
