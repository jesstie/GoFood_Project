// Ahmad Hilalul Fadli (245150201111045)
// Rajif Aidil Putra (245150207111072)
// Aisha Maryam (245150201111040)
// Shafa Rizwana Zarin (245150207111071)

package com.Pemlan.Kelas.GoFood;

public abstract class Diskon {
    private double diskon;

    public Diskon(double diskon) {
        this.diskon = diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getDiskon() {
        return diskon;
    }

    //diskon makanan potong harga makanan
    //diskon ongir potong ongkir
    public abstract void potongHarga(Pesanan pesanan);
}