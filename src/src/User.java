public class User {

    private double height; // in meters
    private double weight; // in kilograms

    public User(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double calculateBMI() {
        return weight / (height * height);
    }
}
