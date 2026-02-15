package model;

public class Student extends User {
    private String branch;
    private int year;

    public Student(int id, String name, String email, String branch, int year) {
        super(id, name, email, "STUDENT");
        this.branch = branch;
        this.year = year;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Branch: " + branch);
        System.out.println("Year: " + year);
    }
}
