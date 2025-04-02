import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MealPlanner {
    private List<Recipe> recipes;

    public MealPlanner(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> generateMealPlanBasedOnBMI(double bmi, double weight, double height, Scanner scanner) {
        List<Recipe> plan = new ArrayList<>();
        int calorieTarget;
        double idealBMI = 22.0; // Ideal BMI
        double idealWeight = idealBMI * height * height; // Ideal weight in kg

        if (bmi < 18.5) {
            System.out.print("You are underweight. In how many months do you want to achieve the ideal BMI? ");
            int months = Integer.parseInt(scanner.nextLine());
            double weightGain = idealWeight - weight;
            calorieTarget = (int) (2500 + (weightGain * 7700) / (months * 30)); // 7700 calories to gain 1 kg
        } else if (bmi < 24.9) {
            calorieTarget = 2000; // Normal weight
        } else {
            System.out.print("You are overweight. In how many months do you want to achieve the ideal BMI? ");
            int months = Integer.parseInt(scanner.nextLine());
            double weightLoss = weight - idealWeight;
            calorieTarget = (int) (2000 - (weightLoss * 7700) / (months * 30)); // 7700 calories to lose 1 kg
        }

        int currentCalories = 0;
        Random random = new Random();
        List<Recipe> shuffledRecipes = new ArrayList<>(recipes);
        while (currentCalories < calorieTarget && !shuffledRecipes.isEmpty()) {
            Recipe recipe = shuffledRecipes.remove(random.nextInt(shuffledRecipes.size()));
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