package interfaces;

import java.util.List;
import java.util.Scanner;
import model.Recipe;
import model.Ingredient;
import interfaces.IIngredientManager;

public interface IRecipeManager {
    Recipe createRecipe(Scanner scanner, IIngredientManager ingredientManager);
    void displayRecipes(List<Recipe> recipes);
}