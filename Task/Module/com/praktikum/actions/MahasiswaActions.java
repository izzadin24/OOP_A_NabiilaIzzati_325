package Task.Module.com.praktikum.actions;

import Task.Module.com.praktikum.data.Item;

import java.util.List;

public interface MahasiswaActions {
    void reportItem(String itemName, String description, String location);
    List<Item> viewReportedItems();
}
