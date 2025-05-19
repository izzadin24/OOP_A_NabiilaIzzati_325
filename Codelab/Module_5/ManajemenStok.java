package Codelab.Module_5;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Codelab.Module_5.Barang;

public class ManajemenStok {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Barang> daftarBarang = new ArrayList<>();

        daftarBarang.add(new Barang("Kertas", 50));
        daftarBarang.add(new Barang("Buku", 30));
        int choice;
        do {
            System.out.println("===== Menu Manajemen Stok ===== ");
            System.out.println("1. Tambah barang baru");
            System.out.println("2. Tampilkan semua barang");
            System.out.println("3. Kurangi stok barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 :
                    System.out.print("\nMasukkan nama barang: ");
                    String namaBarang = scanner.nextLine();
                    try {
                        System.out.print("Masukkan stok awal: ");
                        int stokAwal = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan newline

                        
                        Barang barangBaru = new Barang(namaBarang, stokAwal);
                        daftarBarang.add(barangBaru);
                        System.out.println("Barang berhasil ditambahkan!");
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Input stok harus berupa angka!");
                        scanner.nextLine(); // Membersihkan input yang salah
                    }
                    break;
                case 2 :
                    System.out.println("\n=== Daftar Barang ===");
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        for (Barang barang : daftarBarang) {
                            System.out.println("- " + barang.getNama() + ", Stok: " + barang.getStok());
                        }
                    }
                    System.out.println("======================");
                    break;
                case 3 :
                    System.out.println("\n=== Kurangi Stok Barang ===");

                    // Tampilkan daftar barang dengan indeks
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                        break;
                    }

                    System.out.println("Daftar Barang:");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang barang = daftarBarang.get(i);
                        System.out.println(i + ". " + barang.getNama() + " (Stok: " + barang.getStok() + ")");
                    }

                    try {
                        // Input indeks barang
                        System.out.print("Masukkan nomor indeks barang: ");
                        int index = scanner.nextInt();

                        // Input jumlah yang akan dikurangi
                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlahDiambil = scanner.nextInt();

                        // Validasi indeks
                        if (index < 0 || index >= daftarBarang.size()) {
                            throw new IndexOutOfBoundsException("Indeks tidak valid!");
                        }

                        Barang barang = daftarBarang.get(index);

                        // Validasi stok cukup
                        if (jumlahDiambil > barang.getStok()) {
                            throw new StokTidakCukupException(
                                    "Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok()
                            );
                        }

                        if (jumlahDiambil <= 0) {
                            System.out.println("Jumlah harus lebih dari 0!");
                            break;
}

                        // Kurangi stok
                        barang.setStok(barang.getStok() - jumlahDiambil);
                        System.out.println(
                                "Berhasil mengurangi stok " + barang.getNama() +
                                        " sebanyak " + jumlahDiambil +
                                        ". Stok sekarang: " + barang.getStok()
                        );

                    } catch (InputMismatchException e) {
                        System.out.println("Error: Input harus berupa angka!");
                        scanner.nextLine(); // Clear invalid input
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (StokTidakCukupException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 0 :
                    System.out.println("Terima kasih!");
                    break;
                default :
                    System.out.println("pilihan tidak valid");
            }
            
        } while (choice != 0 );
        scanner.close();

    }
}
