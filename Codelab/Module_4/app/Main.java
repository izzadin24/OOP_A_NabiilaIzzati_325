package Module_4.app; //package seperti memberitahukan di mana file ini berada
import Module_4.Perpustakaan.*; //mengimport yang ada di folder perpustakaan

public class Main {
    public static void main(String[] args) {
        
        NonFiksi bukuNonFiksi = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Fiksi bukuFiksi = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        bukuNonFiksi.displayInfo(); 
        bukuFiksi.displayInfo();

        System.out.println();

        Anggota anggota1 = new Anggota("Nabiila Izzati", "A325");
        Anggota anggota2 = new Anggota("Amalia Sanyoto", "A038");

        anggota1.displayInfo();
        anggota2.displayInfo();

        System.out.println();

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);

        System.out.println();
        
        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}
