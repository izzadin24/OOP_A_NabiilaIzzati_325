package Task.Module_3;

public class User {
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

    public boolean login(String inputUsername, String inputId) {
      return inputUsername.equals(username) && inputId.equals(id);
  }
  
  
    
}

class Admin extends User {
    public Admin(String username, String id) {
        super(username, id); 
    }

    @Override
    public boolean login(String inputUsername, String inputId) {
      return inputUsername.equals(getusername()) && inputId.equals(getid());
  }

  

  public void displayInfo() {
    System.out.println("Admin login successful!");
  }


}

class Student extends User {
  public Student(String username, String id) {
      super(username, id); 
  }

  @Override
  public boolean login(String inputUsername, String inputId) {
    return inputUsername.equals(getusername()) && inputId.equals(getid());
}


public void displayInfo() {
  System.out.println("Student login successful!");
  System.out.println("Name: " + getusername());
  System.out.println("Student ID: " + getid());
}


}