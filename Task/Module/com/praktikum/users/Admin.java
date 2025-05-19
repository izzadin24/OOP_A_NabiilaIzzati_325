package Task.Module.com.praktikum.users;


import Task.Module.com.praktikum.actions.AdminActions;
import Task.Module.com.praktikum.data.Item;
import Task.Module.com.praktikum.users.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private Scanner scanner = new Scanner(System.in);
    private static ArrayList<Item> sharedReportedItems;
    private static ArrayList<User> sharedUserList;

    public Admin(String username, String id) {
        super(username, id);
    }

    // Method untuk set shared ArrayList
    public static void setSharedReportedItems(ArrayList<Item> items) {
        sharedReportedItems = items;
    }

    public static void setSharedUserList(ArrayList<User> users) {
        sharedUserList = users;
    }

    @Override
    public void displayAppMenu() {
        int choice;
        do {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Manage Item Reports");
            System.out.println("2. Manage Student Data");
            System.out.println("0. Logout");
            System.out.print("Select option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }

    @Override
    public void manageItems() {
        int choice;
        do {
            System.out.println("\n=== MANAGE ITEMS ===");
            System.out.println("1. View All Reports");
            System.out.println("2. Mark Item as Claimed");
            System.out.println("0. Back");
            System.out.print("Select index: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllReports();
                    break;
                case 2:
                    markItemAsClaimed();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }

    private void viewAllReports() {
        if (sharedReportedItems.isEmpty()) {
            System.out.println("No items have been reported yet.");
            return;
        }

        System.out.println("\n=== ALL REPORTED ITEMS ===");
        int index = 1;
        for (Item item : sharedReportedItems) {
            System.out.println(index++ + ". " + item.getItemName() +
                    " - " + item.getDescription() +
                    " (" + item.getStatus() + ")");
            System.out.println("   Location: " + item.getLocation());
        }
    }

    private void markItemAsClaimed() {
        if (sharedReportedItems.isEmpty()) {
            System.out.println("No items to mark as claimed.");
            return;
        }

        // Show only reported items
        System.out.println("\n=== ITEMS AVAILABLE FOR CLAIM ===");
        int counter = 1;
        for (int i = 0; i < sharedReportedItems.size(); i++) {
            Item item = sharedReportedItems.get(i);
            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                System.out.println(counter++ + ". " + item.getItemName() +
                        " - " + item.getLocation());
            }
        }

        if (counter == 1) {
            System.out.println("No items with 'Reported' status.");
            return;
        }

        try {
            System.out.print("\nEnter item number to mark as claimed: ");
            int itemNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Find the actual index in the list
            int actualIndex = -1;
            int currentCounter = 1;
            for (int i = 0; i < sharedReportedItems.size(); i++) {
                if ("Reported".equalsIgnoreCase(sharedReportedItems.get(i).getStatus())) {
                    if (currentCounter == itemNumber) {
                        actualIndex = i;
                        break;
                    }
                    currentCounter++;
                }
            }

            if (actualIndex != -1) {
                sharedReportedItems.get(actualIndex).setStatus("Claimed");
                System.out.println("Item successfully marked as claimed!");
            } else {
                throw new IndexOutOfBoundsException("Indeks tidak valid!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number!");
            scanner.nextLine(); // Clear invalid input
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void manageUsers() {
        try {
            int choice;
            do {

                System.out.println("\n=== MANAGE STUDENTS ===");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("0. Back");

                System.out.print("Select option: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } while (choice != 0);
        }  catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka!"); }
    }

    private void addStudent() {
        System.out.print("\nEnter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        // Check if student already exists
        for (User user : sharedUserList) {
            if (user instanceof Student && user.getid().equals(id)) {
                System.out.println("Student with this ID already exists!");
                return;
            }
        }

        sharedUserList.add(new Student(name, id));
        System.out.println("Student added successfully!");
    }

    private void removeStudent() {
        System.out.print("\nEnter student ID to remove: ");
        String id = scanner.nextLine();

        Iterator<User> iterator = sharedUserList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user instanceof Student && user.getid().equals(id)) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found!");
        }
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(getusername()) && inputPassword.equals(getid());
    }

    public void displayInfo() {
        System.out.println("Admin login successful!");
        System.out.println("Username: " + getusername());
    }
}