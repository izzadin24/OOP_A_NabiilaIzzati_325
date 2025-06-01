package Task.Module.com.praktikum.actions;

import Task.Module.com.praktikum.data.Item;

public interface AdminActions {
    void manageItems();
    void manageUsers();
    void viewAllReports();
    void markItemAsClaimed(Item item);
    void addStudent(String name, String id);
    boolean removeStudent(String id);
}
