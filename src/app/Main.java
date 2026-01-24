package app;

import model.Student;
import model.Recruiter;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();

        Student s1 = new Student(1, "Alice", "alice@mail.com", "CSE", 3);
        Recruiter r1 = new Recruiter(101, "Bob", "bob@company.com", "TechCorp");

        service.addUser(s1);
        service.addUser(r1);

        service.displayAllUsers();
    }
}
