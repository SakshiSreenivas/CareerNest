package model;

public class Recruiter extends User {
    private String companyName;

    public Recruiter(int id, String name, String email, String companyName) {
        super(id, name, email);
        this.companyName = companyName;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Company: " + companyName);
    }
}
