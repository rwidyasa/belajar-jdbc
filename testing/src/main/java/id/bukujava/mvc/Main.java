package id.bukujava.mvc;

import id.bukujava.mvc.controller.MahasiswaController;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Memulai aplikasi.");
        new MahasiswaController().tampilkanMenu();
        logger.info("Selesai.");
    }
}