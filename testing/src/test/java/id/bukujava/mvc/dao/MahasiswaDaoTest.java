package id.bukujava.mvc.dao;

import id.bukujava.mvc.model.Mahasiswa;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MahasiswaDaoTest {

    private static Connection conn;
    private static MahasiswaDao dao;

    @BeforeAll
    static void setupDatabase() throws Exception {
        conn = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("""
                        CREATE TABLE mahasiswa(
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nama VARCHAR(100),
                          jurusan VARCHAR(100)
                        )
                    """);
        }

        dao = new MahasiswaDao(() -> {
            try {
                return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void testTambahDanAmbil() {
        Mahasiswa m = new Mahasiswa("Tes", "Informatika");
        dao.tambah(m);

        List<Mahasiswa> hasil = dao.semua();
        assertFalse(hasil.isEmpty());
        assertEquals("Tes", hasil.getFirst().getNama());
    }

    @AfterAll
    static void bersihkan() throws Exception {
        conn.createStatement().execute("DROP TABLE mahasiswa");
        conn.close();
    }
}