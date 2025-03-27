import java.util.List;
import java.util.Scanner;

public class UserInterFace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IngredientManager ingredientManager = new IngredientManager();
        RecipeManager recipeManager = new RecipeManager();
        FoodJournal foodJournal = new FoodJournal();

        boolean running = true;
        while (running) {
            System.out.println("\n=== HealthyFlavourFusion ===");
            System.out.println("1. Display Ingredients");
            System.out.println("2. Create Recipe");
            System.out.println("3. View Recipes");
            System.out.println("4. Generate Meal Plan");
            System.out.println("5. Log a Meal");
            System.out.println("6. View Food Journal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> ingredientManager.displayIngredients();
                case 2 -> recipeManager.createRecipe(scanner, ingredientManager);
                case 3 -> recipeManager.displayRecipes();
                case 4 -> {
                    if (recipeManager.getRecipes().isEmpty()) {
                        System.out.println("No recipes available.");
                        break;
                    }
                    System.out.print("Enter calorie target: ");
                    int target = Integer.parseInt(scanner.nextLine());
                    MealPlanner planner = new MealPlanner(recipeManager.getRecipes());
                    List<Recipe> plan = planner.generateMealPlan(target);
                    plan.forEach(r -> System.out.println("- " + r.getName() + " (" + r.nutritionalAnalysis() + ")"));
                }
                case 5 -> foodJournal.logMeal(recipeManager.getRecipes().get(0)); // Simplified for demo
                case 6 -> foodJournal.viewJournal();
                case 7 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}