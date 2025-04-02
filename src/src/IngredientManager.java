import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void displayIngredients() {
        System.out.println("\n--- Available Ingredients ---");
        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println((i + 1) + ". " + ingredients.get(i));
        }
    }

    public void addIngredient(Scanner scanner) {
        System.out.print("Enter ingredient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter calories: ");
        int calories = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter protein (g): ");
        double protein = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter fats (g): ");
        double fats = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter carbs (g): ");
        double carbs = Double.parseDouble(scanner.nextLine());

        ingredients.add(new Ingredient(name, calories, protein, fats, carbs));
        System.out.println("Ingredient added successfully!");
    }

    public void editIngredient(Scanner scanner) {
        displayIngredients();
        System.out.print("Enter the number of the ingredient to edit: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < ingredients.size()) {
            Ingredient ingredient = ingredients.get(index);
            System.out.print("Enter new name (or press Enter to keep '" + ingredient.getName() + "'): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) ingredient.setName(name);

            System.out.print("Enter new calories (or press Enter to keep " + ingredient.getCalories() + "): ");
            String calories = scanner.nextLine();
            if (!calories.isEmpty()) ingredient.setCalories(Integer.parseInt(calories));

            System.out.print("Enter new protein (g) (or press Enter to keep " + ingredient.getProtein() + "): ");
            String protein = scanner.nextLine();
            if (!protein.isEmpty()) ingredient.setProtein(Double.parseDouble(protein));

            System.out.print("Enter new fats (g) (or press Enter to keep " + ingredient.getFats() + "): ");
            String fats = scanner.nextLine();
            if (!fats.isEmpty()) ingredient.setFats(Double.parseDouble(fats));

            System.out.print("Enter new carbs (g) (or press Enter to keep " + ingredient.getCarbs() + "): ");
            String carbs = scanner.nextLine();
            if (!carbs.isEmpty()) ingredient.setCarbs(Double.parseDouble(carbs));

            System.out.println("Ingredient updated successfully!");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void deleteIngredient(Scanner scanner) {
        displayIngredients();
        System.out.print("Enter the number of the ingredient to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < ingredients.size()) {
            ingredients.remove(index);
            System.out.println("Ingredient deleted successfully!");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}