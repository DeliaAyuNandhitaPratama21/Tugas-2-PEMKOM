/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class Inventory {

    public static <T> void tambahData(T data) {
        if (data instanceof Item) {
            Item inv = (Item) data;
            try (Connection K = Koneksi.conn();
                 PreparedStatement pst = K.prepareStatement(
                     "INSERT INTO barang (kode_barang, nama_barang, kategori_barang, merek, jumlah) VALUES (?, ?, ?, ?, ?)")) {
                
                pst.setString(1, inv.getKodeBarang());
                pst.setString(2, inv.getNamaBarang());
                pst.setString(3, inv.getKategoriBarang());
                pst.setString(4, inv.getMerek());
                pst.setInt(5, inv.getJumlah());
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal menambah data: " + e.getMessage());
            }
        }
    }

    public static List<? extends Item> getData() {
        List<Item> list = new ArrayList<>();
        try (Connection K = Koneksi.conn();
             PreparedStatement pst = K.prepareStatement("SELECT * FROM barang");
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                list.add(new Item(
                    rs.getString("kode_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("kategori_barang"),
                    rs.getString("merek"),
                    rs.getInt("jumlah")
                ));
            }
        } catch (SQLException e) {
            
        }
        return list;
    }

    public static <T> void hapusData(T kodeBarang) {
        try (Connection K = Koneksi.conn();
             PreparedStatement stmt = K.prepareStatement("DELETE FROM barang WHERE kode_barang = ?")) {
            
            stmt.setString(1, kodeBarang.toString());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mnghapus: " + e.getMessage());
        }
    }
}
