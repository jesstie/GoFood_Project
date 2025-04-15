// Ahmad Hilalul Fadli (245150201111045)
// Rajif Aidil Putra (245150207111072)
// Aisha Maryam (245150201111040)
// Shafa Rizwana Zarin (245150207111071)

package com.Pemlan.Kelas.GoFood;

public class Makanan implements GetDetil {
    private String nama;
    private String jenisMakanan;
    private double rating;
    private double harga;

    public Makanan(String nama, String jenisMakanan, double rating, double harga) {
        this.nama = nama;
        this.jenisMakanan = jenisMakanan;
        this.rating = rating;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getJenisMakanan() {
        return jenisMakanan;
    }
    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public double getHarga() {
        return harga;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public void getDetil() {
        int panjangSpasi = (int) ((61 - nama.length())/2);
        System.out.println("+-------------------------------------------------------------+");
        // menampilkan nama makanan agar tepat di tengah
        System.out.print("|");
        for (int i = 0; i < panjangSpasi; i++) {
            System.out.print(" \033[34m");
        }
        System.out.print(nama);
        for (int i = 0; i < panjangSpasi; i++) {
            System.out.print("\033[0m ");
        }
        if (nama.length() % 2 == 0) {
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
        System.out.println("+-------------------------------------------------------------+");
        System.out.printf("| Nama\t\t: %-43s |\n", nama);
        System.out.printf("| Jenis Makanan\t: %-43s |\n", jenisMakanan);
        System.out.printf("| Rating\t: %-3.1f/5.0%36s |\n", rating, " ");
        System.out.printf("| Harga\t\t: Rp.%-40.2f |\n", harga);
        System.out.println("+-------------------------------------------------------------+");
        System.out.println();
    }
}