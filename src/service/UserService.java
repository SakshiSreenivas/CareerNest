package service;

import model.User;

/*
 * UserService handles all backend logic related to users.
 * This is similar to a Service layer in real backend frameworks
 * like Spring Boot.
 */
public class UserService {

    // Temporary storage (will later become Database)
    private User[] users = new User[10];

    // Tracks number of users added
    private int count = 0;

    /*
     * Adds a new user to storage.
     * Works for both Student and Recruiter
     * because both inherit from User.
     */
    public void addUser(User user) {

        if (count < users.length) {
            users[count] = user;
            count++;

            System.out.println("User added successfully!");

        } else {
            System.out.println("User limit reached!");
        }
    }

    /*
     * Displays all users stored in the system.
     * Uses polymorphism — displayInfo() behaves
     * differently for Student and Recruiter.
     */
    public void displayAllUsers() {

        if (count == 0) {
            System.out.println("No users found!");
            return;
        }

        System.out.println("\n--- All Registered Users ---");

        for (int i = 0; i < count; i++) {
            users[i].displayInfo();
            System.out.println();
        }
    }

    /*
     * Validates email format.
     * Simple backend validation rule:
     * Must contain '@' and '.'
     */
    public boolean isEmailValid(String email) {

        return email != null &&
               email.contains("@") &&
               email.contains(".");
    }

    /*
     * Ensures ID is unique before adding.
     * Prevents duplicate user entries.
     */
    public boolean isIdUnique(int id) {

        for (int i = 0; i < count; i++) {

            if (users[i].getId() == id) {
                return false;
            }
        }

        return true;
    }
}
