package id.bukujava.mvc.dao;

import id.bukujava.mvc.model.Mahasiswa;
import id.bukujava.mvc.util.KoneksiPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDao {

    public void tambah(Mahasiswa m) {
        String sql = "INSERT INTO mahasiswa (nama, jurusan) VALUES (?, ?)";

        try (Connection conn = KoneksiPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNama());
            stmt.setString(2, m.getJurusan());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Mahasiswa> semua() {
        List<Mahasiswa> daftar = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";

        try (Connection conn = KoneksiPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mahasiswa m = new Mahasiswa();
                m.setId(rs.getInt("id"));
                m.setNama(rs.getString("nama"));
                m.setJurusan(rs.getString("jurusan"));
                daftar.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return daftar;
    }

    public void ubah(Mahasiswa m) {
        String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE id = ?";

        try (Connection conn = KoneksiPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNama());
            stmt.setString(2, m.getJurusan());
            stmt.setInt(3, m.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hapus(int id) {
        String sql = "DELETE FROM mahasiswa WHERE id = ?";

        try (Connection conn = KoneksiPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}