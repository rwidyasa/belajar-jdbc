package id.bukujava.mvc.controller;

import id.bukujava.mvc.dao.MahasiswaDao;
import id.bukujava.mvc.view.MahasiswaView;

public class MahasiswaController {
    private final MahasiswaDao dao = new MahasiswaDao();
    private final MahasiswaView view = new MahasiswaView();

    public void tampilkanMenu() {
        while (true) {
            int pilihan = view.tampilkanMenuUtama();
            switch (pilihan) {
                case 1 -> view.tampilkanDaftar(dao.semua());
                case 2 -> dao.tambah(view.inputMahasiswaBaru());
                case 3 -> dao.ubah(view.inputMahasiswaUbah());
                case 4 -> dao.hapus(view.inputIdHapus());
                case 0 -> {
                    System.out.println("Keluar.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}