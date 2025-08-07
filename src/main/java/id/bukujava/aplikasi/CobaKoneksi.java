package id.bukujava.aplikasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CobaKoneksi {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_belajar";
        String user = "root";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Koneksi berhasil.");
        } catch (SQLException e) {
            System.err.println("Koneksi gagal: " + e.getMessage());
        }
    }
}