package service;

import model.User;

public class UserService {

    private User[] users = new User[10];
    private int count = 0;

    public void addUser(User user) {
        if (count < users.length) {
            users[count++] = user;
            System.out.println("User added successfully");
        } else {
            System.out.println("User limit reached");
        }
    }

    public void displayAllUsers() {
        if (count == 0) {
            System.out.println("No users found");
            return;
        }

        for (int i = 0; i < count; i++) {
            users[i].displayInfo();
            System.out.println();
        }
    }

    public boolean isEmailValid(String email) {
        return email != null && email.contains("@") && email.contains(".");

    }

    public boolean isIdUnique(int id) {
        for (int i = 0; i < count; i++) {
            if (users[i].getId() == id) {
                return false;
            }
        }
        return true;
    }
}
