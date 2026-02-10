package model;
import java.io.Serializable;

public class User implements Serializable {

    protected int id;
    protected String name;
    protected String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email; 
    }

    public int getId() {
        return id;
    }

    // ✅ NEW SETTER
    public void setEmail(String email) {
        this.email = email;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
