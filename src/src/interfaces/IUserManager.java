package interfaces;

import model.User;

public interface IUserManager {
    boolean registerUser(String username, String password, double height, double weight);
    User loginUser(String username, String password);
    void saveUsers();
    void loadUsers();
}