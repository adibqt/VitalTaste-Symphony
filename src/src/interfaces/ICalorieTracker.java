package interfaces;

import java.time.LocalDate;

public interface ICalorieTracker {
    void logCalories(LocalDate date, int calories);
    int getCalories(LocalDate date);
    void displayCalories();
}