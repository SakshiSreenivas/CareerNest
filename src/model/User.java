package model;

import java.io.Serializable;

public class User implements Serializable {

protected int id;
protected String name;
protected String email;
protected String password;
protected String role;

public User(int id, String name, String email,
            String password, String role) {

    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
}

public int getId() {
    return id;
}

public String getEmail() {
    return email;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getRole() {
    return role;
}

public void displayInfo() {

    System.out.println("ID: " + id);
    System.out.println("Name: " + name);
    System.out.println("Email: " + email);
    System.out.println("Role: " + role);
}
public void setEmail(String email) {
    this.email = email;
}

}