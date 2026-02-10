package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.User;

public class UserService {

    // Dynamic storage
    private ArrayList<User> users = new ArrayList<>();
    private final String FILE_NAME = "users.txt";


    // ADD USER
    public void addUser(User user) {

        users.add(user);
        saveUsersToFile();
        System.out.println("User added successfully !");
    }

    // DISPLAY USERS
    public void displayAllUsers() {

        if (users.isEmpty()) {
            System.out.println("No users found !");
            return;
        }

        for (User user : users) {
            user.displayInfo();
            System.out.println();
        }
    }

    // EMAIL VALIDATION
    public boolean isEmailValid(String email) {

        if (email == null) return false;

        int atPos = email.indexOf("@");
        int dotPos = email.lastIndexOf(".");

        return atPos > 0 &&
               dotPos > atPos + 1 &&
               dotPos < email.length() - 1;
    }

    // CHECK UNIQUE ID
    public boolean isIdUnique(int id) {

        for (User user : users) {
            if (user.getId() == id) {
                return false;
            }
        }
        return true;
    }

    // SEARCH USER
    public void searchUserById(int id) {

        for (User user : users) {

            if (user.getId() == id) {
                System.out.println("User Found !");
                user.displayInfo();
                return;
            }
        }

        System.out.println("User not found !");
    }

    // DELETE USER
    public void deleteUser(int id) {

        for (User user : users) {

            if (user.getId() == id) {
                users.remove(user);
                System.out.println("User deleted successfully !");
                return;
            }
        }

        System.out.println("User not found !");
    }

    // UPDATE EMAIL
    public void updateEmail(int id, String newEmail) {

        for (User user : users) {

            if (user.getId() == id) {

                if (!isEmailValid(newEmail)) {
                    System.out.println("Invalid email !");
                    return;
                }

                user.setEmail(newEmail);
                System.out.println("Email updated successfully !");
                return;
            }
        }

        System.out.println("User not found !");
    }
    private void saveUsersToFile() {

    try (BufferedWriter writer =
         new BufferedWriter(new FileWriter(FILE_NAME))) {

        for (User user : users) {

            writer.write(
                user.getId() + "," +
                user.getClass().getSimpleName()
            );

            writer.newLine();
        }

    } catch (IOException e) {
        System.out.println("Error saving users ❌");
    }
}

}
