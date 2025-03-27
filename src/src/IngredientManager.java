import java.util.ArrayList;
import java.util.List;

public class IngredientManager {
    private List<Ingredient> ingredients = new ArrayList<>();

    public IngredientManager() {
        initializeIngredients();
    }

    private void initializeIngredients() {
        ingredients.add(new Ingredient("Spinach", 23, 2.9, 0.4, 3.6));
        ingredients.add(new Ingredient("Quinoa", 120, 4.4, 1.9, 21.3));
        ingredients.add(new Ingredient("Chicken Breast", 165, 31, 3.6, 0));
        ingredients.add(new Ingredient("Avocado", 160, 2, 15, 9));
        ingredients.add(new Ingredient("Almonds", 575, 21, 49, 22));
    }

    public List<Ingredient> getIngredients() { return ingredients; }

    public void displayIngredients() {
        System.out.println("\n--- Available Ingredients ---");
        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println((i + 1) + ". " + ingredients.get(i));
        }
    }
}
