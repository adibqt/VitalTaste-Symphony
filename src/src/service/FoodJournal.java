package service;

import interfaces.IFoodJournal;
import model.Recipe;
import model.Ingredient;

import java.util.Formatter;
import java.util.List;

public class FoodJournal implements IFoodJournal {
    @Override
    public void viewJournal(List<Recipe> recipes) {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb);
            formatter.format("+----------------------+----------+------------+----------+----------+\n");
            formatter.format("| %-20s | %-8s | %-10s | %-8s | %-8s |\n", "Recipe Name", "Calories", "Protein (g)", "Fats (g)", "Carbs (g)");
            formatter.format("+----------------------+----------+------------+----------+----------+\n");

            for (Recipe recipe : recipes) {
                int totalCalories = 0;
                double totalProtein = 0, totalFats = 0, totalCarbs = 0;
                for (Ingredient ing : recipe.getIngredients()) {
                    totalCalories += ing.getCalories();
                    totalProtein += ing.getProtein();
                    totalFats += ing.getFats();
                    totalCarbs += ing.getCarbs();
                }
                formatter.format("| %-20s | %-8d | %-10.2f | %-8.2f | %-8.2f |\n", recipe.getName(), totalCalories, totalProtein, totalFats, totalCarbs);
                formatter.format("+----------------------+----------+------------+----------+----------+\n");
                formatter.format("Steps:\n");
                int stepCount = 1;
                for (String step : recipe.getSteps()) {
                    formatter.format("%d. %s\n", stepCount++, step);
                }
                formatter.format("+----------------------+----------+------------+----------+----------+\n");
            }

            String table = sb.toString();
            int consoleWidth = 80;
            int tableWidth = table.indexOf('\n') + 1;
            int padding = (consoleWidth - tableWidth) / 2;
            String paddingSpaces = " ".repeat(Math.max(0, padding));
            String centeredTable = table.replaceAll("(?m)^", paddingSpaces);

            System.out.println(centeredTable);
            formatter.close();
        }
    }
}
