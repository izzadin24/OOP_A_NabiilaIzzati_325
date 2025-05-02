

class Student {
  private String validName;
  private String validID;

  public Student(String validName, String validID) {
      this.validName = validName; 
      this.validID = validID;
  }

  public boolean login(String name, String id) { //method that will be called when user inout
      return name.equals(validName) && id.equals(validID);
  }

  public void displayInfo() {
      System.out.println("Student login successful!");
      System.out.println("Name: " + validName);
      System.out.println("Student ID: " + validID);
  }
}
