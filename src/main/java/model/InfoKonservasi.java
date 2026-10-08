/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * INTERFACE: kontrak untuk semua entitas yang bisa menampilkan ringkasan.
 * Menggunakan default method (Java 8+) sebagai bentuk implementasi bawaan.
 * 
 * @author riaza
 */
public interface InfoKonservasi {
    String getRingkasan(); // abstract method (implisit public abstract)

    // Default method di interface sebagai bentuk fleksibilitas tambahan
    default String getRingkasanSingkat() {
        return "[" + getRingkasan() + "]";
    }
}