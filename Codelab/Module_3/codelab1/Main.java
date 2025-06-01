package Codelab.Module_3.codelab1;


public class Main { //Main class to run the program
  public static void main(String[] args) {
    //creating objects instances of hero and enemy with its initial name and health values
    Hero hero1 = new Hero("Brimstone", 150);
    Enemy enemy1 = new Enemy("Viper", 200);

    System.out.println("Initial status: "); //initial status output
    hero1.displayInfo(); //calling the displayinfo method with hero1's info. this case is Brimestone
    enemy1.displayInfo();//calling the displayinfo method with enemy1's info. this case is Viper

    hero1.Attack(enemy1);  //calling method attack with hero1 is attacking eenemy1
    hero1.Attack(enemy1); //same, and the output will be different
    enemy1.Attack(hero1); //viper is now attacking 


  }
}
