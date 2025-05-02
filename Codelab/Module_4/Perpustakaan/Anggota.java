package Module_4.Perpustakaan;

//mengimplementasikan dari peminjaman 
public class Anggota implements Peminjaman {
  private String name;
  private String idMember;

  public Anggota(String name, String idMember) {
      this.name = name;
      this.idMember = idMember;
  }

  public void displayInfo() {
      System.out.println("Anggota: " + name + " (ID: " + idMember + ")");
  }

  @Override
  public void pinjamBuku(String title) {
      System.out.println(name + " meminjam buku berjudul: " + title);
  }

  @Override
  public void pinjamBuku(String title, int duration) {
      System.out.println(name + " meminjam buku " + title + " selama " + duration + " hari.");
  }

  @Override
  public void kembalikanBuku(String title) {
      System.out.println(name + " mengembalikan buku berjudul: " + title);
  }
}

