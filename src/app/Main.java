package app;

import java.util.Scanner;
import model.Student;
import model.User;
import model.Recruiter;
import service.UserService;

/*

* Entry point of CareerNest backend system.
* Acts like a Controller in real backend apps.
  */
  public class Main {

  public static void main(String[] args) {


   // Tracks logged-in user session
   User currentUser = null;

   // Scanner for user input
   Scanner sc = new Scanner(System.in);

   // Service layer object
   UserService service = new UserService();

   // Infinite loop → keeps backend running
   while (true) {

       // Menu UI
       System.out.println("\n=== CareerNest Menu ===");
       System.out.println("1. Login");
       System.out.println("2. Add Student");
       System.out.println("3. Add Recruiter");
       System.out.println("4. View All Users");
       System.out.println("5. Search User");
       System.out.println("6. Delete User");
       System.out.println("7. Update Email");
       System.out.println("8. Logout");
       System.out.println("9. Exit");
       System.out.print("Enter choice: ");

       int choice = sc.nextInt();
       sc.nextLine(); // consume newline

       switch (choice) {

           // LOGIN
           case 1:

               System.out.print("Enter email: ");
               String email = sc.nextLine();

               System.out.print("Enter password: ");
               String password = sc.nextLine();

               currentUser =
                   service.login(email, password);
               break;

           // ADD STUDENT
           case 2:

               System.out.print("Enter Student ID: ");
               int sid = sc.nextInt();
               sc.nextLine();

               if (!service.isIdUnique(sid)) {
                   System.out.println("ID already exists !");
                   break;
               }

               System.out.print("Enter Name: ");
               String sname = sc.nextLine();

               System.out.print("Enter Email: ");
               String semail = sc.nextLine();

               if (!service.isEmailValid(semail)) {
                   System.out.println("Invalid email format !");
                   break;
               }

               System.out.print("Enter Password: ");
               String spass = sc.nextLine();

               System.out.print("Enter Branch: ");
               String branch = sc.nextLine();

               System.out.print("Enter Year: ");
               int year = sc.nextInt();
               sc.nextLine();

               Student student =
                   new Student(
                       sid,
                       sname,
                       semail,
                       spass,
                       branch,
                       year
                   );

               service.addUser(student);
               break;

           // ADD RECRUITER
           case 3:

               System.out.print("Enter Recruiter ID: ");
               int rid = sc.nextInt();
               sc.nextLine();

               if (!service.isIdUnique(rid)) {
                   System.out.println("ID already exists !");
                   break;
               }

               System.out.print("Enter Name: ");
               String rname = sc.nextLine();

               System.out.print("Enter Email: ");
               String remail = sc.nextLine();

               if (!service.isEmailValid(remail)) {
                   System.out.println("Invalid email format !");
                   break;
               }

               System.out.print("Enter Password: ");
               String rpass = sc.nextLine();

               System.out.print("Enter Company Name: ");
               String company = sc.nextLine();

               Recruiter recruiter =
                   new Recruiter(
                       rid,
                       rname,
                       remail,
                       rpass,
                       company
                   );

               service.addUser(recruiter);
               break;

           // VIEW USERS
           case 4:
               service.displayAllUsers();
               break;

           // SEARCH USER
           case 5:

               System.out.print("Enter ID to search: ");
               int searchId = sc.nextInt();

               service.searchUserById(searchId);
               break;

           // DELETE USER
           case 6:

               if (currentUser == null) {
                   System.out.println(
                       "Please login first !"
                   );
                   break;
               }

               System.out.print(
                   "Enter ID to delete: "
               );
               int deleteId = sc.nextInt();

               service.deleteUser(
                   deleteId,
                   currentUser.getRole()
               );
               break;

           // UPDATE EMAIL
           case 7:

               System.out.print("Enter ID: ");
               int uid = sc.nextInt();
               sc.nextLine();

               System.out.print(
                   "Enter new Email: "
               );
               String newEmail = sc.nextLine();

               service.updateEmail(uid, newEmail);
               break;

           // LOGOUT
           case 8:

               currentUser = null;
               System.out.println(
                   "Logged out successfully."
               );
               break;

           // EXIT
           case 9:

               System.out.println("Exiting...");
               sc.close();
               return;

           default:
               System.out.println(
                   "Invalid choice !"
               );
       }
    }
   }
  

  }
  
