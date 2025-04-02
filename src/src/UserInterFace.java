import java.util.List;
import java.util.Scanner;

public class UserInterFace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IngredientManager ingredientManager = new IngredientManager();
        RecipeManager recipeManager = new RecipeManager();
        FoodJournal foodJournal = new FoodJournal();
        UserManager userManager = new UserManager();
        User currentUser = null;

        boolean running = true;
        while (running) {
            System.out.println("\n=== HealthyFlavourFusion ===");
            if (currentUser == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        System.out.print("Enter height in meters: ");
                        double height = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter weight in kilograms: ");
                        double weight = Double.parseDouble(scanner.nextLine());
                        if (userManager.registerUser(username, password, height, weight)) {
                            System.out.println("Registration successful!");
                        } else {
                            System.out.println("Username already exists.");
                        }
                    }
                    case 2 -> {
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        currentUser = userManager.loginUser(username, password);
                        if (currentUser != null) {
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Invalid username or password.");
                        }
                    }
                    case 3 -> {
                        running = false;
                        System.out.println("Goodbye!");
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("1. Display Ingredients");
                System.out.println("2. Create Recipe");
                System.out.println("3. View Recipes");
                System.out.println("4. Generate Meal Plan");
                System.out.println("5. View Food Journal");
                System.out.println("6. Logout");
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
                        double bmi = currentUser.calculateBMI();
                        System.out.println("Your BMI is: " + bmi);

                        MealPlanner planner = new MealPlanner(recipeManager.getRecipes());
                        List<Recipe> plan = planner.generateMealPlanBasedOnBMI(bmi);
                        if (plan.isEmpty()) {
                            System.out.println("No recipe found.");
                        } else {
                            plan.forEach(r -> System.out.println("- " + r.getName() + " (" + r.nutritionalAnalysis() + ")"));
                        }
                    }
                    case 5 -> foodJournal.viewJournal(recipeManager.getRecipes());
                    case 6 -> {
                        currentUser = null;
                        System.out.println("Logged out.");
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
        scanner.close();
    }
}