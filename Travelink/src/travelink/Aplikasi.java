package travelink;

import java.util.Scanner;

public class Aplikasi {
    Scanner scLong = new Scanner(System.in);
    Scanner scString = new Scanner(System.in);
    Scanner scInt = new Scanner(System.in);
    Scanner scFloat = new Scanner(System.in);
    Scanner scChar = new Scanner(System.in);
    
    int pilMainMenu = -1;
    
    final int maxList = 100;
    
    TempatWisata listTempatWisata[] = new TempatWisata[maxList];
    PaketWisata listPaketWisata[] = new PaketWisata[maxList];
    Pelanggan listPelanggan[] = new Pelanggan[maxList];
    Perjalanan listPerjalanan[] = new Perjalanan[maxList];
    
    int nListTempatWisata;
    int nListPaketWisata;
    int nListPelanggan;
    int nListPerjalanan;
    
    public void mainMenu() {
        while(pilMainMenu != 0) {
            System.out.println("- Main Menu -");
            System.out.println("1. Registrasi Tempat Wisata");
            System.out.println("2. Registrasi Paket Wisata");
            System.out.println("3. Registrasi Pelanggan");
            System.out.println("4. Registrasi Perjalanan");
            System.out.println("0. Logout");
            System.out.println();
            
            try {
                System.out.print("Pilih Menu : ");
                pilMainMenu = scInt.nextInt();
                switch (pilMainMenu) {
                    case 1:
                        System.out.println("- Registrasi Tempat Wisata -");
                        System.out.println("Id Tempat   : ");
                        long idTempat = scLong.nextLong();
                        System.out.println("Nama Tempat : ");
                        String namaTempat = scString.nextLine();
                        System.out.println("Deskripsi   : ");
                        String deskripsiTempat = scString.nextLine();
                        createTempatWisata(idTempat, namaTempat, deskripsiTempat);
                        System.out.println();
                        System.out.println("Tempat Wisata " + idTempat + " berhasil disimpan");
                        break;
                    case 2:
                        System.out.println("- Registrasi Paket Wisata -");
                        System.out.println("Id Paket    : ");
                        long idPaket = scLong.nextLong();
                        System.out.println("Nama Paket  : ");
                        String namaPaket = scString.nextLine();
                        System.out.println("Harga Paket : ");
                        float hargaPaket = scFloat.nextFloat();
                        System.out.println("Pilih Tempat Wisata : ");
                        /*
                            Menampilkan list tempat wisata yang tersedia dan
                            kemudian memilih paket wisata
                        */
                        TempatWisata[] dtw = new TempatWisata[50];
                        createPaketWisata(idPaket, namaPaket, hargaPaket, dtw);
                        System.out.println();
                        System.out.println("Tempat Wisata " + idPaket + " berhasil disimpan");
                        break;
                    case 3:
                        System.out.println("- Registrasi Pelanggan -");
                        System.out.println("Id Pelanggan   : ");
                        long idPelanggan = scLong.nextLong();
                        System.out.println("Nama           : ");
                        String nama = scString.nextLine();
                        System.out.println("No KTP         : ");
                        long noKtp = scLong.nextLong();
                        System.out.println("Jenis Kelamin(L/P): ");
                        char jenisKelamin = 'L';
                        System.out.println("Alamat         : ");
                        String alamat = scString.nextLine();
                        System.out.println("E-mail         : ");
                        String email = scString.nextLine();
                        System.out.println("No. Telp        : ");
                        long noTelp = scLong.nextLong();
                        createPelanggan(idPelanggan, nama, noKtp, jenisKelamin, alamat, email, noTelp);
                        System.out.println();
                        System.out.println("Pelanggan " + idPelanggan + " berhasil disimpan");
                        break;
                    case 4:
                        
                        break;
                    case 0:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Input Salah");
            }
        }
    }
    
    // createTempatWisata melakukan instansiasi dan insert objek ke dalam listTempatWisata 
    private void createTempatWisata(long idTempat, String namaTempat, String deskripsiTempat) {
        TempatWisata tw = new TempatWisata(idTempat, namaTempat, deskripsiTempat);
        listTempatWisata[nListTempatWisata] = tw;
        nListTempatWisata++;
    }
    
    // createPaketWisata melakukan instansiasi, addPaketWisata, dan insert objek ke dalam listPaketWisata
    // dtw adlh 'array of TempatWisata' yang sementara menampung kumpulan TempatWisata sebelum di add ke PaketWisata
    // method ini akan satu per satu meng-add (menyalin) isi dari dtw ke objek PaketWisata
    private void createPaketWisata(long idPaket, String namaPaket, float hargaPaket, TempatWisata[] dtw) {
        PaketWisata pw = new PaketWisata(idPaket, namaPaket, hargaPaket);
        int n = 0;
        while (dtw[n] != null) {
            pw.addTempatWisata(dtw[n]);
            n++;
        }
        listPaketWisata[nListPaketWisata] = pw;
        nListPaketWisata++;
    }
    
    // createPelanggan melakukan instansiasi dan insert objek ke dalam listPelanggan 
    private void createPelanggan(long idKTP, String nama, long noKtp, char jenisKelamin, String alamat, String email, long noTelp) {
        Pelanggan pg = new Pelanggan(idKTP, nama, noKtp, jenisKelamin, alamat, email, noTelp);
        listPelanggan[nListPelanggan] = pg;
        nListPelanggan++;
    }
    
    // createPerjalanan melakukan instansiasi, addPelanggan, dan insert objek ke dalam listPaketWisata
    // dpg adlh 'array of Pelanggan' yang sementara menampung kumpulan Pelanggan sebelum di add ke Perjalanan
    // method ini akan satu per satu meng-add (menyalin) isi dari dpg ke objek Perjalanan
    private void createPerjalanan(long idPerjalanan, PaketWisata paket, Pelanggan[] dpg) {
        Perjalanan pj = new Perjalanan(idPerjalanan);
        pj.setPaket(paket);
        int n = 0;
        while (dpg[n] != null) {
            pj.addPelanggan(dpg[n]);
            n++;
        }
        listPerjalanan[nListPerjalanan] = pj;
        nListPerjalanan++;
    }
    
    public void deleteTempatWisata() {
        
    }
    
    public void deletePaketWisata() {
        
    }
    
    public void deletePelanggan() {
        
    }
    
    public void deletePerjalanan() {
        
    }
    
}
