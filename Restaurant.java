// Ahmad Hilalul Fadli (245150201111045)
// Rajif Aidil Putra (245150207111072)
// Aisha Maryam (245150201111040)
// Shafa Rizwana Zarin (245150207111071)

package com.Pemlan.Kelas.GoFood;

public class Restaurant implements GetDetil {
    private String nama;
    private String lokasi;
    private double jarak;
    private String jenisKuliner;
    private double rating;
    private double hargaRataRata;
    public Makanan[] makanan;
    public Minuman[] minuman;

    public Restaurant(String nama, String lokasi, double jarak, String jenisKuliner, double rating, double hargaRataRata) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.jarak = jarak;
        this.jenisKuliner = jenisKuliner;
        this.rating = rating;
        this.hargaRataRata = hargaRataRata;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getJenisKuliner() {
        return jenisKuliner;
    }

    public void setjenisKuliner(String jenisKuliner) {
        this.jenisKuliner = jenisKuliner;
    }

    public double getRating() {
        return rating;
    }

    public double getJarak() {
        return jarak;
    }

    public void setJarak(double jarak) {
        this.jarak = jarak;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getHargaRataRata() {
        return hargaRataRata;
    }

    public void setHargaRata(double hargaRataRata) {
        this.hargaRataRata = hargaRataRata;
    }

    @Override
    public void getDetil() {
        int panjangSpasi = (int) ((61 - nama.length())/2);
        System.out.println("+-------------------------------------------------------------+");
        // menampilkan nama restaurant agar tepat di tengah
        System.out.print("|");
        for (int i = 0; i < panjangSpasi; i++) {
            System.out.print(" \033[31m");
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
        System.out.printf("| Nama\t\t : %-42s |\n", nama);
        System.out.printf("| Lokasi\t : %-42s |\n", lokasi);
        System.out.printf("| Jarak\t\t : %-42s |\n", jarak+" Km");
        System.out.printf("| Jenis Kuliner\t : %-42s |\n", jenisKuliner);
        System.out.printf("| Rating\t : %-3.1f/5.0%35s |\n", rating, " ");
        System.out.printf("| Harga Rata-rata: Rp.%-39.2f |\n", hargaRataRata);
        System.out.println("+-------------------------------------------------------------+");
        System.out.println();
    }
}
