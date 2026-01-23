package app;
import model.Recruiter;
import model.Student;
public class Main {
    public static void main(String[] args) {
        Student s = new Student(1, "Alice", "alice@mail.com", "CSE", 3);
        Recruiter r = new Recruiter(101, "Bob", "bob@company.com", "TechCorp");

        s.displayInfo();
        System.out.println();
        r.displayInfo();
    }
}
