import java.util.Scanner;

public class Student {
  String validusername1; 
  String validpassword1;

  public Student(String validusername1, String validpassword1){ 
    this.validusername1 = validusername1; 
    this.validpassword1 = validpassword1;
  }
  public void displayInfo() { 
    System.out.println("Student login successful!");
    System.out.println("Name: " + validusername1);
    System.out.println("Student ID: " + validpassword1);
  }

  public void studentLogin() { 
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Student ID: ");
    String id = scanner.nextLine();
    
    if (name.equals(validusername1) && id.equals(validpassword1)) {
      //if matches
      displayInfo();
      } else {
        System.out.println("Login failed! Wrong name or student ID.");
     }
     scanner.close();
  }


}