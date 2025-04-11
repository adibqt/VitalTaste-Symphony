package interfaces;

import java.util.List;
import java.util.Scanner;
import model.Recipe;

public interface IFoodJournal {
    void viewJournal(List<Recipe> recipes);
}