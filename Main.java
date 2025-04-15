// Ahmad Hilalul Fadli (245150201111045)
// Rajif Aidil Putra (245150207111072)
// Aisha Maryam (245150201111040)
// Shafa Rizwana Zarin (245150207111071)

package com.Pemlan.Kelas.GoFood;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;
        boolean statusPembelian = false;
        User user = new User("John Doe", "johndoe09@gmail.com", "Jl. Veteran No. 07 Malang", "085123454678", 200000, 12345678);
        Pesanan pesanan = new Pesanan();
        Restaurant[] restaurant = inisialisasiRestaurant();
        Driver[] kurir = inisialisasiDriver();
        DiskonMakanan[] diskonMakanan = inisialisaiDiskonMakanan();
        DiskonOngkir[] diskonOngkir = inisialisaiDiskonOngkir();
        
        do {
            pilihan = menuMain(input);
            input.nextLine();
            
            if (pilihan == 1) {
                pilihan = menuAkun(input, user);
                input.nextLine();
                
                if (pilihan == 1) {
                    UbahEmail(input, user);
                    
                } else if (pilihan == 2) {
                    UbahPIN(input, user);

                }
            } else if (pilihan == 2) {
                pilihan = menuPembelian(input, restaurant);
                input.nextLine();
                
                if (pilihan == 1) {
                    statusPembelian = beliMakanan(input, restaurant, pesanan);
                    
                } else if (pilihan == 2) {
                    statusPembelian = beliMinuman(input, restaurant, pesanan);

                }
            } else if (pilihan == 3) {
                System.out.println();
                pesanan.getKeranjang();
            } else if (pilihan == 4) {
                pilihan = menuPembayaran(input, statusPembelian);
                int random = (int) (Math.random()*2)+1;
                // kalo 1 pake diskon makanan kalo 2 pake diskon ongkir
                if (random == 1) {
                    if (pilihan == 1) {
                        bayarCOD(input, user, pesanan, diskonMakanan, kurir);
                    } else if (pilihan == 2) {
                        bayarGopay(input, user, pesanan, diskonMakanan, kurir);
                    }
                } else if (random == 2) {
                    if (pilihan == 1) {
                        bayarCOD(input, user, pesanan, diskonOngkir, kurir);
                    } else if (pilihan == 2) {
                        bayarGopay(input, user, pesanan, diskonOngkir, kurir);
                    }
                }
                pesanan = new Pesanan();
            } else if (pilihan == 5) {
                menuTopUp(input, user);
            } else if (pilihan == 6) {
                System.out.println("+-------------------------------------------------------------+");
                System.out.println("|                       PROGRAM SELESAI!!                     |");
                System.out.println("+-------------------------------------------------------------+");
                System.out.println();
                System.out.println("\r\n" + //
                                        "\033[32m                                  )          \r\n" + //
                                        "           *   )   )               )    ( /(          \r\n" + //
                                        "         ` )  /(( /(    )       ( /(    )\\())     (   \r\n" + //
                                        "          ( )(_))\\())( /(  (    )\\())  ((_)\\ (   ))\\  \r\n" + //
                                        "         (_(_()|(_)\\ )(_)) )\\ )((_)\\  __ ((_))\\ /((_) \r\n" + //
                                        "         |_   _| |(_|(_)_ _(_/(| |(_) \\ \\ / ((_|_))(  \r\n" + //
                                        "           | | | ' \\/ _` | ' \\)) / /   \\ V / _ \\ || | \r\n" + //
                                        "           |_| |_||_\\__,_|_||_||_\\_\\    |_|\\___/\\_,_| \r\n\033[0m" + //
                                        "                                                      \r\n" + //
                                        "");
                System.out.println("Program ini dibuat oleh: \n1. Ahmad Hilalul Fadli (245150201111045)\n2. Rajif Aidil Putra (245150207111072)\n3. Aisha Maryam (245150201111040) \n4. Shafa Rizwana Zarin (245150207111071)");
                System.out.println();
            } else {
                System.out.println("+-------------------------------------------------------------+");
                System.out.println("|                      INPUT TIDAK VALID!!                    |");
                System.out.println("+-------------------------------------------------------------+");
            }

        } while (pilihan != 6);

        input.close();
    }

    public static Restaurant[] inisialisasiRestaurant() {
        Restaurant[] restaurant = new Restaurant[10];
        restaurant[0] = new Restaurant("Umayumcha", "Jl. Kunir No.5, Oro-oro Dowo, Malang", 15, "Restaurant", 4.6, 25000);
        restaurant[0].makanan = new Makanan[9];
        restaurant[0].makanan[0] = new Makanan("Dimsum Original Paket 3 Pcs", "Ringan", 4.9, 15000);
        restaurant[0].makanan[1] = new Makanan("Dimsum Jamur Paket 3 Pcs", "Ringan", 4.9, 15000);
        restaurant[0].makanan[2] = new Makanan("Dimsum Keju Paket 3 Pcs", "Ringan", 4.9, 15000);
        restaurant[0].makanan[3] = new Makanan("Dimsum Keju Paket 3 Pcs", "Ringan", 4.9, 15000);
        restaurant[0].makanan[4] = new Makanan("Dimsum Original Paket 5 Pcs", "Ringan", 4.9, 25000);
        restaurant[0].makanan[5] = new Makanan("Dimsum Jamur Paket 5 Pcs", "Ringan", 4.9, 25000);
        restaurant[0].makanan[6] = new Makanan("Dimsum Keju Paket 5 Pcs", "Ringan", 4.9, 25000);
        restaurant[0].makanan[7] = new Makanan("Dimsum Keju Paket 5 Pcs", "Ringan", 4.9, 25000);
        restaurant[0].makanan[8] = new Makanan("Bakpao", "Ringan", 4.6, 8000);
        restaurant[1] = new Restaurant("Warung Mekar Jaya", "Jl. Soekarno Hatta No.24, Jatimulyo, Malang", 10, "Restaurant", 4.2, 20000);
        restaurant[1].makanan = new Makanan[7];
        restaurant[1].makanan[0] = new Makanan("Nasi Sapi Sambal Matah", "Berat", 4.9, 25000);
        restaurant[1].makanan[1] = new Makanan("Nasi Cumi Sambal Blondo", "Berat", 4.8, 23000);
        restaurant[1].makanan[2] = new Makanan("Nasi Genjes Lauk Cumi", "Berat", 4.7, 23000);
        restaurant[1].makanan[3] = new Makanan("Nasi Cakalang Sambal Hijau", "Berat", 4.8, 18000);
        restaurant[1].makanan[4] = new Makanan("Telur Goreng Jumbo", "Lauk", 4.8, 7000);
        restaurant[1].makanan[5] = new Makanan("Ayam Goreng", "Lauk", 4.8, 11000);
        restaurant[1].makanan[6] = new Makanan("Extra Pete", "Extra", 4.6, 5000);
        restaurant[2] = new Restaurant("Bubur Ayam Bang Udin", "Jl. Kalpataru No.84, Jatimulyo, Malang", 12, "Restaurant", 4.7, 12000);
        restaurant[2].makanan = new Makanan[7];
        restaurant[2].makanan[0] = new Makanan("Bubur Ayam Nikmat", "Berat", 4.9, 17500);
        restaurant[2].makanan[1] = new Makanan("Bubur Ayam Tumpah", "Berat", 4.7, 23000);
        restaurant[2].makanan[2] = new Makanan("Bubur Ayam Jumbo", "Berat", 4.9, 26000);
        restaurant[2].makanan[3] = new Makanan("Sate Kulit", "Lauk", 4.8, 4000);
        restaurant[2].makanan[4] = new Makanan("Telur ½ Matang", "Topping", 4.8, 8000);
        restaurant[2].makanan[5] = new Makanan("Kerupuk", "Extra", 4.6, 2500);
        restaurant[2].makanan[6] = new Makanan("Kuah", "Extra", 4.6, 1000);
        restaurant[3] = new Restaurant("Kebuli Ngebul", "Jl. Sigura - Gura, Sumbersari, Malang",5,  "Restaurant", 4.4, 15000);
        restaurant[3].makanan = new Makanan[4];
        restaurant[3].makanan[0] = new Makanan("Nasi Kebuli Ngebul Ayam Standard", "Berat", 4.9, 21000);
        restaurant[3].makanan[1] = new Makanan("Nasi Kebuli Ngebul Ayam Jumbo", "Berat", 4.8, 27000);
        restaurant[3].makanan[2] = new Makanan("Nasi Kebuli Beras Basmati Tanpa Lauk ", "Berat", 4.7, 13000);
        restaurant[3].makanan[3] = new Makanan("Extra Sambal", "Extra", 4.8, 3000);
        restaurant[4] = new Restaurant("Ayam Geprek & Susu (PREKSU)", "Jl. Soekarno Hatta, Mojolangu, Malang", 15, "Restaurant", 4.6, 25000);
        restaurant[4].makanan = new Makanan[10];
        restaurant[4].makanan[0] = new Makanan("Dada/Paha Atas Geprek Mozza + Nasi", "Berat", 4.9, 30000);
        restaurant[4].makanan[1] = new Makanan("Dada/Paha Atas Geprek Sambal + Nasi", "Berat", 4.9, 25000);
        restaurant[4].makanan[2] = new Makanan("Dada/Paha Atas Geprek Mendoan + Nasi", "Berat", 4.9, 25000);
        restaurant[4].makanan[3] = new Makanan("Dada/Paha Atas Geprek Jamur + Nasi", "Berat", 4.9, 29000);
        restaurant[4].makanan[4] = new Makanan("Dada/Paha Atas Geprek Bakar Spesial + Nasi", "Berat", 4.9, 27000);
        restaurant[4].makanan[5] = new Makanan("Fried Chicken", "Ringan", 4.9, 25000);
        restaurant[4].makanan[6] = new Makanan("Jamur Crispy", "Ringan", 4.9, 25000);
        restaurant[4].makanan[7] = new Makanan("Mendoan", "Ringan", 4.9, 25000);
        restaurant[4].makanan[8] = new Makanan("Nugget", "Ringan", 4.9, 25000);
        restaurant[4].makanan[9] = new Makanan("Nasi Putih", "Ringan", 4.6, 8000);
        restaurant[5] = new Restaurant("Arion", "Jl. Cengger Ayam No.34, Tulusrejo, Malang", 13, "Cafe", 4.6, 30000);
        restaurant[5].makanan = new Makanan[5];
        restaurant[5].makanan[0] = new Makanan("Beef Brokoli", "Makanan Berat", 4.0, 28000);
        restaurant[5].makanan[1] = new Makanan("Crazy Rice", "Makanan Berat", 4.5, 23000);
        restaurant[5].makanan[2] = new Makanan("Spaghetti Bolognese", "Makanan Berat", 4.2, 30000);
        restaurant[5].makanan[3] = new Makanan("Onion Ring", "Makanan Ringan", 4.2, 18000);
        restaurant[5].makanan[4] = new Makanan("Sweet Churros", "Makanan Ringan", 4.5, 18000);
        restaurant[5].minuman = new Minuman[9];
        restaurant[5].minuman[0] = new Minuman("Cafe Mocha Latte", "Coffe", "H/C", 4.8, 22000);
        restaurant[5].minuman[1] = new Minuman("Americano", "Coffe", "H/C", 4.5, 15000);
        restaurant[5].minuman[2] = new Minuman("Coffe Latte", "Coffe", "H/C", 4.7, 20000);
        restaurant[5].minuman[3] = new Minuman("Lemon Tea", "Tea", "C", 4.5, 18000);
        restaurant[5].minuman[4] = new Minuman("Black Tea", "Tea", "H/C", 4.4, 13000);
        restaurant[5].minuman[5] = new Minuman("Lychee Tea", "Tea", "C", 4.6, 18000);
        restaurant[5].minuman[6] = new Minuman("Matcha Latte", "non-Coffe", "H/C", 4.7, 20000);
        restaurant[5].minuman[7] = new Minuman("Milky Way", "non-Coffe", "C", 4.6, 18000);
        restaurant[5].minuman[8] = new Minuman("Candy Bubblegum", "non-Coffe", "C", 4.9, 20000);
        restaurant[6] = new Restaurant("Nakoa", "Jl. Mayjend Panjaitan No.75, Malang", 5, "Cafe", 4.9, 35000);
        restaurant[6].makanan = new Makanan[10];
        restaurant[6].makanan[0] = new Makanan("Swiss Roll Cake", "Ringan", 4.9, 22000);
        restaurant[6].makanan[1] = new Makanan("Croissant", "Ringan", 4.9, 20000);
        restaurant[6].makanan[2] = new Makanan("Croffle", "Ringan", 4.9, 20000);
        restaurant[6].makanan[3] = new Makanan("Milk Bun", "Ringan", 4.9, 23000);
        restaurant[6].makanan[4] = new Makanan("Brownies", "Ringan", 4.9, 14000);
        restaurant[6].makanan[5] = new Makanan("Donut", "Ringan", 4.9, 9000);
        restaurant[6].makanan[6] = new Makanan("Bomboloni", "Ringan", 4.9, 11000);
        restaurant[6].makanan[7] = new Makanan("Crunchy Puff", "Ringan", 4.9, 9000);
        restaurant[6].makanan[8] = new Makanan("Savory Snack", "Ringan", 4.6, 15000);
        restaurant[6].makanan[9] = new Makanan("Korean Garlic Cheese Bread", "Ringan", 4.9, 20000);
        restaurant[6].minuman = new Minuman[7];
        restaurant[6].minuman[0] = new Minuman("Es Kopi Susu Gula Aren", "Kopi Susu", "C", 4.9, 21000);
        restaurant[6].minuman[1] = new Minuman("Ice Caramel Macchiato", "Kopi Susu", "C", 4.9, 26000);
        restaurant[6].minuman[2] = new Minuman("Signature Dark Chocolate", "Coklat", "H/C", 4.9, 29000);
        restaurant[6].minuman[3] = new Minuman("Choco Tiramisu", "Coklat", "H/C", 4.9, 32000);
        restaurant[6].minuman[4] = new Minuman("Matcha Latte", "non-Coffe", "H/C", 4.9, 28000);
        restaurant[6].minuman[5] = new Minuman("Shaken Boba Tea", "Tea", "C", 4.5, 24000);
        restaurant[6].minuman[6] = new Minuman("Hot Tea", "Tea", "H", 4.0, 19000);
        restaurant[7] = new Restaurant("Pesen Kopi Plus", "Jl. Mayjend Panjaitan No.191, Malang", 5,  "Cafe", 4.6, 20000);
        restaurant[7].minuman = new Minuman[3];
        restaurant[7].minuman[0] = new Minuman("Ice Kopi Susu Butter", "Coffe", "C", 4.2, 30000);
        restaurant[7].minuman[1] = new Minuman("Homemade Strawberry Milk", "Milk", "C", 4.5, 33000);
        restaurant[7].minuman[2] = new Minuman("Americano", "Coffe", "H/C", 4.7, 20000);
        restaurant[8] = new Restaurant("Kopi Studio 24", "Jl. Sarangan No.19, Lowokwaru, Malang", 10,  "Cafe", 4.9, 15000);
        restaurant[8].minuman = new Minuman[3];
        restaurant[8].minuman[0] = new Minuman("Es Kopi Susu D’Cream", "Coffe", "C", 4.3, 10000);
        restaurant[8].minuman[1] = new Minuman("Es Kopi Menggelora", "Milk", "C", 4.5, 22000);
        restaurant[8].minuman[2] = new Minuman("Es Thai Tea Studio 24", "Tea", "C", 4.3, 10000);
        restaurant[9] = new Restaurant("Dialoogi", "Jl. Soekarno Hatta No.D-505, Malang", 12, "Cafe", 4.7, 25000);
        restaurant[9].minuman = new Minuman[3];
        restaurant[9].minuman[0] = new Minuman("Carameloogi", "Coffe", "C", 4.6, 42000);
        restaurant[9].minuman[1] = new Minuman("Taro Latte", "Milk", "C", 4.4, 30000);
        restaurant[9].minuman[2] = new Minuman("Blackcurrant Tea", "Tea", "C", 4.3, 24000);
        return restaurant;
    }

    public static Driver[] inisialisasiDriver() {
        Driver[] kurir = new Driver[4];
        kurir[0] = new Driver("Mas Hilal", "081334386051", "S 4547 ABT", "Motor", 5.0);
        kurir[1] = new Driver("Mas Rajif", "089636549730", "BL 5681 LBO", "Motor", 5.0);
        kurir[2] = new Driver("Mbak Shafa", "087788109909", "A 6754 AT", "Motor", 5.0);
        kurir[3] = new Driver("Mbak Aisha", "087836447200", "D 9473 BK", "Motor", 5.0);
        return kurir;
    } 

    public static DiskonMakanan[] inisialisaiDiskonMakanan() {
        DiskonMakanan[] diskonMakanan = new DiskonMakanan[4];
        diskonMakanan[0] = new DiskonMakanan(5000);
        diskonMakanan[1] = new DiskonMakanan(10000);
        diskonMakanan[2] = new DiskonMakanan(15000);
        diskonMakanan[3] = new DiskonMakanan(20000);
        return diskonMakanan;
    }

    public static DiskonOngkir[] inisialisaiDiskonOngkir() {
        DiskonOngkir[] diskonOngkir = new DiskonOngkir[4];
        diskonOngkir[0] = new DiskonOngkir(3000);
        diskonOngkir[1] = new DiskonOngkir(5000);
        diskonOngkir[2] = new DiskonOngkir(7000);
        diskonOngkir[3] = new DiskonOngkir(9000);
        return diskonOngkir;
    }

    public static int menuMain(Scanner input) {
        System.out.println();
        System.out.println("\033[32m ________  ________  ________ ________  ________  ________     ");
        System.out.println("|\\   ____\\|\\   __  \\|\\  _____\\\\   __  \\|\\   __  \\|\\   ___ \\    ");
        System.out.println("\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\__/\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\   ");
        System.out.println(" \\ \\  \\  __\\ \\  \\\\\\  \\ \\   __\\\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\  ");
        System.out.println("  \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\_| \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\ ");
        System.out.println("   \\ \\_______\\ \\_______\\ \\__\\   \\ \\_______\\ \\_______\\ \\_______\\");
        System.out.println("    \\|_______|\\|_______|\\|__|    \\|_______|\\|_______|\\|_______|\033[0m");
        System.out.println();
        System.out.println("========================== Menu Utama ========================="); //63
        System.out.println("| 1. Cek Akun                                                 |");
        System.out.println("| 2. Beli Makanan atau Minuman                                |");
        System.out.println("| 3. Cek keranjang                                            |");
        System.out.println("| 4. Pembayaran                                               |");
        System.out.println("| 5. Top Up                                                   |");
        System.out.println("| 6. Keluar                                                   |");
        System.out.println("===============================================================");
        System.out.print("Masukkan pilihan: \033[32m");
        int pilihan = input.nextInt();
        System.out.print("\033[0m");
        return pilihan;
    }

    public static int menuAkun(Scanner input, User user) {
        System.out.println();
        System.out.println("========================== Menu Akun =========================="); //63
        user.getDetil();
        System.out.println("===============================================================");
        System.out.println("| 1. Ubah Email                                               |");
        System.out.println("| 2. Ubah PIN                                                 |");
        System.out.println("| 3. Kembali                                                  |");
        System.out.println("===============================================================");
        System.out.print("Masukkan pilihan: \033[32m");
        int pilihan = input.nextInt();
        System.out.print("\033[0m");
        return pilihan;
    }

    public static void UbahEmail(Scanner input, User user) {
        int PIN = 0;
        System.out.println();
        System.out.print("Masukkan Email Baru: \033[32m");
        String emailBaru = input.nextLine();
        System.out.print("\033[0m");
        System.out.print("Masukkan PIN: \033[32m");
        try {
            PIN = input.nextInt();
        } catch (Exception e) {
            
        } finally {           
            input.nextLine();
            System.out.print("\033[0m");
        }
        boolean status = user.ubahEmail(emailBaru, PIN);
        System.out.println();

        if (status) {
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                    EMAIL BERHASIL DIUBAH!!                  |");
            System.out.println("+-------------------------------------------------------------+");
        } else {
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                  EMAIL TIDAK BERHASIL DIUBAH!               |");
            System.out.println("|                 PIN YANG ANDA MASUKKAN SALAH!!              |");
            System.out.println("+-------------------------------------------------------------+");
        }
    }

    public static void UbahPIN(Scanner input, User user) {
        int PINLama = 0, PINBaru = 0;
        System.out.println();
        System.out.print("Masukkan PIN lama: \033[32m");
        try {  
            PINLama = input.nextInt();
        } catch (Exception e) {
            
        } finally {
            input.nextLine();
            System.out.print("\033[0m");
        }

        if (PINLama == user.getPIN()) {  
            System.out.print("Masukkan PIN baru: \033[32m");
            try {  
                PINBaru = input.nextInt();
                System.out.print("\033[0m");
                user.ubahPIN(PINLama, PINBaru);
                System.out.println();
                System.out.println("+-------------------------------------------------------------+");
                System.out.println("|                     PIN BERHASIL DIUBAH!!                   |");
                System.out.println("+-------------------------------------------------------------+");
            } catch (Exception e) {
                System.out.print("\033[0m");
                System.out.println("+-------------------------------------------------------------+");
                System.out.println("|                   PIN TIDAK BERHASIL DIUBAH!                |");
                System.out.println("|               PIN YANG DIMASUKKAN HARUS ANGKA!!             |");
                System.out.println("+-------------------------------------------------------------+");
            } finally {
                input.nextLine();
            }
        } else {
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                   PIN TIDAK BERHASIL DIUBAH!                |");
            System.out.println("|                 PIN YANG ANDA MASUKKAN SALAH!!              |");
            System.out.println("+-------------------------------------------------------------+");
        }
    }

    public static int menuPembelian(Scanner input, Restaurant[] restaurant) {
        System.out.println();
        System.out.println("======================== Menu Pembelian =======================");
        System.out.println("| 1. Makanan                                                  |");
        System.out.println("| 2. Minuman                                                  |");
        System.out.println("| 3. Kembali                                                  |");
        System.out.println("===============================================================");
        System.out.print("Masukkan pilihan: \033[32m");
        int pilihan = input.nextInt();
        System.out.print("\033[0m");
        return pilihan;
    }

    public static boolean beliMakanan(Scanner input, Restaurant[] restaurant, Pesanan pesanan) {
        boolean statusPembelian = false;
        char beliLagi = 'N';
        System.out.println();
        System.out.println("====================== List Resto & Cafe ======================");
        for (int i = 0; i < restaurant.length; i++) {
            if (restaurant[i].makanan != null) {
                restaurant[i].getDetil();
            }
        }
        
        System.out.print("Pilih resto/cafe: \033[32m");
        String namaResto = input.nextLine();
        System.out.print("\033[0m");
        boolean statusResto = false;
        boolean statusMakanan = true;
        for (int i = 0; i < restaurant.length; i++) {
            if (namaResto.equalsIgnoreCase(restaurant[i].getNama())) {
                statusResto = true;
                statusMakanan = false;
                do {  
                    System.out.println("========================= List Makanan ========================");
                    for (int j = 0; j < restaurant[i].makanan.length; j++) {
                        restaurant[i].makanan[j].getDetil();;
                    }
                    System.out.print("Pilih makanan: \033[32m");
                    String namaMakanan = input.nextLine();
                    System.out.print("\033[0m");
                    for (int j = 0; j < restaurant[i].makanan.length; j++) {
                        if (namaMakanan.equalsIgnoreCase(restaurant[i].makanan[j].getNama())) {
                            statusMakanan = true;                            
                            System.out.print("Masukkan jumlah: \033[32m");
                            int jumlah = input.nextInt();
                            input.nextLine();
                            System.out.print("\033[0m");
                            pesanan.pesanMakanan(restaurant[i], restaurant[i].makanan[j], jumlah);
                            System.out.println("+-------------------------------------------------------------+");
                            System.out.println("|                       PESANAN DIBUAT!!                      |");
                            System.out.println("+-------------------------------------------------------------+");
                            statusPembelian = true;
                            
                            System.out.println();
                            System.out.print("Apakah ingin beli lagi Y/N: \033[32m");
                            beliLagi = input.nextLine().charAt(0);
                            System.out.print("\033[0m");
                        }
                    }
                } while (beliLagi == 'Y');
            }
        }

        // misal salah input nama resto
        if (!statusResto) {     
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|               RESTO ATAU CAFE TIDAK DITEMUKAN!!             |");
            System.out.println("+-------------------------------------------------------------+");
        }
        
        // misal salah input nama makanan
        if (!statusMakanan) {     
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                   MAKANAN TIDAK DITEMUKAN!!                 |");
            System.out.println("+-------------------------------------------------------------+");
        }

        return statusPembelian;
    }

    public static boolean beliMinuman(Scanner input, Restaurant[] restaurant, Pesanan pesanan) {
        boolean statusPembelian = false;
        char beliLagi = 'N';
        System.out.println();
        System.out.println("====================== List Resto & Cafe ======================");
        for (int i = 0; i < restaurant.length; i++) {
            if (restaurant[i].minuman != null) {
                restaurant[i].getDetil();
            }
        }

        System.out.print("Pilih resto/cafe: \033[32m");
        String namaresto = input.nextLine();
        System.out.print("\033[0m");
        boolean statusResto = false;
        boolean statusMinuman = true;
        for (int i = 0; i < restaurant.length; i++) {
            if (namaresto.equalsIgnoreCase(restaurant[i].getNama())) {
                statusResto = true;
                statusMinuman = false;
                do {
                    System.out.println("========================= List Minuman ========================");
                    for (int j = 0; j < restaurant[i].minuman.length; j++) {
                        restaurant[i].minuman[j].getDetil();;
                    }
                    System.out.print("Pilih minuman: \033[32m");
                    String namaMinuman = input.nextLine();
                    System.out.print("\033[0m");
                    for (int j = 0; j < restaurant[i].minuman.length; j++) {
                        if (namaMinuman.equalsIgnoreCase(restaurant[i].minuman[j].getNama())) {
                            statusMinuman = true;                            
                            System.out.print("Masukkan jumlah: \033[32m");
                            int jumlah = input.nextInt();
                            input.nextLine();
                            System.out.print("\033[0m");
                            pesanan.pesanMinuman(restaurant[i], restaurant[i].minuman[j], jumlah);
                            System.out.println("+-------------------------------------------------------------+");
                            System.out.println("|                       PESANAN DIBUAT!!                      |");
                            System.out.println("+-------------------------------------------------------------+");
                            statusPembelian = true;
    
                            System.out.println();
                            System.out.print("Apakah ingin beli lagi Y/N: \033[32m");
                            beliLagi = input.nextLine().charAt(0);
                            System.out.print("\033[0m");
                        }
                    }
                } while (beliLagi == 'Y');
            }
        }

        // misal salah input nama resto
        if (!statusResto) {     
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|               RESTO ATAU CAFE TIDAK DITEMUKAN!!             |");
            System.out.println("+-------------------------------------------------------------+");
        }
        
        // misal salah input nama minuman
        if (!statusMinuman) {     
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                   MINUMAN TIDAK DITEMUKAN!!                 |");
            System.out.println("+-------------------------------------------------------------+");
        }

        return statusPembelian;
    }

    public static int menuPembayaran(Scanner input, boolean statusPembelian) {
        if (statusPembelian) {        
            System.out.println();
            System.out.println("======================= Menu Pembayaran =======================");
            System.out.println("| 1. Cash on Delivery                                         |");
            System.out.println("| 2. Gopay                                                    |");
            System.out.println("| 3. Kembali                                                  |");
            System.out.println("===============================================================");
            System.out.print("Masukkan pilihan: \033[32m");
            int pilihan = input.nextInt();
            System.out.print("\033[0m");
            return pilihan;
        } else {
            // kalo belum pesen
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                 PESANAN ANDA MASIH KOSONG                   |");
            System.out.println("|              SILAHKAN PESAN TERLEBIH DAHULU!!               |");
            System.out.println("+-------------------------------------------------------------+");
            return 3;
        }
    }

    public static void bayarCOD(Scanner input, User user, Pesanan pesanan, Diskon[] diskon, Driver[] kurir) {
        // kalo COD saldonya ngga berkurang sama status pembayarannya belum selesai
        int i = (int) (Math.random()*4);
        diskon[i].potongHarga(pesanan);
        pesanan.getNota(user, "Cash on Delivery", "Belum Selesai", diskon[i], kurir[i]);
        System.out.println();
        System.out.println("+-------------------------------------------------------------+");
        System.out.printf("|      Pesanan anda sedang diantar oleh kurir %-10s      |\n", kurir[i].getNama());
        System.out.println("|               Mohon tunggu dengan sabar yaa..               |");
        System.out.println("|         Jangan lupa bayar total tagihan ke kurir ya..       |");
        System.out.println("+---------------------------------------------------   -------+");
        System.out.println("                                                    \\ /   ");
        System.out.println("                                                     V     ");
        System.out.println("                                                       *^____^*");
    }
    
    public static void bayarGopay(Scanner input, User user, Pesanan pesanan, Diskon[] diskon, Driver[] kurir) {
        // kalo bayar gopay saldonya berkurang trs tampilin saldo di akhir
        int pinPembayaran = 0;
        int i = (int) (Math.random()*4);
        System.out.print("Masukkan PIN: \033[32m");
        try {
            pinPembayaran = input.nextInt();
        } catch (Exception e) {

        } finally {
            input.nextLine();
            System.out.print("\033[0m");
        }
        
        if (pinPembayaran == user.getPIN()) {
            diskon[i].potongHarga(pesanan);
            pesanan.getNota(user, "Gopay", "Selesai", diskon[i], kurir[i]);
            user.setSaldo(user.getSaldo()-pesanan.getHargaTotal());
            System.out.println();
            System.out.println("+-------------------------------------------------------------+");
            System.out.printf("|      Pesanan anda sedang diantar oleh kurir %-10s      |\n", kurir[i].getNama());
            System.out.println("|               Mohon tunggu dengan sabar yaa..               |");
            System.out.printf("|         Sisa saldo anda sekarang adalah Rp.%-10.1f       |\n", user.getSaldo());
            System.out.println("+---------------------------------------------------   -------+");
            System.out.println("                                                    \\ /   ");
            System.out.println("                                                     V     ");
            System.out.println("                                                       *^____^*");
        } else {
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                   PEMBAYARAN TIDAK BERHASIL!                |");
            System.out.println("|                 PIN YANG ANDA MASUKKAN SALAH!!              |");
            System.out.println("+-------------------------------------------------------------+");
        }
    }

    public static void menuTopUp(Scanner input, User user) {
        // langsung top up aja gaperlu via bank atau apa, saldo langsung nambah
        System.out.println("========================= Menu Top Up =========================");
        System.out.println("|                                                             |");
        System.out.printf("| Saldo anda sekarang: \u001B[1m\033[31mRp.%-35.2f\033\0[0m |\n", user.getSaldo());
        System.out.println("|                                                             |");
        System.out.println("===============================================================");
        System.out.print("Masukkan jumlah nominal top up: Rp.\033[32m");
        double nominal = input.nextDouble();
        System.out.print("\033[0m");
        if (nominal < 10000) {
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                        TOP UP GAGAL!!                       |");
            System.out.println("|          NOMINAL YANG ANDA MASUKKAN TERLALU KECIL!!         |");
            System.out.println("|                 MINIMAL TOP UP RP.10000,00!!                |");
            System.out.println("+-------------------------------------------------------------+");
        } else {
            user.setSaldo(user.getSaldo()+nominal);
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                       TOP UP BERHASIL!!                     |");
            System.out.println("+-------------------------------------------------------------+");
        }
    }
}