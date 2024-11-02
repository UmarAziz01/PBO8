package pbo_upload;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDKu {

    Connection cn;
    PreparedStatement ps;
    Statement st;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/PBO_UTS";
    String user = "postgres";
    String password = " "; // Ganti dengan password PostgreSQL Anda

    public CRUDKu() {
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(koneksi, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CRUDKu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean tambah(String KodeMK, int SKS, String NamaMK, int SemesterAjar) { 
        String sql = "INSERT INTO mata_kuliah (KodeMK, SKS, NamaMK, SemesterAjar) VALUES (?, ?, ?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, KodeMK);
            ps.setInt(2, SKS);
            ps.setString(3, NamaMK);
            ps.setInt(4, SemesterAjar);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDKu.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<MataKuliah> tampil() {
        List<MataKuliah> list = new ArrayList<>();
        String sql = "SELECT * FROM mata_kuliah";
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MataKuliah m = new MataKuliah(
                        rs.getString("KodeMK"),
                        rs.getInt("SKS"),
                        rs.getString("NamaMK"),
                        rs.getInt("SemesterAjar")
                );
                list.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDKu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean hapus(String KodeMK) {
        String sql = "DELETE FROM mata_kuliah WHERE KodeMK = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, KodeMK);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDKu.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(String KodeMK, int SKS, String NamaMK, int SemesterAjar) {
        String sql = "UPDATE mata_kuliah SET SKS = ?, NamaMK = ?, SemesterAjar = ? WHERE KodeMK = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, SKS);
            ps.setString(2, NamaMK);
            ps.setInt(3,SemesterAjar);
            ps.setString(4, KodeMK);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDKu.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void tutupKoneksi() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (st != null) {
                st.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDKu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
