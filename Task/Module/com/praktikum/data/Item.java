package Task.Module.com.praktikum.data;

public class Item {
    private String itemName;
    private String description;
    private String location;
    private String status; //vale: reported, claimed

    public Item (String itemName, String description, String location, String status ) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    public String getItemName() { //GETTER
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
