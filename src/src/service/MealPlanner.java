package service;

import interfaces.IMealPlanner;
import model.Recipe;
import model.Ingredient;

import java.util.*;

public class MealPlanner implements IMealPlanner {
    private final List<Recipe> recipes;

    public MealPlanner(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public List<Recipe> generateMealPlanBasedOnBMI(double bmi, double weight, double height, Scanner scanner) {
        List<Recipe> plan = new ArrayList<>();
        int calorieTarget;
        double idealBMI = 22.0;
        double idealWeight = idealBMI * height * height;

        if (bmi < 18.5) {
            System.out.print("You are underweight. In how many months do you want to achieve the ideal BMI? ");
            int months = Integer.parseInt(scanner.nextLine());
            double weightGain = idealWeight - weight;
            calorieTarget = (int) (2500 + (weightGain * 7700) / (months * 30));
        } else if (bmi < 24.9) {
            calorieTarget = 2000;
        } else {
            System.out.print("You are overweight. In how many months do you want to achieve the ideal BMI? ");
            int months = Integer.parseInt(scanner.nextLine());
            double weightLoss = weight - idealWeight;
            calorieTarget = (int) (2000 - (weightLoss * 7700) / (months * 30));
        }

        System.out.println("Your daily calorie target is: " + calorieTarget + " calories.");

        Set<Recipe> uniquePlan = new HashSet<>();

        for (Recipe recipe : recipes) {
            int recipeCalories = recipe.getIngredients().stream().mapToInt(Ingredient::getCalories).sum();
            if (recipeCalories <= calorieTarget) {
                uniquePlan.add(recipe);
            }
        }

        plan.addAll(uniquePlan);

        if (plan.isEmpty()) {
            System.out.println("No recipes match your daily calorie target.");
        } else {
            System.out.println("Recipes matching your daily calorie target:");
            for (Recipe recipe : plan) {
                System.out.println("- " + recipe.getName() + " (" + recipe.nutritionalAnalysis() + ")");
            }
        }

        return plan;
    }
}
