# Minpro-3-PBO-KonservasiOrangutanKalimantan

    Dibuat oleh: Riaz Ramadhan Al Fattah
    NIM: 2509116106

<p align="center">
<img width="900" height="200" alt="image" src="https://github.com/user-attachments/assets/8dc0e694-bbe1-461f-ac26-e6d4f6f822b0" />
</p>

## Daftar Isi
### - [1 Deskripsi Program](#deskripsi-program) 
### - [2 Penjelasan Alur Program](#penjelasan-alur-program)
### - [3 Struktur Package (Model-View-Controller)](#struktur-package-mvc)
### - [4 Penerapan Encapsulation](#penerapan-encapsulation)
### - [5 Penerapan Inheritance](#penerapan-inheritance)
### - [6 Penerapan Polymorphism](#penerapan-polymorphism)
### - [7 Penerapan Validasi Input](#penerapan-validasi-input)
### - [8 Penerapan Abstraction](#penerapan-abstraction)
### - [9 Penerapan Access Modifer](penerapan-access-modifier)
### - [10 Penerapan Interface](penerapan-interface)
### - [11 Output Program](#output-program)

## 1. Deskripsi Program
**Sistem Konservasi & Rehabilitasi Orangutan Kalimantan** adalah aplikasi berbasis **Java CLI** lanjutan yang dikembangkan dari **Mini Project 1**. Program ini digunakan untuk mendata, memantau, dan mengelola tahapan rehabilitasi orangutan di berbagai Taman Nasional di Pulau Kalimantan. Program menerapkan **CRUD penuh** dengan pendekatan **Object-Oriented Programming (OOP)** serta **arsitektur MVC (Model–View–Controller)**.

Pada Mini Project 2 ini ditambahkan:
- **Inheritance**: `Orangutan` (superclass) dengan 2 subclass `OrangutanJantan` dan `OrangutanBetina`.
- **Polymorphism**: method `getJenisKelamin()`, `getKategori()`, dan `getInfoTambahan()` di-*override* oleh subclass, serta *casting* runtime (`instanceof`) pada saat update.
- **Struktur MVC**: pemisahan `model`, `view`, `controller`, `main`.
- **Dummy data awal**: 2 data orangutan langsung tampil saat fitur Read pertama kali dibuka.

## 2. Penjelasan Alur Program
1. **Start** -> `Main` membuat `KonservasiView` dan `KonservasiController`. Controller otomatis mengisi **2 dummy data** ke ArrayList.
2. **Menu Utama (loop `do-while`)** → Menampilkan 5 pilihan. Program berhenti hanya jika user memilih **5. Keluar**.
3. **Create** -> User memasukkan nama, umur, jenis kelamin. Jika **Jantan**, diminta `cheek pads`; jika **Betina**, diminta `jumlah anak`. Objek dibuat sebagai `OrangutanJantan` / `OrangutanBetina` (polymorphic). Data disimpan dengan ID `C1`, `C2`, dst.
4. **Read** -> Menampilkan seluruh data dalam tabel (perulangan `for-each`). Kolom **Kategori**, **Gender**, dan **Info Tambahan** diambil dari method yang di-*override* (polymorphism).
5. **Update** -> User memilih ID, lalu masuk submenu update yang dapat mengubah:
   - Nama, Umur
   - Info khusus (Cheek Pads / Jumlah Anak) — menggunakan `instanceof` + casting
   - Lokasi, Status
6. **Delete** -> Menghapus data berdasarkan ID.
7. **Keluar** -> Program berhenti.

## 3. Struktur Package (MVC)

      KonservasiOrangutanKalimantan/
      ├── src/
      |   └── controller/                    ← C (Controller)
      |   │   └── KonservasiController.java
      │   ├── main/
      │   │   └── Main.java                  ← Entry point (menu loop)
      │   ├── model/                         ← M (Model)
      │   │   ├── Orangutan.java             ← Superclass
      │   │   ├── OrangutanJantan.java       ← Subclass 1
      │   │   ├── OrangutanBetina.java       ← Subclass 2
      │   │   ├── LokasiHabitat.java
      │   │   └── CatatanRehabilitasi.java
      │   ├── view/                          ← V (View)
      │   │   └── KonservasiView.java
      └── README.md

        
      src/
      ├── controller/ → Logika bisnis & manajemen ArrayList (KonservasiController)
      ├── main/ → Entry point program
      ├── model/ → Entity: Orangutan (superclass), OrangutanJantan, OrangutanBetina, LokasiHabitat, CatatanRehabilitasi
      ├── view/ → Tampilan & input user (KonservasiView)
      └── controller/ → Logika bisnis & manajemen ArrayList (KonservasiController)

