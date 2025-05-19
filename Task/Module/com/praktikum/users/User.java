package Task.Module.com.praktikum.users;

public abstract class User {
    private String username;
    private String id; 

    public User(String username, String id) { 
        this.username = username; 
        this.id = id;
    }

    public void setusername(String username) { 
        this.username = username;
    }

    public String getusername() {
        return username;
    }
  
    public void setid(String id) {
        this.id = id;
    }

    public String getid() {
        return id;
    }

    public abstract boolean login(String inputUsername, String inputId);

    public abstract void displayAppMenu();

    public abstract void displayInfo();
}




