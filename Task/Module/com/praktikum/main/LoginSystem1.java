package Task.Module.com.praktikum.main;


import Task.Module.com.praktikum.data.Item;
import Task.Module.com.praktikum.users.*;
import Task.Module.com.praktikum.Exceptions.AuthenticationException;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LoginSystem1 {
    static ArrayList<User> userList = new ArrayList<>();
    static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        initializeDefaultUsers();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== LOGIN SYSTEM ===");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        User authenticatedUser = null;

        if (choice == 1) {
            // Admin login
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            try {
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                authenticatedUser = authenticateUser(username, password, true);
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harus berupa angka!"); }

        } else if (choice == 2) {
            // Student login
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();

            authenticatedUser = authenticateUser(name, id, false);


        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        if (authenticatedUser != null) {
            authenticatedUser.displayInfo();
            authenticatedUser.displayAppMenu();
        } else {
            System.out.println("Login failed! Invalid credentials.");
        }

        scanner.close();
    }

    private static void initializeDefaultUsers() {

        userList.add(new Admin("admin1", "admin123"));
        userList.add(new Admin("admin2", "securepass"));

        userList.add(new Student("Eren Jaeger", "15570"));
        userList.add(new Student("Nabiila Izzati", "202410370110325"));
    }

    private static void initializeDefaultItems() {

    }


    private static User authenticateUser(String credential1, String credential2, boolean isAdmin) {
        try {
            for (User user : userList) {
                if (isAdmin && user instanceof Admin) {
                    if (user.login(credential1, credential2)) {
                        return user;
                    }
                } else if (!isAdmin && user instanceof Student) {
                    if (user.login(credential1, credential2)) {
                        return user;
                    }
                }
            }
            throw new AuthenticationException("Invalid credentials for " +
                    (isAdmin ? "admin" : "student"));
        } catch (AuthenticationException e) {
            System.out.println("Authentication Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka!");
        }
            return null;
        }
}