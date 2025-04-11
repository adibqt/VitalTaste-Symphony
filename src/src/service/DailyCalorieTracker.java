package service;

import interfaces.ICalorieTracker;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DailyCalorieTracker implements ICalorieTracker, Serializable {
    private static final long serialVersionUID = 1L;
    private Map<LocalDate, Integer> dailyCalories;

    public DailyCalorieTracker() {
        dailyCalories = new HashMap<>();
    }

    @Override
    public void logCalories(LocalDate date, int calories) {
        dailyCalories.put(date, dailyCalories.getOrDefault(date, 0) + calories);
    }

    @Override
    public int getCalories(LocalDate date) {
        return dailyCalories.getOrDefault(date, 0);
    }

    @Override
    public void displayCalories() {
        System.out.println("\n--- Daily Calorie Intake ---");
        for (Map.Entry<LocalDate, Integer> entry : dailyCalories.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " calories");
        }
    }
}