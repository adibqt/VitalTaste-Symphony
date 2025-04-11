package model;

import service.DailyCalorieTracker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private double height;
    private double weight;
    private List<Recipe> recipes;
    private DailyCalorieTracker calorieTracker;

    public User(String username, String password, double height, double weight) {
        this.username = username;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.recipes = new ArrayList<>();
        this.calorieTracker = new DailyCalorieTracker();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public List<Recipe> getRecipes() { return recipes; }
    public DailyCalorieTracker getCalorieTracker() { return calorieTracker; }
    public void addRecipe(Recipe recipe) { recipes.add(recipe); }

    public double calculateBMI() {
        return weight / (height * height);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        if (calorieTracker == null) {
            calorieTracker = new DailyCalorieTracker();
        }
    }
}