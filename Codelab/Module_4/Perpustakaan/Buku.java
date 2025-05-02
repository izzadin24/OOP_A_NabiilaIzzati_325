package Module_4.Perpustakaan;

//abstrack class untuk buku, karena buku bisa memilki berbagai genre, dll
public abstract class Buku {
  //protected agar bisa langsung diakses oleh fiksi dan nonfiksi
  protected String judul;
  protected String penulis;


  public Buku(String judul, String penulis) { //concrete method
      this.judul = judul;
      this.penulis = penulis;
    
  }

  //akan dioverride nanti tergantung kebutuhan. abstact 
  public abstract void displayInfo();
}

