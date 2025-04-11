package interfaces;

import java.util.Scanner;
import java.util.List;
import model.Recipe;

public interface IMealPlanner {
    List<Recipe> generateMealPlanBasedOnBMI(double bmi, double weight, double height, Scanner scanner);
}
