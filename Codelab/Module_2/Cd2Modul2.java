//No input 

class BankAccount { //Bankcoount class
    String accountNumber; //declaring the attributes needed
    String ownerName; 
    double balance; //using double to ensure the precision and accuracy

    //METHOD TO DISPLAY THE INFORMATION
    /*this method can be called anytime. AS it is public too, it wouldn't be as hard as calling
    private method*/
    public void displayInfo() {
        System.out.println(); //code formatting
        System.out.println("Nomor Rekening: " + this.accountNumber); //output and calling the attributes variables
        System.out.println("Nama Pemilik: " + this.ownerName);
        System.out.println("Saldo: Rp" + this.balance);
        System.out.println(); 
    }

    //METHOD TO DEPOSIT THE MONEY
    //this method use double amount as parameter
    public void depositMoney(double amount) {
        balance += amount; //to count the newest amount
        System.out.println(ownerName + " menyetor Rp" + amount + ". Saldo sekarang: Rp" + balance);
        //the desired output 
    }

    //METHOD TO WITHDRAW MONEY
    public void withdrawMoney(double amount) {
        if (balance >= amount) { //conditional if balance is higher or the same as amount
            balance -= amount; //newest amount is balance - amount entered
            System.out.println(ownerName + " menarik Rp" + amount + ". (Berhasil) Saldo sekarang: Rp" + balance);
        } else { //this will be printed out if it's insufficient
            System.out.println(ownerName + " menarik Rp" + amount + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + balance);
            System.out.println();
        }
    }
}

public class Cd2Modul2 { //the Main class 
    public static void main(String[] args) {

        //assigning objects we have account1 and account2
        BankAccount account1 = new BankAccount(); 
        BankAccount account2 = new BankAccount();

        //assigning values to the attributes
        account1.accountNumber = "202410370110325"; 
        account1.ownerName = "Nabiila Izzati"; 
        account1.balance = 3800000.0; //fixed amount. In this instance, I don't use scanner 

        //assigning values to the attributes
        account2.accountNumber = "202410370110038";
        account2.ownerName = "Amalia"; 
        account2.balance = 1000000.0;

        //calling displayinfo method before calling the other methods
        account1.displayInfo(); 
        account2.displayInfo();

        account1.depositMoney(200000.0); //calling the depositmoney method
        account2.depositMoney(500000.0); //with fixed amount in the parameter

        account1.withdrawMoney(800000.0); ///calling the withdraw method
        account2.withdrawMoney(300000.0);

        account1.displayInfo(); //to show updated displayinfo
        account2.displayInfo();
    }
}
