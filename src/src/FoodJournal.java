import java.util.List;

public class FoodJournal {
    public void viewJournal(List<Recipe> recipes) {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            System.out.println("Food Journal:");
            for (Recipe recipe : recipes) {
                System.out.println(recipe);
            }
        }
    }
}