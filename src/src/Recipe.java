import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private List<Ingredient> ingredients;
    private List<String> steps;

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addStep(String step) {
        steps.add(step);
    }

    public List<String> getSteps() {
        return steps;
    }

    public String nutritionalAnalysis() {
        int totalCalories = 0;
        double totalProtein = 0, totalFats = 0, totalCarbs = 0;
        for (Ingredient ing : ingredients) {
            totalCalories += ing.getCalories();
            totalProtein += ing.getProtein();
            totalFats += ing.getFats();
            totalCarbs += ing.getCarbs();
        }
        return "Total Calories: " + totalCalories +
                ", Protein: " + totalProtein + "g" +
                ", Fats: " + totalFats + "g" +
                ", Carbs: " + totalCarbs + "g";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recipe: ").append(name).append("\nIngredients:\n");
        for (Ingredient ing : ingredients) {
            sb.append("- ").append(ing.toString()).append("\n");
        }
        sb.append("Preparation Steps:\n");
        int count = 1;
        for (String step : steps) {
            sb.append(count++).append(". ").append(step).append("\n");
        }
        return sb.toString();
    }
}