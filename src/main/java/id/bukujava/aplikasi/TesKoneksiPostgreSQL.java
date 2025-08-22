package id.bukujava.aplikasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesKoneksiPostgreSQL {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/belajar_jdbc";
        String user = "postgres";
        String password = "postgres";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Koneksi berhasil.");
        } catch (SQLException e) {
            System.err.println("Koneksi gagal: " + e.getMessage());
        }
    }

}
