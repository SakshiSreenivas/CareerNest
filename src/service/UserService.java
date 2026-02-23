package com.CareerNest.CareerNest.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.CareerNest.CareerNest.model.User;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1, "Alice", "alice@mail.com", "STUDENT"));
        users.add(new User(2, "Bob", "bob@mail.com", "RECRUITER"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }
}
