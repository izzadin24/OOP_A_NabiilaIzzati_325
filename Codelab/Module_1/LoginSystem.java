import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String studentID = "12345";
        String studentName = "Nabiila Izzati";
        System.out.println("Select Login Type:");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        if (choice == 1) {
            // Admin Login
            System.out.print("Enter Admin Username: ");
            String adminUsername = scanner.nextLine();
            System.out.print("Enter Admin Password: ");
            String adminPassword = scanner.nextLine();

            String validAdminUsername = "Admin" + studentID.substring(studentID.length() - 3);
            String validAdminPassword = "Password" + studentID.substring(studentID.length() - 3);

            if (adminUsername.equals(validAdminUsername) && adminPassword.equals(validAdminPassword)) {
                System.out.println("Admin login successful!");
            } else {
                System.out.println("Login failed! Wrong username or password.");
            }
        } else if (choice == 2) {
            // Student Login
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();

            if (name.equals(studentName) && id.equals(studentID)) {
                System.out.println("Student login successful!");
                System.out.println("Name: " + name);
                System.out.println("Student ID: " + id);
            } else {
                System.out.println("Login failed! Wrong name or student ID.");
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
