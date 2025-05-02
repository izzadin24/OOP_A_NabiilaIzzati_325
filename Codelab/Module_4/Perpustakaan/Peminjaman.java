package Module_4.Perpustakaan;

public interface Peminjaman {
  void pinjamBuku(String title);
  void pinjamBuku(String title, int duration);
  void kembalikanBuku(String title);
}

