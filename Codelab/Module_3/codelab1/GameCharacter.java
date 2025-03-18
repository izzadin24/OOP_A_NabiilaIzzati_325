package Module_3.codelab1; //package is indicating this file is in that folder

//the superclass, or parent class is called GameCharacter 
public class GameCharacter { 
  //declaring private variables
  private String name; 
  private int health;

  //method of for displaying initial status of charaters's later
  public void displayInfo() { 
    System.out.println(getname() + " has health: " + this.health);
  }
  
  //construction
  public GameCharacter(String name, int health){ 
      this.name = name; 
      this.health = health;
  }
  
  //setter method for name
  public void setName (String name) { 
      this.name = name;
  }

  //getter method for name
  public String getname() {
      return name;
  }
  
  //setter method for health
  public void setHealth (int health) {
      this.health = health;
  }

  //getter method for health
  public int getHealth() {
      return health;
  }
  
  //Attack method using GameCharacter target to be overriden later
  public void Attack(GameCharacter target){
      //no implementation in the base
  }
  
  
}


//another class named hero is a subclass and extends GameCharacter to inherit GameCharacter's properties and methods
class Hero extends GameCharacter {

  //public method 
  public Hero(String name, int health){
    //super is to inherit name and health variables
      super(name, health);
  }
  
  //we use override so that this method will be more revelant and used later 
  //it's for the hero's behaviors
  @Override
  public void Attack(GameCharacter target){
    //displaying the output of attacking character
      System.out.println(getname() + " attacks " + target.getname() + " using Orbital Strike!");
      target.setHealth(target.getHealth() - 20); //decreasing the target's health by 20
      System.out.println(target.getname() + " now has health " + getHealth() + " health");
      //target is now having the decreased health in the output
      
  }
  
  
}

//another subclasses called enemy iheriting GameCharacter
class Enemy extends GameCharacter {

  //public method for enemy to inherit GameCharavter
  public Enemy(String name, int health){
    //super is used to inherit
    super(name, health);
  }

  //override method to display the modified parent method
  @Override
  public void Attack(GameCharacter target){
    //displaying attack's output but using snake bite this time 
    System.out.println(getname() + " attacks " + target.getname() + " using Snake Bite!");
    target.setHealth(target.getHealth() - 15); //decreasing the target's health by 15 point
    System.out.println(target.getname() + " now has health " + target.getHealth() + " health");
    //output for the updated health of the current's target
  }
}
