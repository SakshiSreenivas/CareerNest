package model;
import java.io.Serializable;

public class User implements Serializable {

    protected int id;
    protected String name;
    protected String email;
    protected String role;


    public User(int id, String name, String email,String role) {
        this.id = id;
        this.name = name;
        this.email = email; 
        this.role = role; 
    }

    public int getId() {
        return id;
    }

    // ✅ NEW SETTER
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
    return role;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
