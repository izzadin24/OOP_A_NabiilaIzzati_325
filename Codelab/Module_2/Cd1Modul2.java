
class Animal { //class Animal
    String Name; //declaring instance variables (attributes) for objects
    String Type; 
    String Sound;

   //the method is used for displaying desired outputs
    public void displayInfo() { 
        System.out.println("Nama: " + this.Name); //with call for the variable attributes
        System.out.println("Jenis: " + this.Type);  
        System.out.println("Suara: " + this.Sound);
        System.out.println(); 
        //we can use it without this. but this. helps with code readability
    }
}

public class Cd1Modul2 { //the public class which is responsible for calling the functions
    public static void main(String[] args) {
        Animal animal1 = new Animal(); //assigning objects like animals1 and animals2
        Animal animal2 = new Animal();
        
        animal1.Name = "Kucing"; //assigning each attributes with the desires outputs
        animal1.Type = "Mamalia";
        animal1.Sound = "Nyann~~";
        
        animal2.Name = "Anjing";
        animal2.Type = "Mamalia";
        animal2.Sound = "Woof-Woof!!";
        
        
        animal1.displayInfo(); //calling the methods
        animal2.displayInfo();
    }
}
