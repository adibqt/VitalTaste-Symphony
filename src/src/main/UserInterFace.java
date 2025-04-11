package main;

import interfaces.*;
import model.User;
import model.Recipe;
import service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterFace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IIngredientManager ingredientManager = new IngredientManager();
        IRecipeManager recipeManager = new RecipeManager();
        IFoodJournal foodJournal = new FoodJournal();
        IUserManager userManager = new UserManager();
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
                System.out.println("1. Manage Ingredients");
                System.out.println("2. Manage Recipes");
                System.out.println("3. Generate Meal Plan");
                System.out.println("4. View Food Journal");
                System.out.println("5. Log Daily Calorie Intake");
                System.out.println("6. View Daily Calorie Intake");
                System.out.println("7. Logout");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        boolean managingIngredients = true;
                        while (managingIngredients) {
                            System.out.println("\n--- Manage Ingredients ---");
                            System.out.println("1. Display Ingredients");
                            System.out.println("2. Add Ingredient");
                            System.out.println("3. Edit Ingredient");
                            System.out.println("4. Delete Ingredient");
                            System.out.println("5. Back to Main Menu");
                            System.out.print("Enter your choice: ");

                            int manageChoice = Integer.parseInt(scanner.nextLine());
                            switch (manageChoice) {
                                case 1 -> ingredientManager.displayIngredients();
                                case 2 -> ingredientManager.addIngredient(scanner);
                                case 3 -> ingredientManager.editIngredient(scanner);
                                case 4 -> ingredientManager.deleteIngredient(scanner);
                                case 5 -> managingIngredients = false;
                                default -> System.out.println("Invalid choice.");
                            }
                        }
                    }
                    case 2 -> {
                        boolean managingRecipes = true;
                        while (managingRecipes) {
                            System.out.println("\n--- Manage Recipes ---");
                            System.out.println("1. Create Recipe");
                            System.out.println("2. View Recipes");
                            System.out.println("3. Back to Main Menu");
                            System.out.print("Enter your choice: ");

                            int manageRecipeChoice = Integer.parseInt(scanner.nextLine());
                            switch (manageRecipeChoice) {
                                case 1 -> {
                                    Recipe recipe = recipeManager.createRecipe(scanner, ingredientManager);
                                    currentUser.addRecipe(recipe);
                                    userManager.saveUsers();
                                }
                                case 2 -> recipeManager.displayRecipes(currentUser.getRecipes());
                                case 3 -> managingRecipes = false;
                                default -> System.out.println("Invalid choice.");
                            }
                        }
                    }
                    case 3 -> {
                        if (currentUser.getRecipes().isEmpty()) {
                            System.out.println("No recipes available.");
                            break;
                        }
                        double bmi = currentUser.calculateBMI();
                        System.out.println("Your BMI is: " + bmi);
                        IMealPlanner planner = new MealPlanner(currentUser.getRecipes());
                        planner.generateMealPlanBasedOnBMI(bmi, currentUser.getWeight(), currentUser.getHeight(), scanner);
                    }
                    case 4 -> foodJournal.viewJournal(currentUser.getRecipes());
                    case 5 -> {
                        boolean validInput = false;
                        while (!validInput) {
                            try {
                                System.out.print("Enter calories consumed today: ");
                                int calories = Integer.parseInt(scanner.nextLine());
                                if (calories < 0) {
                                    System.out.println("Calories cannot be negative. Please enter a valid number.");
                                } else {
                                    currentUser.getCalorieTracker().logCalories(LocalDate.now(), calories);
                                    userManager.saveUsers();
                                    System.out.println("Calories logged successfully!");
                                    validInput = true;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number.");
                            }
                        }
                    }
                    case 6 -> currentUser.getCalorieTracker().displayCalories();
                    case 7 -> {
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