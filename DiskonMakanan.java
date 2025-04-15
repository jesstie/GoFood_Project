// Ahmad Hilalul Fadli (245150201111045)
// Rajif Aidil Putra (245150207111072)
// Aisha Maryam (245150201111040)
// Shafa Rizwana Zarin (245150207111071)

package com.Pemlan.Kelas.GoFood;

public class DiskonMakanan extends Diskon {

    public DiskonMakanan(double diskon) {
        super(diskon);
    }

    @Override
    public void potongHarga(Pesanan pesanan) {
        pesanan.setHargaPesanan(pesanan.getHargaPesanan() - getDiskon());
    }
}