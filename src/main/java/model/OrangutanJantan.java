/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Subclass OrangutanJantan.
 * Mewarisi Orangutan + atribut khusus jantan (ukuran cheek pads).
 *
 * @author riaza
 */
public class OrangutanJantan extends Orangutan {
    private double ukuranCheekPads;

    // OVERLOADING Constructor 1: lengkap
    public OrangutanJantan(String idOrangutan, String nama, int umurTahun, double ukuranCheekPads) {
        super(idOrangutan, nama, umurTahun);
        this.ukuranCheekPads = ukuranCheekPads;
    }

    // OVERLOADING Constructor 2: default cheek pads 0.0 (orangutan muda)
    public OrangutanJantan(String idOrangutan, String nama, int umurTahun) {
        this(idOrangutan, nama, umurTahun, 0.0);
    }

    public double getUkuranCheekPads() { return ukuranCheekPads; }
    public void setUkuranCheekPads(double ukuranCheekPads) { this.ukuranCheekPads = ukuranCheekPads; }

    // Polymorphism: Method Overriding
    @Override
    public String getJenisKelamin() { return "Jantan"; }

    @Override
    public String getKategori() { return "Orangutan Jantan"; }

    @Override
    public String getInfoTambahan() {
        return String.format("Cheek Pads: %.1f cm", ukuranCheekPads);
    }

    // OVERLOADING Method: bandingkan dominasi antar jantan
    public String bandingkan(OrangutanJantan lain) {
        if (this.ukuranCheekPads > lain.ukuranCheekPads) {
            return this.getNama() + " lebih dominan.";
        } else if (this.ukuranCheekPads < lain.ukuranCheekPads) {
            return lain.getNama() + " lebih dominan.";
        }
        return "Keduanya setara.";
    }

    public String bandingkan(double cheekPadsLain) { // beda parameter → overloading
        return this.ukuranCheekPads > cheekPadsLain
                ? this.getNama() + " lebih dominan."
                : this.getNama() + " kalah dominan.";
    }
}