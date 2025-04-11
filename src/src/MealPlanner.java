import java.util.*;

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

        System.out.println("Your daily calorie target is: " + calorieTarget + " calories.");

        // Use a Set to ensure unique recipes in the plan
        Set<Recipe> uniquePlan = new HashSet<>();

        // Filter recipes that match the calorie target
        for (Recipe recipe : recipes) {
            int recipeCalories = recipe.getIngredients().stream().mapToInt(Ingredient::getCalories).sum();
            if (recipeCalories <= calorieTarget) {
                uniquePlan.add(recipe); // Add to Set to ensure uniqueness
            }
        }

        plan.addAll(uniquePlan); // Convert Set back to List

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