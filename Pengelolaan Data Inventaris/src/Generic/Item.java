/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generic;

/**
 *
 * @author ASUS
 */
public class Item {

    private String kodeBarang;
    private String namaBarang;
    private String kategoriBarang;
    private String merek;
    private int jumlah;

    public Item(String kodeBarang, String namaBarang, String kategoriBarang, String merek, int jumlah) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.kategoriBarang = kategoriBarang;
        this.merek = merek;
        this.jumlah = jumlah;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getKategoriBarang() {
        return kategoriBarang;
    }

    public String getMerek() {
        return merek;
    }

    public int getJumlah() {
        return jumlah;
    }
}

