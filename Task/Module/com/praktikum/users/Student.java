package Task.Module.com.praktikum.users;

import Task.Module.com.praktikum.data.Item;
import Task.Module.com.praktikum.actions.MahasiswaActions;
import Task.Module.com.praktikum.users.User;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends User implements MahasiswaActions {
    private Scanner scanner = new Scanner(System.in);
    private static ArrayList<Item> sharedReportedItems;

    public Student(String username, String id) {
        super(username, id);
    }
    public static void setSharedReportedItems(ArrayList<Item> items) {
        sharedReportedItems = items;
    }


    @Override
    public void displayAppMenu() {
        try {
            int choice;
            do {
                System.out.println("\n=== STUDENT MENU ===");
                System.out.println("1. Report Found/Lost Items");
                System.out.println("2. View Report List");
                System.out.println("0. Logout");
                System.out.print("Select option: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        reportItem();
                        break;
                    case 2:
                        viewReportedItems();
                        break;
                    case 0:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } while (choice != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka!"); }
    }

    @Override
    public boolean login(String inputName, String inputId) {
        return this.getusername().equals(inputName) &&
                this.getid().equals(inputId);
    }

    @Override
    public void reportItem() {
        System.out.print("\nEnter item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter item description: ");
        String itemDescription = scanner.nextLine();

        System.out.print("Enter last known location: ");
        String itemLocation = scanner.nextLine();

        // Create new item with default status "Reported"
        Item newItem = new Item(itemName, itemDescription, itemLocation, "Reported");

        // Add to shared list
        sharedReportedItems.add(newItem);

        System.out.println("Item reported successfully!");
        System.out.println("Name: " + itemName);
        System.out.println("Description: " + itemDescription);
        System.out.println("Last Location: " + itemLocation);
    }

    @Override
    public void viewReportedItems() {
        for (int i = 0; i < sharedReportedItems.size(); i++) {
            Item item = sharedReportedItems.get(i);
            System.out.println((i+1) + ". " + item.getItemName() +
                    " - " + item.getLocation() +
                    " (" + item.getStatus() + ")");
        }
    }


    public void displayInfo() {
        System.out.println("Student login successful!");
        System.out.println("Name: " + getusername());
        System.out.println("Student ID: " + getid());
    }
}