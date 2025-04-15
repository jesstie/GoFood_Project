// Ahmad Hilalul Fadli (245150201111045)
// Rajif Aidil Putra (245150207111072)
// Aisha Maryam (245150201111040)
// Shafa Rizwana Zarin (245150207111071)

package com.Pemlan.Kelas.GoFood;

public class User implements GetDetil {
    private String nama;
    private String email;
    private String alamatRumah;
    private String nomorHP;
    private double saldo;
    private int PIN;

    public User(String nama, String email, String alamatRumah, String nomorHP, double saldo, int PIN){
        this.nama = nama;
        this.email = email;
        this.alamatRumah = alamatRumah;
        this.nomorHP = nomorHP;
        this.saldo = saldo;
        this.PIN = PIN;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAlamatRumah(String alamat){
        this.alamatRumah = alamat;
    }

    public void setNomorHP(String nomorHP){
        this.nomorHP = nomorHP;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void setPIN(int PIN){
        this.PIN = PIN;
    }

    public String getNama(){
        return nama;
    }

    public String getEmail(){
        return email;
    }

    public String getAlamatRumah(){
        return alamatRumah;
    }

    public String getNomorHP(){
        return nomorHP;
    }

    public double getSaldo(){
        return saldo;
    }
    
    public int getPIN() {
        return PIN;
    }

    @Override
    public void getDetil() {
        int panjangSpasi = (int) ((61 - nama.length())/2);
        System.out.println("+-------------------------------------------------------------+");
        // menampilkan nama makanan agar tepat di tengah
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
        System.out.printf("| Nama\t\t: %-43s |\n", nama);
        System.out.printf("| Email\t\t: %-43s |\n", email);
        System.out.printf("| Alamat\t: %-43s |\n", alamatRumah);
        System.out.printf("| Nomor HP\t: %-43s |\n", nomorHP);
        System.out.printf("| Saldo\t\t: Rp.%-40.2f |\n", saldo);
        System.out.println("+-------------------------------------------------------------+");
        System.out.println();
    }

    // nanti ubah pin nya mungkin bisa pake ini, kalau salah ganti aja lal
    public void ubahPIN(int pinLama, int pinBaru) {
        if (this.PIN == pinLama) {
            this.PIN = pinBaru;
        }
    }

    // ini juga buat ubah emailnya bisa pake ini, aku buat biar ada verifikasi pake pin dulu sblm rubah email
    public boolean ubahEmail(String emailBaru, int pin) {
        if (this.PIN == pin) {
            this.email = emailBaru;
            return true;
        }
        return false;
    }
}