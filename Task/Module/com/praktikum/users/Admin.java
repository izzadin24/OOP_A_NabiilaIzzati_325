package Task.Module.com.praktikum.users;

import Task.Module.com.praktikum.actions.AdminActions;
import Task.Module.com.praktikum.data.DataStore;
import Task.Module.com.praktikum.data.Item;
import Task.Module.com.praktikum.users.Mahasiswa;
import Task.Module.com.praktikum.users.User;

import java.util.List;

public class Admin extends User implements AdminActions {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login(String username, String password) {
        return this.getUsername().equals(username) && this.getId().equals(password);
    }

    // Implement AdminActions methods
    @Override
    public void manageItems() {
        // Implementation moved to AdminDashboard
    }

    @Override
    public void manageUsers() {
        // Implementation moved to AdminDashboard
    }

    @Override
    public void viewAllReports() {
        // Implementation moved to AdminDashboard
    }

    @Override
    public void markItemAsClaimed(Item item) {
        item.setStatus("Claimed");
    }

    @Override
    public void addStudent(String name, String id) {
        DataStore.userList.add(new Mahasiswa(name, id));
    }

    @Override
    public boolean removeStudent(String id) {
        return DataStore.userList.removeIf(user ->
                user instanceof Mahasiswa && user.getId().equals(id));
    }
}