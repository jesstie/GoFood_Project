// Ahmad Hilalul Fadli (245150201111045)
// Rajif Aidil Putra (245150207111072)
// Aisha Maryam (245150201111040)
// Shafa Rizwana Zarin (245150207111071)

package com.Pemlan.Kelas.GoFood;

public class Driver implements GetDetil{
    
    private String nama;
    private String nomorHP;
    private String platNomor;
    private String jenisKendaraan;
    private double rating;

    public Driver(String nama, String nomorHP, String platNomor, String jenisKendaraan, double rating) {
        this.nama = nama;
        this.nomorHP = nomorHP;
        this.platNomor = platNomor;
        this.jenisKendaraan = jenisKendaraan;
        this.rating = rating;
    }

    public String getNama() {
        return this.nama;
    }

    public String getNomorHP() {
        return this.nomorHP;
    }

    public String getPlatNomor() {
        return this.platNomor;
    }

    public String getJenisKendaraan() {
        return this.jenisKendaraan;
    }

    public double getRating() {
        return this.rating;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNomorHP(String nomorHP) {
        this.nomorHP = nomorHP;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) { 
            this.rating = rating;
        } else {
            System.out.println("Rating harus antara 0 dan 5!");
        }
    }

    @Override
    public void getDetil() {
        System.out.println("+-------------------------------------------------------------+");
        System.out.printf("| Nama\t\t\t: %35s |\n", nama);
        System.out.printf("| Nomor HP\t\t: %35s |\n", nomorHP);
        System.out.printf("| Plat Nomor\t\t: %35s |\n", platNomor);
        System.out.printf("| Jenis Kendaraan\t: %35s |\n", jenisKendaraan);
        System.out.printf("| Rating\t\t: %35s |\n", rating+"/5.0");
        System.out.println("+-------------------------------------------------------------+");
    }
}