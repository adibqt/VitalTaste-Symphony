package interfaces;

import java.util.List;
import java.util.Scanner;
import model.Ingredient;

public interface IIngredientManager {
    void displayIngredients();
    void addIngredient(Scanner scanner);
    void editIngredient(Scanner scanner);
    void deleteIngredient(Scanner scanner);
    List<Ingredient> getIngredients();
    void saveIngredients();
    void loadIngredients();
}