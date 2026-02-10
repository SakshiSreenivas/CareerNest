package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.User;

public class UserService {

    // Dynamic storage
    private ArrayList<User> users = new ArrayList<>();
    private final String FILE_NAME = "users.dat";

     public UserService() {
        loadUsersFromFile();
    }


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

    try (ObjectOutputStream oos =
         new ObjectOutputStream(
             new FileOutputStream(FILE_NAME))) {

        oos.writeObject(users);

    } catch (IOException e) {
        System.out.println("Error saving users ❌");
    }
}

private void loadUsersFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) return;

        try (BufferedReader reader =
             new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("Loaded: " + line);
            }

        } catch (IOException e) {
            System.out.println("Error loading users ❌");
        }
    }
}
