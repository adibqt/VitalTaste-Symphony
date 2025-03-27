import java.util.ArrayList;
import java.util.List;

public class MealPlanner {
    private List<Recipe> recipes;

    public MealPlanner(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * Generates a meal plan that best matches the calorie target.
     * @param calorieTarget The target number of calories for the meal plan.
     * @return A list of recipes that best match the calorie target.
     */
    public List<Recipe> generateMealPlan(int calorieTarget) {
        List<Recipe> plan = new ArrayList<>();
        int currentCalories = 0;

        for (Recipe recipe : recipes) {
            int recipeCalories = recipe.getIngredients().stream().mapToInt(Ingredient::getCalories).sum();
            if (currentCalories + recipeCalories <= calorieTarget) {
                plan.add(recipe);
                currentCalories += recipeCalories;
            }
        }

        return plan;
    }

    /**
     * Generates a balanced meal plan based on calorie, protein, fat, and carb targets.
     * @param calorieTarget The target number of calories for the meal plan.
     * @param proteinTarget The target amount of protein for the meal plan.
     * @param fatTarget The target amount of fats for the meal plan.
     * @param carbTarget The target amount of carbs for the meal plan.
     * @return A list of recipes that best match the nutritional targets.
     */
    public List<Recipe> generateBalancedMealPlan(int calorieTarget, double proteinTarget, double fatTarget, double carbTarget) {
        List<Recipe> plan = new ArrayList<>();
        int currentCalories = 0;
        double currentProtein = 0, currentFats = 0, currentCarbs = 0;

        for (Recipe recipe : recipes) {
            int recipeCalories = recipe.getIngredients().stream().mapToInt(Ingredient::getCalories).sum();
            double recipeProtein = recipe.getIngredients().stream().mapToDouble(Ingredient::getProtein).sum();
            double recipeFats = recipe.getIngredients().stream().mapToDouble(Ingredient::getFats).sum();
            double recipeCarbs = recipe.getIngredients().stream().mapToDouble(Ingredient::getCarbs).sum();

            if (currentCalories + recipeCalories <= calorieTarget &&
                    currentProtein + recipeProtein <= proteinTarget &&
                    currentFats + recipeFats <= fatTarget &&
                    currentCarbs + recipeCarbs <= carbTarget) {
                plan.add(recipe);
                currentCalories += recipeCalories;
                currentProtein += recipeProtein;
                currentFats += recipeFats;
                currentCarbs += recipeCarbs;
            }
        }

        return plan;
    }
}