<img width="601" height="407" alt="image" src="https://github.com/user-attachments/assets/a7ff6068-b7b7-43fd-993c-93af495614fb" />


## 4. Penerapan Encapsulation
Semua atribut pada class `Orangutan`, `OrangutanJantan`, `OrangutanBetina`, `LokasiHabitat`, dan `CatatanRehabilitasi` dideklarasikan `private`. Akses hanya melalui **getter** dan **setter** publik, sehingga data tidak dapat diubah sembarangan dari luar class.

Contoh:
```java
private String nama;
public String getNama() { return nama; }
public void setNama(String nama) { this.nama = nama; }
```
## 5. Penerapan Inheritance
**Inheritance adalah mekanisme di mana sebuah kelas (Subclass) mewarisi atribut (property) dan perilaku (method) dari kelas lain (Superclass).**

- Superclass: Orangutan — atribut umum: idOrangutan, nama, umurTahun.

- Subclass 1: OrangutanJantan extends Orangutan — tambahan ukuranCheekPads.

- Subclass 2: OrangutanBetina extends Orangutan — tambahan jumlahAnak.

Keyword super(...) dipakai di constructor subclass untuk memanggil constructor superclass.

## 6. Penerapan Polymorphism

```java
@Override
public String getJenisKelamin() { return "Jantan"; }

@Override
public String getInfoTambahan() {
    return String.format("Cheek Pads: %.1f cm", ukuranCheekPads);
}
```
Method yang sama (getJenisKelamin, getKategori, getInfoTambahan) dipanggil pada CatatanRehabilitasi tanpa tahu tipe konkretnya, inilah polymorphism runtime.
Casting runtime pada fitur update:

```java
if (target.getOrangutan() instanceof OrangutanJantan) {
    OrangutanJantan oj = (OrangutanJantan) target.getOrangutan();
    oj.setUkuranCheekPads(...);
}
```

---
## 7. Penerapan Validasi Input
Seluruh input user melewati validasi di KonservasiView.java sebelum diproses oleh Controller, sehingga program tidak pernah crash karena input salah:
- inputInteger() — menggunakan try-catch (NumberFormatException) di dalam perulangan while(true), sehingga input non-angka (misal "abc") akan diminta ulang sampai valid.
- inputDouble() — pola yang sama untuk angka desimal (misal input ukuran cheek pads "x.y").
- inputString() — memastikan teks tidak kosong (.trim() + pengecekan isEmpty()).
- Validasi rentang pilihan menu — pilihan jenis kelamin [1/2], wilayah [1-4], dan status [1-4] dibungkus perulangan do-while, sehingga input angka di luar rentang (misal 9) tidak akan "jatuh" ke pilihan default, melainkan diminta ulang.

```java
// Contoh: inputInteger() di KonservasiView
public int inputInteger(String pesan) {
    while (true) {
        System.out.print(pesan);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            tampilkanError("Masukkan angka yang valid!");
        }
    }
}
```
```java
// Contoh: validasi rentang di KonservasiController (pilihStatus)
int opsi;
do {
    opsi = view.inputInteger("Pilih Status [1-4]: ");
    if (opsi < 1 || opsi > 4) {
        view.tampilkanError("Pilihan tidak valid! Masukkan angka 1-4.");
    }
} while (opsi < 1 || opsi > 4);
```
Validasi dilakukan berlapis: tipe data (teks/angka) ditangani View, rentang nilai ditangani Controller dengan do-while.

---

## 8. Penerapan Abstraction
Abstraction diterapkan dengan dua cara:

1. Menyembunyikan detail implementasi di balik getter publik. Class Orangutan hanya mengekspos perilaku (method) seperti getKategori(), getJenisKelamin(), dan getInfoTambahan() — pemanggil tidak perlu tahu bagaimana nilai tersebut dihitung. Method yang sama menghasilkan keluaran berbeda tergantung subclass (Jantan/Betina), dan CatatanRehabilitasi cukup memanggil getInfoTambahan() tanpa peduli detail di dalamnya:

