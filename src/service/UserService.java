package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.EOFException;          // ✅ Needed
import java.util.ArrayList;

import model.User;

public class UserService {

    // Dynamic storage
    private ArrayList<User> users = new ArrayList<>();
    private final String FILE_NAME = "users.dat";

    // Constructor → auto load
    public UserService() {
        loadUsersFromFile();
    }

    // ADD USER
    public void addUser(User user) {

    if (user == null) {
        System.out.println("Invalid user data !");
        return;
    }

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
    //regex method -> industry accepted 
    public boolean isEmailValid(String email) {

    if (email == null) return false;

    return email.matches(
        "^[A-Za-z0-9+_.-]+@(.+)$"
    );
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

    // DELETE USER (Safe remove)
    public void deleteUser(int id) {

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == id) {
                users.remove(i);
                saveUsersToFile();   // persist delete
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
                saveUsersToFile();   // persist update
                System.out.println("Email updated successfully !");
                return;
            }
        }

        System.out.println("User not found !");
    }

    // SAVE TO FILE
    private void saveUsersToFile() {

    try (ObjectOutputStream oos =
         new ObjectOutputStream(
             new FileOutputStream(FILE_NAME))) {

        oos.writeObject(users);

    } catch (IOException e) {
        System.out.println("Error saving users !");
    }
}

    // LOAD FROM FILE
    @SuppressWarnings("unchecked")
    private void loadUsersFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No previous data found. Starting fresh.");
            return;
        }

        try (ObjectInputStream ois =
             new ObjectInputStream(
                 new FileInputStream(FILE_NAME))) {

            users = (ArrayList<User>) ois.readObject();
            System.out.println("Users loaded successfully !");

        } catch (EOFException e) {
            System.out.println("File empty — starting fresh.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading users !");
        }
    }
    private void logActivity(String message) {

    try (BufferedWriter writer =
         new BufferedWriter(
             new FileWriter("activity.log", true))) {

        writer.write(
            java.time.LocalDateTime.now()
            + " - " + message
        );

        writer.newLine();

    } catch (IOException e) {
        System.out.println("Logging failed ❌");
    }
}

}
