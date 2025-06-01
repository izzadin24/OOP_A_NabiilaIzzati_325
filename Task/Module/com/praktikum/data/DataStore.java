package Task.Module.com.praktikum.data;

import java.util.ArrayList;

import Task.Module.com.praktikum.users.Admin;
import Task.Module.com.praktikum.users.User;
import Task.Module.com.praktikum.users.*;

public class DataStore {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void initialize() {
        // Initialize default users
        userList.add(new Admin("admin1", "admin123"));
        userList.add(new Admin("admin2", "securepass"));
        userList.add(new Mahasiswa("Eren Jaeger", "15570"));
        userList.add(new Mahasiswa("Nabiila Izzati", "202410370110325"));
        userList.add(new Mahasiswa("Herdiana", "202410370311234"));
        userList.add(new Mahasiswa("Nisrina", "202410370411567"));

        // Initialize default items
        reportedItems.add(new Item("Laptop", "Lenovo ThinkPad", "Lab Komputer", "Reported"));
        reportedItems.add(new Item("Kunci", "Kunci mobil Toyota", "Parkiran Utara", "Claimed"));
        reportedItems.add(new Item("HP", "iPhone 12 Pro Max", "Meja A-01", "Reported"));
        reportedItems.add(new Item("Dompet", "Dompet Pria Kulit Hitam", "Meja B-19", "Reported"));
    }

    public static User authenticateAdmin(String username, String password) {
        for (User user : userList) {
            if (user instanceof Admin && user.login(username, password)) {
                return user;
            }
        }
        return null;
    }

    public static User authenticateMahasiswa(String name, String id) {
        for (User user : userList) {
            if (user instanceof Mahasiswa && user.login(name, id)) {
                return user;
            }
        }
        return null;
    }
}