package Task.Module.com.praktikum.users;

public abstract class User {
    private String username;
    private String id;

    public User(String username, String id) {
        this.username = username;
        this.id = id;
    }

    public abstract boolean login(String inputUsername, String inputId);

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}