```java
// Controller cukup memanggil method — detail "apa yang di-return" disembunyikan
w.infoTambahan = c.getOrangutan().getInfoTambahan();
```
2. Pemisahan tanggung jawab berdasarkan abstraksi peran (MVC). Program diabstraksi menjadi 3 peran:
- KonservasiView → abstraksi dari "cara user berkomunikasi" (tampilan & input)
- KonservasiController → abstraksi dari "aturan bisnis" (CRUD, ArrayList)
- model → abstraksi dari "data dunia nyata" (Orangutan, Lokasi, Catatan)
Sebagai contoh, KonservasiView tidak tahu sama sekali bagaimana data disimpan atau dihapus — ia hanya menerima CatatanRehabilitasiWrapper (inner class) untuk menampilkan tabel. Ini menyembunyikan kompleksitas model dari View.

---

## 9. Access Modifier
Program menggunakan 3 dari 4 access modifier Java secara konsisten:

| Access Modifier | Penerapan di Program |
| --- | --- |
| `private` | Semua atribut di setiap class model (`idOrangutan`, `nama`, `umurTahun`, `ukuranCheekPads`, `jumlahAnak`, dll.) serta atribut `daftarKonservasi`, `view`, dan `counter` di Controller. Atribut tidak bisa diakses langsung dari luar class. |
| `public` | Constructor semua class, semua getter/setter, dan seluruh method lintas package (`tambahData()`, `tampilkanData()`, `main()`, dll.) agar dapat dipanggil dari package lain (`main` -> `controller` -> `view`). |
| `default` (package-private) | Class `CatatanRehabilitasiWrapper` di dalam `KonservasiView` tidak diberi modifier, sehingga hanya relevan dalam konteks package `view`. |

```java
// private: hanya bisa diakses lewat getter/setter
private ArrayList<CatatanRehabilitasi> daftarKonservasi;
private double ukuranCheekPads;

// public: method yang dipanggil lintas package
public void tampilkanData() { ... }
```
Kombinasi private + getter/setter inilah yang membuat Encapsulation (bagian 4) berfungsi penuh: tidak ada cara mengubah data orangutan dari luar tanpa melalui method yang sudah disediakan.

---

## 10. Penerapan Interface
nterface adalah "kontrak" berisi method-method kosong (tanpa body) yang harus diimplementasikan oleh class manapun yang menggunakannya. Berbeda dengan inheritance (yang dibatasi satu superclass), satu class bisa mengimplementasikan banyak interface sekaligus.

Dalam program ini, interface diterapkan dengan mendefinisikan kontrak operasi CRUD dan kontrak tampilan data, sehingga Controller diwajibkan menyediakan seluruh operasi tersebut:

```java
// file: interface/KonservasiInterface.java
public interface KonservasiInterface {
    // Kontrak operasi CRUD — semua method tanpa body
    void tambahData();          // Create
    void tampilkanData();       // Read
    void updateData();          // Update
    void hapusData();           // Delete
}
```

Kemudian KonservasiController mengimplementasikan kontrak tersebut dengan keyword implements:

```java
// file: controller/KonservasiController.java
public class KonservasiController implements KonservasiInterface {

    @Override
    public void tambahData() {
        // logika Create (sama seperti sebelumnya)
    }

    @Override
    public void tampilkanData() {
        // logika Read
    }

    @Override
    public void updateData() {
        // logika Update (instanceof + casting)
    }

    @Override
    public void hapusData() {
        // logika Delete
    }
}
```
Dengan struktur ini, Main bisa memperlakukan Controller polymorphically melalui interface:

```java
// Main.java — Controller di-upcast ke tipe interface-nya
KonservasiInterface controller = new KonservasiController(view);
controller.tampilkanData();   // method dipanggil lewat "kontrak", bukan class konkret
```

Manfaat interface dalam program ini:
- Kontrak yang dijamin — Compiler memaksa KonservasiController menyediakan keempat method CRUD. Kalau ada satu method yang lupa dibuat, program gagal compile, bukan gagal saat dijalankan.
- Ketergantungan yang rendah (loose coupling) — Main cukup mengenal KonservasiInterface, tidak perlu tahu detail KonservasiController. Jika nanti logika CRUD dipindah ke database, kode di Main tidak perlu diubah.
- Kerangka untuk pengembangan lanjut — Interface bisa dipakai juga untuk model, misalnya interface InfoTampil { String getKategori(); String getInfoTambahan(); } yang diimplementasikan OrangutanJantan dan OrangutanBetina, memperkuat polymorphism di bagian 6.

