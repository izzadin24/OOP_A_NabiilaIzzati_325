package Task.Module_2;

class Admin {
  private String validUsername;
  private String validPassword;

  public Admin(String validUsername, String validPassword) { //constructor
      this.validUsername = validUsername;
      this.validPassword = validPassword;
  }

  public boolean login(String username, String password) { //method login verify login
      return username.equals(validUsername) && password.equals(validPassword);
  }
}
