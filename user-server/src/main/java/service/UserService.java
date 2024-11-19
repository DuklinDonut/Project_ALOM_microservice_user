package service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import model.User;


public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public User addUser(String username, String password) {
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("Username already exists!");
        }
        User user = new User(username, password);
        users.put(username, user);
        return user;
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public List<User> getUsersCreatedAfter(LocalDateTime date) {
        List<User> recentUsers = new ArrayList<>();
        for (User user : users.values()) {
            if (user.getCreationDate().isAfter(date)) {
                recentUsers.add(user);
            }
        }
        return recentUsers;
    }
}