---

## 11. Output Program

**1. Menu Utama**
Tampilan awal saat program dijalankan. Terlihat 5 pilihan menu dan dummy data sudah tersedia di memori.

<img width="462" height="205" alt="image" src="https://github.com/user-attachments/assets/e9f513d5-ff18-402b-8e96-6c9d03cf62d8" />

----
**2. Fitur Read** – Menampilkan Dummy Data Awal
Saat memilih menu 2, tabel langsung menampilkan 2 data dummy (Boni – Jantan, Sisi – Betina) tanpa perlu input manual. Kolom Kategori, Gender, dan Info Tambahan diambil dari method yang di-override (polymorphism).

<img width="1207" height="180" alt="image" src="https://github.com/user-attachments/assets/7ea2a8bd-7c9b-49bb-a968-e5e862b16069" />

----
**3. Fitur Create Jantan** – Registrasi Orangutan Jantan

Contoh pengisian data untuk orangutan Jantan. User diminta mengisi nama, umur, jenis kelamin (pilih 1), lalu Ukuran Cheek Pads. Setelah selesai, data tersimpan dengan ID C3 (atau sesuai counter).

<img width="500" height="512" alt="image" src="https://github.com/user-attachments/assets/fb94a413-f9c8-4ab8-bb50-9c1f33fe6bfb" />

----
**4. Fitur Create Betina** – Registrasi Orangutan Betina

Contoh pengisian data untuk orangutan Betina. User diminta mengisi nama, umur, jenis kelamin (pilih 2), lalu Jumlah Anak.

<img width="492" height="462" alt="image" src="https://github.com/user-attachments/assets/00fea83c-db6b-4db3-9fec-f896fe8c2c7c" />

----
**5. Fitur Read** – Setelah Penambahan Data
Menampilkan kembali seluruh data (dummy + data baru). Perhatikan kolom Kategori dan Info Tambahan yang berbeda antara Jantan dan Betina (hasil polymorphism).

<img width="1222" height="225" alt="image" src="https://github.com/user-attachments/assets/8780b949-3927-4140-9e98-f9b4d40e6ddb" />

----
**6. Fitur Update** – Memilih ID dan Menampilkan Submenu
Contoh saat memilih menu 3. User memasukkan ID catatan (misal C2), lalu muncul submenu update yang bisa mengubah seluruh entitas.

<img width="1208" height="426" alt="image" src="https://github.com/user-attachments/assets/d4df9b71-c657-4b8b-b739-edb4bea018ec" />

----
**7. Fitur Update** – Mengubah Info Khusus (Cheek Pads / Jumlah Anak)
Contoh ketika memilih opsi 3 pada submenu update. Program mendeteksi tipe runtime (instanceof) dan meminta input yang sesuai (cheek pads untuk Jantan, jumlah anak untuk Betina).

<img width="507" height="471" alt="image" src="https://github.com/user-attachments/assets/9fe57687-065c-42c9-913a-3d9a0aba6ba9" />

----
8. Fitur Update – Mengubah Status Kesehatan
Contoh ketika memilih opsi 5 pada submenu update. User memilih status baru dari 4 pilihan yang tersedia.

<img width="407" height="327" alt="image" src="https://github.com/user-attachments/assets/be0a300b-c928-4b8a-941b-67ff702adb56" />


9. Fitur Delete – Menghapus Data
Contoh saat memilih menu 4. User memasukkan ID yang ingin dihapus (misal C2), lalu program menghapus data dari ArrayList dan menampilkan pesan sukses.

<img width="1215" height="228" alt="image" src="https://github.com/user-attachments/assets/97aece09-9bb5-4c25-ab69-9d581911d48a" />

<img width="1212" height="160" alt="image" src="https://github.com/user-attachments/assets/43667267-643b-4d52-8594-807a35b16258" />
After
10. Keluar Program
Tampilan saat user memilih menu 5. Program menampilkan pesan penutup dan berhenti.

<img width="587" height="347" alt="image" src="https://github.com/user-attachments/assets/a44deaba-fbce-4d9f-b457-e29987801058" />
