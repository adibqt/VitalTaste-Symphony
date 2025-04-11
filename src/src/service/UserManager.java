package service;

import interfaces.IUserManager;
import model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserManager implements IUserManager {
    private Map<String, User> users = new HashMap<>();
    private static final String FILE_PATH = "users.dat";

    public UserManager() {
        loadUsers();
    }

    @Override
    public boolean registerUser(String username, String password, double height, double weight) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password, height, weight));
        saveUsers();
        return true;
    }

    @Override
    public User loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            users = (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}