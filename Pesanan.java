// Ahmad Hilalul Fadli (245150201111045)
// Rajif Aidil Putra (245150207111072)
// Aisha Maryam (245150201111040)
// Shafa Rizwana Zarin (245150207111071)

package com.Pemlan.Kelas.GoFood;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Pesanan {
    int i = 0;
    int j = 0;
    private String noPesanan;
    String[] angka = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    String[] huruf = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private Makanan[] pesananMakanan = new Makanan[10];
    private int[] jumlahMakanan = new int[10];
    private Minuman[] pesananMinuman = new Minuman[10];
    private int[] jumlahMinuman = new int[10];
    private Restaurant[] restaurant = new Restaurant[10];
    private double hargaPesanan;
    private double ongkir;
    private double hargaTotal;
    
    public void pesanMakanan(Restaurant namaResto, Makanan makanan, int jumlah) {
        if (i == 10) {
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|           MAAF KERANJANG BELANJA ANDA SUDAH PENUH           |");
            System.out.println("|             SILAHKAN CHECKOUT TERLEBIH DAHULU!!             |");
            System.out.println("+-------------------------------------------------------------+");
        } else {
            pesananMakanan[i] = makanan;
            jumlahMakanan[i] = jumlah;
            restaurant[i] = namaResto;
            hargaPesanan += (makanan.getHarga()*jumlah);
            for (int i = 0; i < restaurant.length; i++) {
                if (restaurant[i] == null) {
                    continue;
                } else {
                    for (int j = 0; j < restaurant.length; j++) {
                        if (restaurant[j] == null) {
                            continue;
                        } else {
                            if (i == j) {
                                continue;
                            } else if (restaurant[i].getNama().equalsIgnoreCase(restaurant[j].getNama())) {
                                restaurant[j].setJarak(0);
                            }
                        }
                    }
                }
            }
            ongkir += restaurant[i].getJarak()*1000;
        
            i++;
        }
    }

    public void pesanMinuman(Restaurant namaResto, Minuman minuman, int jumlah) {
        if (j == 10) {
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|           MAAF KERANJANG BELANJA ANDA SUDAH PENUH           |");
            System.out.println("|             SILAHKAN CHECKOUT TERLEBIH DAHULU!!             |");
            System.out.println("+-------------------------------------------------------------+");
        } else {
            pesananMinuman[j] = minuman;
            jumlahMinuman[j] = jumlah;
            restaurant[i] = namaResto;
            hargaPesanan += (minuman.getHarga()*jumlah);
            for (int i = 0; i < restaurant.length; i++) {
                if (restaurant[i] == null) {
                    continue;
                } else {
                    for (int j = 0; j < restaurant.length; j++) {
                        if (restaurant[j] == null) {
                            continue;
                        } else {
                            if (i == j) {
                                continue;
                            } else if (restaurant[i].getNama().equalsIgnoreCase(restaurant[j].getNama())) {
                                restaurant[j].setJarak(0);
                            }
                        }
                    }
                }
            }
            ongkir += restaurant[i].getJarak()*1000;
    
            j++;
        }
    }
    
    public String getNoPesanan() {
        return "GF-"+angka[(int) (Math.random()*angka.length)]+angka[(int) (Math.random()*angka.length)]+angka[(int) (Math.random()*angka.length)]+huruf[(int) (Math.random()*huruf.length)]+huruf[(int) (Math.random()*huruf.length)]+huruf[(int) (Math.random()*huruf.length)]+huruf[(int) (Math.random()*huruf.length)]+angka[(int) (Math.random()*angka.length)];
    }

    public void setHargaPesanan(double hargaPesanan) {
        this.hargaPesanan = hargaPesanan;
    }
    
    public double getHargaPesanan() {
        return hargaPesanan;
    }

    public void setOngkir(double ongkir) {
        this.ongkir = ongkir;
    }

    public double getOngkir() {
        return ongkir;
    }

    public double getHargaTotal() {
        return hargaTotal;
    }

    public void getKeranjang() {
        int index = 1;
        // kalo belum pesen
        if (pesananMakanan[0] == null && pesananMinuman[0] == null) {
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                KERANJANG ANDA MASIH KOSONG                  |");
            System.out.println("|              SILAHKAN PESAN TERLEBIH DAHULU!!               |");
            System.out.println("+-------------------------------------------------------------+");
        } else {
            System.out.println("======================= Keranjang Belanja =====================");
            System.out.println("+-------------------------------------------------------------+");
            System.out.printf("| %-3s | %-44s | %-6s |\n", "No.", "Nama Pesanan", "Jumlah");
            System.out.println("+-------------------------------------------------------------+");
            for (int i = 0; i < 10; i++) {
                if (pesananMakanan[i] == null) {
                    continue;
                } else {
                    System.out.printf("|  %-2d | %-44s | %-6s |\n", index, pesananMakanan[i].getNama(), jumlahMakanan[i]);
                    index++;
                }

                if (pesananMinuman[i] == null) {
                    continue;
                } else {
                    System.out.printf("|  %-2d | %-44s | %-6s |\n", index, pesananMinuman[i].getNama(), jumlahMinuman[i]);
                    index++;
                }
            }
            System.out.println("+-------------------------------------------------------------+");
        }
    }
    
    public void getNota(User user, String metode, String status, Diskon diskon, Driver kurir) {
        LocalDate tanggal = LocalDate.now();
        LocalTime waktu = LocalTime.now();
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        DateTimeFormatter formatWaktu = DateTimeFormatter.ofPattern("HH:mm:ss");
        hargaTotal = hargaPesanan + ongkir;
        System.out.println("+=============================================================+");
        System.out.println("|                _________  ________  ____  ___               |\n" +
        "|               / ___/ __ \\/ __/ __ \\/ __ \\/ _ \\              |\n" +
        "|              / (_ / /_/ / _// /_/ / /_/ / // /              |\n" +
        "|              \\___/\\____/_/  \\____/\\____/____/               |\n" +
        "|                                                             |");
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                       RINCIAN PESANAN                       |");
        System.out.println("+-------------------------------------------------------------+");
        for (int i = 0; i < 10; i++) {
            if (pesananMakanan[i] == null) {
                continue;
            } else {
                System.out.printf("| %-40s %18s |\n", pesananMakanan[i].getNama(), "Rp."+pesananMakanan[i].getHarga());
                System.out.printf("| x%-39d %18s |\n", jumlahMakanan[i], "Rp."+(pesananMakanan[i].getHarga()*jumlahMakanan[i]));
            }
            
            if (pesananMinuman[i] == null) {
                continue;
            } else {
                System.out.printf("| %-40s %18s |\n", pesananMinuman[i].getNama(), "Rp."+pesananMinuman[i].getHarga());
                System.out.printf("| x%-39d %18s |\n", jumlahMinuman[i], "Rp."+(pesananMinuman[i].getHarga()*jumlahMinuman[i]));
            }
        }
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                      RINCIAN TRANSAKSI                      |");
        System.out.println("+-------------------------------------------------------------+");
        System.out.printf("| Nama pelanggan\t: %35s |\n", user.getNama());
        System.out.printf("| Metode pembayaran\t: %35s |\n", metode);
        System.out.printf("| Status\t\t: %35s |\n", status);
        System.out.printf("| Waktu\t\t\t: %35s |\n", waktu.format(formatWaktu));
        System.out.printf("| Tanggal\t\t: %35s |\n", tanggal.format(formatTanggal));
        System.out.printf("| No. Pesanan\t\t: %35s |\n", getNoPesanan());
        System.out.printf("| Jumlah\t\t: %35s |\n", "Rp."+hargaPesanan);
        System.out.printf("| Ongkir\t\t: %35s |\n", "Rp."+ongkir);
        System.out.printf("| Diskon\t\t: %35s |\n", "Rp."+diskon.getDiskon());
        System.out.printf("| Total\t\t\t: %35s |\n", "Rp."+hargaTotal);
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                        RINCIAN KURIR                        |");
        kurir.getDetil();
        System.out.println("|                                                             |");
        System.out.println("|                       TERIMA KASIH!!                        |");
        System.out.println("|                    SIMPAN BUKTI BAYAR!!                     |");
        System.out.println("|                                                             |");
        System.out.println("+=============================================================+");
    }
}