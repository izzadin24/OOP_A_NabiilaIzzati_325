import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Admin admin = new Admin("Admin", "Admin123"); 
    Student student = new Student("Nabiila Izzati", "202410370110325");

    System.out.println("Select Login Type:");
    System.out.println("1. Admin");
    System.out.println("2. Student");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine();
 
    if (choice == 1) {
      admin.adminLogin(); 
    } else if (choice == 2) {
      student.studentLogin();
    } else {
      System.out.println("Invalid choice.");

    }

    scanner.close();

  }

}
