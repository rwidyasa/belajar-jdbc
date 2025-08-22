package id.bukujava.mvc.view;

import id.bukujava.mvc.model.Mahasiswa;

import java.util.List;
import java.util.Scanner;

public class MahasiswaView {
    private final Scanner scanner = new Scanner(System.in);

    public int tampilkanMenuUtama() {
        System.out.println("\n=== Menu Mahasiswa ===");
        System.out.println("1. Lihat Data");
        System.out.println("2. Tambah");
        System.out.println("3. Ubah");
        System.out.println("4. Hapus");
        System.out.println("0. Keluar");
        System.out.print("Pilih: ");
        return scanner.nextInt();
    }

    public void tampilkanDaftar(List<Mahasiswa> daftar) {
        for (Mahasiswa m : daftar) {
            System.out.println(m.getId() + " - " + m.getNama() + " (" + m.getJurusan() + ")");
        }
    }

    public Mahasiswa inputMahasiswaBaru() {
        scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Jurusan: ");
        String jurusan = scanner.nextLine();
        return new Mahasiswa(nama, jurusan);
    }

    public Mahasiswa inputMahasiswaUbah() {
        System.out.print("ID yang akan diubah: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nama Baru: ");
        String nama = scanner.nextLine();
        System.out.print("Jurusan Baru: ");
        String jurusan = scanner.nextLine();

        Mahasiswa m = new Mahasiswa(nama, jurusan);
        m.setId(id);
        return m;
    }

    public int inputIdHapus() {
        System.out.print("ID yang akan dihapus: ");
        return scanner.nextInt();
    }
}