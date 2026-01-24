package service;

import model.User;

public class UserService {

    private User[] users = new User[10];
    private int count = 0;

    public void addUser(User user) {
        if (count < users.length) {
            users[count] = user;
            count++;
            System.out.println("User added successfully");
        } else {
            System.out.println("User limit reached");
        }
    }

    public void displayAllUsers() {
        for (int i = 0; i < count; i++) {
            users[i].displayInfo();
            System.out.println();
        }
    }
}
