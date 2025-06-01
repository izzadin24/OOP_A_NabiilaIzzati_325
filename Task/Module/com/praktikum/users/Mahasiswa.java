package Task.Module.com.praktikum.users;

import Task.Module.com.praktikum.actions.MahasiswaActions;
import Task.Module.com.praktikum.data.DataStore;
import Task.Module.com.praktikum.data.Item;
import Task.Module.com.praktikum.users.User;


import java.util.List;
import java.util.stream.Collectors;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String name, String id) {
        super(name, id);
    }

    @Override
    public boolean login(String name, String id) {
        return this.getUsername().equals(name) && this.getId().equals(id);
    }

    // Implement MahasiswaActions methods
    @Override
    public void reportItem(String itemName, String description, String location) {
        Item newItem = new Item(itemName, description, location, "Reported");
        newItem.setReporter(this.getUsername());
        DataStore.reportedItems.add(newItem);
    }


    @Override
    public List<Item> viewReportedItems() {
        return DataStore.reportedItems.stream()
                .filter(item -> item.getReporter() != null &&
                        item.getReporter().equals(this.getUsername()))
                .collect(Collectors.toList());
    }

}