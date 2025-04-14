public class Admin {
  private String validUsername;
  private String validPassword;

  public Admin(String validUsername, String validPassword) { //construction
      this.validUsername = validUsername;
      this.validPassword = validPassword;
  }

  public boolean login(String username, String password) { //method login verify login
      return username.equals(validUsername) && password.equals(validPassword);
  }
}
