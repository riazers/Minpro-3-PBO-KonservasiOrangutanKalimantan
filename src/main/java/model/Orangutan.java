/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package model;

/**
 * Superclass Orangutan.
 * Menyimpan atribut umum yang dimiliki semua orangutan.
 * Menerapkan encapsulation (private + getter/setter).
 * ABSTRACTION: Orangutan adalah ABSTRACT CLASS.
 * Tidak bisa diinstansiasi langsung — hanya bisa lewat subclass
 * (OrangutanJantan / OrangutanBetina).
 * 
 * @author riaza
 */

public abstract class Orangutan implements InfoKonservasi {
    // Encapsulation
    private String idOrangutan;
    private String nama;
    private int umurTahun;

    public Orangutan(String idOrangutan, String nama, int umurTahun) {
        this.idOrangutan = idOrangutan;
        this.nama = nama;
        this.umurTahun = umurTahun;
    }

    // Getter & Setter
    public String getIdOrangutan() { return idOrangutan; }
    public void setIdOrangutan(String idOrangutan) { this.idOrangutan = idOrangutan; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getUmurTahun() { return umurTahun; }
    public void setUmurTahun(int umurTahun) { this.umurTahun = umurTahun; }

    // ABSTRACT METHODS — wajib di-override oleh subclass
    public abstract String getJenisKelamin();
    public abstract String getKategori();
    public abstract String getInfoTambahan();

    // Implementasi method dari interface (Polymorphism)
    @Override
    public String getRingkasan() {
        return String.format("%s bernama %s (%d thn) - %s", getKategori(), nama, umurTahun, getInfoTambahan());
    }
}