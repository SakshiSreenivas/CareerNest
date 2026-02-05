package app;

import java.util.Scanner;
import model.Student;
import model.Recruiter;
import service.UserService;

/*
 * Entry point of CareerNest backend system.
 * Acts like a Controller in real backend apps.
 */
public class Main {

    public static void main(String[] args) {

        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Service layer object
        UserService service = new UserService();

        // Infinite loop → keeps backend running
        while (true) {

            // Menu UI
            System.out.println("\n=== CareerNest Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Recruiter");
            System.out.println("3. View All Users");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                /*
                 * CASE 1 → Add Student
                 * Collects input → Validates → Stores
                 */
                case 1:

                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    if (!service.isIdUnique(sid)) {
                        System.out.println("ID already exists ❌");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String sname = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String semail = sc.nextLine();

                    if (!service.isEmailValid(semail)) {
                        System.out.println("Invalid email format ❌");
                        break;
                    }

                    System.out.print("Enter Branch: ");
                    String branch = sc.nextLine();

                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    // Create Student object
                    Student student =
                        new Student(sid, sname,
                                    semail, branch, year);

                    // Send to service layer
                    service.addUser(student);
                    break;

                /*
                 * CASE 2 → Add Recruiter
                 */
                case 2:

                    System.out.print("Enter Recruiter ID: ");
                    int rid = sc.nextInt();
                    sc.nextLine();

                    if (!service.isIdUnique(rid)) {
                        System.out.println("ID already exists ❌");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String rname = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String remail = sc.nextLine();

                    if (!service.isEmailValid(remail)) {
                        System.out.println("Invalid email format ❌");
                        break;
                    }

                    System.out.print("Enter Company Name: ");
                    String company = sc.nextLine();

                    Recruiter recruiter =
                        new Recruiter(rid, rname,
                                      remail, company);

                    service.addUser(recruiter);
                    break;

                /*
                 * CASE 3 → Display All Users
                 */
                case 3:
                    service.displayAllUsers();
                    break;

                /*
                 * CASE 4 → Exit System
                 */
                case 4:
                    System.out.println("Exiting CareerNest 👋");
                    sc.close();
                    return;

                /*
                 * Default → Invalid input
                 */
                default:
                    System.out.println("Invalid choice ⚠️");
            }
        }
    }
}
