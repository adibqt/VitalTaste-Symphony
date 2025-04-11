package service;

import interfaces.IIngredientManager;
import interfaces.IRecipeManager;
import model.Ingredient;
import model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecipeManager implements IRecipeManager {
    private final List<Recipe> recipes = new ArrayList<>();

    @Override
    public Recipe createRecipe(Scanner scanner, IIngredientManager ingredientManager) {
        System.out.print("\nEnter the name of your new recipe: ");
        String recipeName = scanner.nextLine();
        Recipe recipe = new Recipe(recipeName);

        boolean addingIngredients = true;
        while (addingIngredients) {
            ingredientManager.displayIngredients();
            System.out.print("Enter the number of the ingredient to add (or 0 to stop): ");
            int ingChoice = Integer.parseInt(scanner.nextLine());
            if (ingChoice == 0) {
                addingIngredients = false;
            } else if (ingChoice > 0 && ingChoice <= ingredientManager.getIngredients().size()) {
                Ingredient selected = ingredientManager.getIngredients().get(ingChoice - 1);
                recipe.addIngredient(selected);
                System.out.println(selected.getName() + " added.");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        System.out.println("Enter preparation steps (type 'done' when finished):");
        while (true) {
            String step = scanner.nextLine();
            if (step.equalsIgnoreCase("done")) break;
            recipe.addStep(step);
        }

        recipes.add(recipe);
        System.out.println("Recipe '" + recipeName + "' created successfully!");
        return recipe;
    }

    @Override
    public void displayRecipes(List<Recipe> recipes) {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            System.out.println("\n--- Recipes ---");
            for (int i = 0; i < recipes.size(); i++) {
                System.out.println((i + 1) + ". " + recipes.get(i).getName());
            }
        }
    }
}