package id.bukujava.crud;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MahasiswaDao dao = new MahasiswaDao();
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        String nama;
        String jurusan;

        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Tampilkan Semua");
            System.out.println("2. Tambah");
            System.out.println("3. Ubah");
            System.out.println("4. Hapus");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // hapus newline

            switch (pilihan) {
                case 1:
                    List<Mahasiswa> daftar = dao.semua();
                    for (Mahasiswa m : daftar) {
                        System.out.println(m.getId() + " - " + m.getNama() + " (" + m.getJurusan() + ")");
                    }
                    break;
                case 2:
                    System.out.print("Nama: ");
                    nama = scanner.nextLine();
                    System.out.print("Jurusan: ");
                    jurusan = scanner.nextLine();
                    dao.tambah(new Mahasiswa(nama, jurusan));
                    break;
                case 3:
                    System.out.print("ID Mahasiswa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nama Baru: ");
                    nama = scanner.nextLine();
                    System.out.print("Jurusan Baru: ");
                    jurusan = scanner.nextLine();
                    Mahasiswa m = new Mahasiswa(nama, jurusan);
                    m.setId(id);
                    dao.ubah(m);
                    break;
                case 4:
                    System.out.print("ID yang akan dihapus: ");
                    int idHapus = scanner.nextInt();
                    dao.hapus(idHapus);
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);
    }
}