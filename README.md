# Vital-Taste Symphony

## Project Overview
**Vital-Taste Symphony** is a Java-based application designed to assist users in managing their dietary habits. It provides tools for ingredient management, recipe creation, meal planning based on BMI, calorie tracking, and food journaling. The application aims to promote healthy eating habits and simplify meal preparation and nutritional analysis.

---

## Features
### 1. **User Management**
- Register and log in users with height, weight, and credentials.
- Calculate BMI and use it for meal planning.

### 2. **Ingredient Management**
- Add, edit, delete, and display ingredients.
- Store nutritional information such as calories, protein, fats, and carbs.

### 3. **Recipe Management**
- Create recipes by combining ingredients and adding preparation steps.
- View and manage recipes.

### 4. **Meal Planning**
- Generate meal plans based on BMI and calorie targets.
- Provide recommendations for underweight, normal, and overweight users.

### 5. **Calorie Tracking**
- Log daily calorie intake.
- View historical calorie data.

### 6. **Food Journal**
- View a detailed journal of recipes, including nutritional analysis and preparation steps.

---

## Project Architecture
The project follows a modular architecture with the following components:

### 1. **Interfaces**
Define contracts for various functionalities:
- `IUserManager`, `IIngredientManager`, `IRecipeManager`, `IMealPlanner`, `ICalorieTracker`, `IFoodJournal`.

### 2. **Models**
Represent core entities:
- `User`, `Ingredient`, `Recipe`.

### 3. **Services**
Implement business logic:
- `UserManager`, `IngredientManager`, `RecipeManager`, `MealPlanner`, `DailyCalorieTracker`, `FoodJournal`.

### 4. **Main Class**
- `UserInterFace`: Provides a command-line interface for user interaction.

### 5. **Persistence**
- Data is stored using serialized files (`users.dat`, `ingredients.dat`).

---

## Technology Used
- **Programming Language**: Java
- **IDE**: IntelliJ IDEA
- **Data Persistence**: File-based serialization
- **Libraries**: Java Standard Library (`java.util`, `java.io`, `java.time`)
- **Design Principles**: Modular architecture, separation of concerns, interface-driven development.

---

## How to Run
1. Clone the repository to your local machine.
2. Open the project in IntelliJ IDEA.
3. Build the project to ensure all dependencies are resolved.
4. Run the `UserInterFace` class to start the application.

---

## Justification
This project aligns with the theme of promoting healthy eating and simplifying meal preparation. By integrating features like BMI-based meal planning, calorie tracking, and recipe management, the application provides a holistic solution for users aiming to improve their dietary habits. Its modular architecture ensures scalability and maintainability, making it a robust and user-friendly tool for managing nutrition and health.

---

## File Structure
```
src/
├── interfaces/
│   ├── ICalorieTracker.java
│   ├── IFoodJournal.java
│   ├── IIngredientManager.java
│   ├── IMealPlanner.java
│   ├── IRecipeManager.java
│   └── IUserManager.java
├── main/
│   └── UserInterFace.java
├── model/
│   ├── Ingredient.java
│   ├── Recipe.java
│   └── User.java
├── service/
│   ├── DailyCalorieTracker.java
│   ├── FoodJournal.java
│   ├── IngredientManager.java
│   ├── MealPlanner.java
│   ├── RecipeManager.java
│   └── UserManager.java
```

---

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
