package model;

public class Recruiter extends User {


private String company;

public Recruiter(int id, String name,
                 String email, String password,
                 String company) {

    super(id, name, email, password, "RECRUITER");

    this.company = company;
}

@Override
public void displayInfo() {

    super.displayInfo();

    System.out.println("Company: " + company);
}


}
