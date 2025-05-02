package Module_4.Perpustakaan;


public class NonFiksi extends Buku {
  private String bidang;

  public NonFiksi(String judul, String penulis, String bidang) {
      super(judul, penulis);
      this.bidang = bidang;
  }

  @Override //dari buku untuk display buku nonfiksi nantinya
  public void displayInfo() {
      System.out.println("Buku Non-Fiksi: " + judul + " oleh " + penulis + " (Bidang: " + bidang + ")");
  }
}