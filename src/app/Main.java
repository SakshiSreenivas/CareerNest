package app;

import java.util.Scanner;
import model.Student;
import model.Recruiter;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService service = new UserService();

        while (true) {
            System.out.println("\n--- CareerNest Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Recruiter");
            System.out.println("3. View All Users");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s = new Student(1, "Alice", "alice@mail.com", "CSE", 3);
                    service.addUser(s);
                    break;

                case 2:
                    Recruiter r = new Recruiter(101, "Bob", "bob@company.com", "TechCorp");
                    service.addUser(r);
                    break;

                case 3:
                    service.displayAllUsers();
                    break;

                case 4:
                    System.out.println("Exiting CareerNest...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
