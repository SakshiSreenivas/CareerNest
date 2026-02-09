package service;

import model.User;

public class UserService {

    private User[] users = new User[10];
    private int count = 0;

    // ADD USER
    public void addUser(User user) {

        if (count < users.length) {
            users[count] = user;
            count++;
            System.out.println("User added successfully !");
        } else {
            System.out.println("User limit reached !");
        }
    }

    // DISPLAY USERS
    public void displayAllUsers() {

        if (count == 0) {
            System.out.println("No users found !");
            return;
        }

        for (int i = 0; i < count; i++) {
            users[i].displayInfo();
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

        for (int i = 0; i < count; i++) {
            if (users[i].getId() == id) {
                return false;
            }
        }
        return true;
    }

    // 🔍 SEARCH USER
    public void searchUserById(int id) {

        for (int i = 0; i < count; i++) {

            if (users[i].getId() == id) {
                System.out.println("User Found !");
                users[i].displayInfo();
                return;
            }
        }

        System.out.println("User not found !");
    }

    // ❌ DELETE USER
    public void deleteUser(int id) {

        for (int i = 0; i < count; i++) {

            if (users[i].getId() == id) {

                for (int j = i; j < count - 1; j++) {
                    users[j] = users[j + 1];
                }

                users[count - 1] = null;
                count--;

                System.out.println("User deleted successfully !");
                return;
            }
        }

        System.out.println("User not found !");
    }

    // 🔄 UPDATE EMAIL
    public void updateEmail(int id, String newEmail) {

        for (int i = 0; i < count; i++) {

            if (users[i].getId() == id) {

                if (!isEmailValid(newEmail)) {
                    System.out.println("Invalid email !");
                    return;
                }

                users[i].setEmail(newEmail);
                System.out.println("Email updated successfully !");
                return;
            }
        }

        System.out.println("User not found !");
    }
}
