package service;

import java.util.ArrayList;
import java.io.*;
import model.User;
import java.security.MessageDigest;


public class UserService {


private ArrayList<User> users = new ArrayList<>();
private final String FILE_NAME = "users.dat";

public UserService() {
    loadUsersFromFile();
}

//  PASSWORD ENCRYPTION
private String encryptPassword(String password) {

    try {

        MessageDigest md =
            MessageDigest.getInstance("SHA-256");

        byte[] hash =
            md.digest(password.getBytes());

        StringBuilder hex =
            new StringBuilder();

        for (byte b : hash) {
            hex.append(
                String.format("%02x", b)
            );
        }

        return hex.toString();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}


//  ADD USER
public void addUser(User user) {

    if (user == null) {
        System.out.println("Invalid user !");
        return;
    }

    // Encrypt password before storing
    user.setPassword(
        encryptPassword(user.getPassword())
    );

    users.add(user);
    saveUsersToFile();

    logActivity("User added: ID " + user.getId());

    System.out.println("User added successfully !");
}

//  LOGIN
public User login(String email, String password) {

    for (User user : users) {

        if (user.getEmail().equals(email) &&
            user.getPassword().equals(
                encryptPassword(password)
            )) {

            System.out.println(
                "Login successful as " +
                user.getRole()
            );

            logActivity(
                "User logged in: ID " +
                user.getId()
            );

            return user;
        }
    }

    System.out.println("Invalid credentials !");
    return null;
}

//  DISPLAY
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

//  SEARCH
public void searchUserById(int id) {

    for (User user : users) {

        if (user.getId() == id) {
            user.displayInfo();
            return;
        }
    }

    System.out.println("User not found !");
}

//  DELETE (ROLE BASED)
public void deleteUser(int id, String role) {

    if (!role.equals("RECRUITER")) {
        System.out.println("Access denied !");
        return;
    }

    for (User user : users) {

        if (user.getId() == id) {

            users.remove(user);
            saveUsersToFile();

            logActivity(
                "User deleted: ID " + id
            );

            System.out.println(
                "User deleted successfully !"
            );
            return;
        }
    }

    System.out.println("User not found !");
}

//  UPDATE EMAIL
public void updateEmail(int id, String newEmail) {

    for (User user : users) {

        if (user.getId() == id) {

            if (!isEmailValid(newEmail)) {
                System.out.println(
                    "Invalid email !"
                );
                return;
            }

            user.setEmail(newEmail);
            saveUsersToFile();

            logActivity(
                "Email updated: ID " + id
            );

            System.out.println(
                "Email updated successfully !"
            );
            return;
        }
    }

    System.out.println("User not found !");
}

//  VALIDATION
public boolean isEmailValid(String email) {

    return email != null &&
           email.matches(
           "^[A-Za-z0-9+_.-]+@(.+)$");
}

//  UNIQUE CHECK
public boolean isIdUnique(int id) {

    for (User user : users) {
        if (user.getId() == id) {
            return false;
        }
    }
    return true;
}

//  SAVE
private void saveUsersToFile() {

    try (ObjectOutputStream oos =
         new ObjectOutputStream(
         new FileOutputStream(FILE_NAME))) {

        oos.writeObject(users);

    } catch (IOException e) {
        System.out.println("Save error !");
    }
}

//  LOAD
@SuppressWarnings("unchecked")
private void loadUsersFromFile() {

    File file = new File(FILE_NAME);

    if (!file.exists()) return;

    try (ObjectInputStream ois =
         new ObjectInputStream(
         new FileInputStream(FILE_NAME))) {

        users =
        (ArrayList<User>) ois.readObject();

    } catch (Exception e) {
        System.out.println(
            "Load error / empty file"
        );
    }
}

//  LOGGING
private void logActivity(String msg) {

    try (BufferedWriter writer =
         new BufferedWriter(
         new FileWriter(
         "activity.log", true))) {

        writer.write(
            java.time.LocalDateTime.now()
            + " - " + msg
        );

        writer.newLine();

    } catch (IOException e) {
        System.out.println(
            "Logging failed !"
        );
    }
}
}
