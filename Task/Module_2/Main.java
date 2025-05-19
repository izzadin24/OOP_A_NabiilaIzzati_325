package Task.Module_2;
import Task.Module_2.Admin;
import Task.Module_2.Student;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin", "Admin123"); //instance objects
        Student student = new Student("Nabiila Izzati", "202410370110325");

        System.out.println("Select Login Type:");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            System.out.print("Enter Admin Username: ");
            String adminUsername = scanner.nextLine();
            System.out.print("Enter Admin Password: ");
            String adminPassword = scanner.nextLine();

            if (admin.login(adminUsername, adminPassword)) {
                System.out.println("Admin login successful!");
            } else {
                System.out.println("Login failed! Wrong username or password.");
            }

        } else if (choice == 2) {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();

            if (student.login(name, id)) {
                student.displayInfo();
            } else {
                System.out.println("Login failed! Wrong name or student ID.");
            }

        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
