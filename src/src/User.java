public class User {
    private String username;
    private String password;
    private double height; // in meters
    private double weight; // in kilograms

    public User(String username, String password, double height, double weight) {
        this.username = username;
        this.password = password;
        this.height = height;
        this.weight = weight;
    }

    public User(double height, double weight) {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateBMI() {
        return weight / (height * height);
    }
}