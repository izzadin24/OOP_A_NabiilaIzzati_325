import java.util.Scanner; //import scanner from java.util

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); /*assigning variable class from Class
         construction */
        String studentID = "12345"; //assigning string construction type data of student id
        String studentName = "Nabiila Izzati"; //assigning student name
        //for output. Println is to make new line of code
        System.out.println("Select Login Type:");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt(); //int type because of 1 and 2
        scanner.nextLine();  // Consume newline character
//condition. The program will execute the codes below if users put 1 as input.
        //it will run the program for admin
        if (choice == 1) {
            // Admin Login
            System.out.print("Enter Admin Username: "); //output
            String adminUsername = scanner.nextLine(); //for variable and input
            System.out.print("Enter Admin Password: "); //output
            String adminPassword = scanner.nextLine(); //for variable and input

            String validAdminUsername = "Admin" + studentID.substring(studentID.length() - 3);
            String validAdminPassword = "Password" + studentID.substring(studentID.length() - 3);
//take last string of the string example: ID is 456789 then Admin would be Admin789


            if (adminUsername.equals(validAdminUsername) && adminPassword.equals(validAdminPassword)) {
                System.out.println("Admin login successful!"); /* comparing and if they both match,
                the admin login is successful */
            } else {
                System.out.println("Login failed! Wrong username or password.");
            } //another choice if it's 2
        } else if (choice == 2) {
            // login section of students
            System.out.print("Enter Name: "); //output
            String name = scanner.nextLine(); //variable and input
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();

            if (name.equals(studentName) && id.equals(studentID)) {
                //if matches
                System.out.println("Student login successful!");
                System.out.println("Name: " + name);
                System.out.println("Student ID: " + id);
            } else {
                System.out.println("Login failed! Wrong name or student ID.");
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close(); //to close scanner to empty the resources
    }
}
