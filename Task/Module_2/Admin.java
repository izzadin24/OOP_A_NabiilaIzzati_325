import java.util.Scanner;

public class Admin {
  String validusername; 
  String validpassword;

  public Admin(String validusername, String validpassword){ 
    this.validusername = validusername; 
    this.validpassword = validpassword;
}
   
  public void adminLogin() { 
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Admin Username: "); //output
    String adminUsername = scanner.nextLine(); //for variable and input
    System.out.print("Enter Admin Password: "); //output
    String adminPassword = scanner.nextLine(); //for variable and input



    if (adminUsername.equals(validusername) && adminPassword.equals(validpassword)) {
      System.out.println("Admin login successful!");
    } else {
      System.out.println("Login failed! Wrong username or password.");
    }
    scanner.close();
  }

}
