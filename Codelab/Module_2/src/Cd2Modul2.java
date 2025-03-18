package src;
//THIS ONE HAS INPUT SECTION

import java.util.Scanner;

class BankAccount {
  String accountNumber;
  String ownerName;
  double balance;
  
  Scanner scanner = new Scanner(System.in);

  //METHOD TO DISPLAY THE INFORMATION
  public void displayInfo() {
      System.out.println();
      System.out.println("Nomor Rekening: " + this.accountNumber);
      System.out.println("Nama Pemilik: " + this.ownerName);
      System.out.println("Saldo: Rp" + this.balance);
      System.out.println();
  }

  //METHOD TO DEPOSIT THE MONEY
  public void depositMoney() {
      System.out.print("Jumlah yang ingin disetor untuk " + ownerName + ": Rp");  
      double amount = scanner.nextDouble();
      balance += amount;
      System.out.println(ownerName + " menyetor Rp: " + amount + ". Saldo sekarang: Rp" + balance);
      System.out.println();
  }

  
  public void withdrawMoney() {
    System.out.print("Masukkan jumlah yang ingin ditarik untuk " + ownerName + ": Rp");
    double amount = scanner.nextDouble(); // Input dari user
      if (balance >= amount) {
          balance -= amount;
          System.out.println(ownerName + " menarik Rp" + amount + ". (Berhasil) Saldo sekarang: Rp" + balance);
      } else {
          System.out.println(ownerName + " menarik Rp" + amount + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + balance);
      }
      System.out.println();
  }
}


public class Cd2Modul2 {
  public static void main(String[] args) {
      
      BankAccount account1 = new BankAccount();
      BankAccount account2 = new BankAccount();

      account1.accountNumber = "202410370110325";
      account1.ownerName = "Nabiila Izzati"; 
      account1.balance = 500000.0;

      account2.accountNumber = "202410370110038";
      account2.ownerName = "Amalia"; 
      account2.balance = 1000000.0;


      account1.displayInfo();
      account2.displayInfo();

      
      account1.depositMoney();
      account2.depositMoney();

      
      account1.withdrawMoney();
      account2.withdrawMoney();

      
      account1.displayInfo();
      account2.displayInfo();
  }
}

