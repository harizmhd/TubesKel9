package travelink;

import java.util.*;

public class Aplikasi {
    Scanner scLong = new Scanner(System.in);
    Scanner scString = new Scanner(System.in);
    Scanner scInt = new Scanner(System.in);
    Scanner scFloat = new Scanner(System.in);

    int pilMainMenu = -1;
    int pilSubMenu = -1;
    
    ArrayList<TempatWisata> listTempatWisata = new ArrayList<>();
    ArrayList<PaketWisata> listPaketWisata = new ArrayList<>();
    ArrayList<Pelanggan> listPelanggan = new ArrayList<>();
    ArrayList<Perjalanan> listPerjalanan = new ArrayList<>();
    
    public void mainMenu() {
        while(pilMainMenu != 0) {
            System.out.println("- Main Menu -");
            System.out.println("1. Tempat Wisata");
            System.out.println("2. Paket Wisata");
            System.out.println("3. Pelanggan");
            System.out.println("4. Perjalanan");
            System.out.println("0. Logout");
            System.out.println();
            
            try {
                System.out.print("Pilih Menu : ");
                pilMainMenu = scInt.nextInt();
                switch (pilMainMenu) {
                    case 1:
                        subMenuTempatWisata();
                        break;
                    case 2:
                        printPaketWisata();
                        break;
                    case 3:
                        printPelanggan();
                        break;
                    case 4:
                        printPerjalanan();
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
        listTempatWisata.add(tw);
    }
    
    // createPaketWisata melakukan instansiasi, addPaketWisata, dan insert objek ke dalam listPaketWisata
    // dtw adlh 'array of TempatWisata' yang sementara menampung kumpulan TempatWisata sebelum di add ke PaketWisata
    // method ini akan satu per satu meng-add (menyalin) isi dari dtw ke objek PaketWisata
    private void createPaketWisata(long idPaket, String namaPaket, float hargaPaket, TempatWisata[] dtw) {
        PaketWisata pw = new PaketWisata(idPaket, namaPaket, hargaPaket);
        int n = 0;
        while (n < dtw.length) {
            pw.addTempatWisata(dtw[n]);
            n++;
        }
        listPaketWisata.add(pw);
    }
    
    // createPelanggan melakukan instansiasi dan insert objek ke dalam listPelanggan 
    private void createPelanggan(long idKTP, String nama, long noKtp, char jenisKelamin, String alamat, String email, long noTelp) {
        Pelanggan pg = new Pelanggan(idKTP, nama, noKtp, jenisKelamin, alamat, email, noTelp);
        listPelanggan.add(pg);
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
        listPerjalanan.add(pj);
    }
    
    public void deleteTempatWisata() {
        
    }
    
    public void deletePaketWisata() {
        
    }
    
    public void deletePelanggan() {
        
    }
    
    public void deletePerjalanan() {
        
    }
    
    //print isi listTempatWisata
    public void printTempatWisata() {
        System.out.println("\n- List Tempat Wisata -");
        if (listTempatWisata.isEmpty())
            System.out.println("List kosong.\n");
        else {
            for (int i = 0; i < listTempatWisata.size(); i++)
                System.out.println(i + 1 + ": " + listTempatWisata.get(i).toString());
        }
    }
    
    //print isi listPaketWisata
    public void printPaketWisata() {
        System.out.println("\n- List Paket Wisata -");
        if (listPaketWisata.isEmpty())
            System.out.println("List kosong.\n");
        else {
            for (int i = 0; i < listPaketWisata.size(); i++)
                System.out.println(i + 1 + ": " + listPaketWisata.get(i).toString());
        }
    }
    
    //print isi listPelanggan
    public void printPelanggan() {
        System.out.println("\n- List Pelanggan-");
        if (listPelanggan.isEmpty())
            System.out.println("List kosong.\n");
        else {
            for (int i = 0; i < listPelanggan.size(); i++)
                System.out.println(i + 1 + ": " + listPelanggan.get(i).toString());
        }
    }
    
    //print isi listPerjalanan
    public void printPerjalanan() {
        System.out.println("\n- List Perjalanan-");
        if (listPelanggan.isEmpty())
            System.out.println("List kosong.\n");
        else {
            for (int i = 0; i < listPelanggan.size(); i++)
                System.out.println(i + 1 + ": " + listPelanggan.get(i).toString());
        }
    }
    
    public void subMenuTempatWisata() {
        pilSubMenu = -1;
        
        while (pilSubMenu != 0) {
            printTempatWisata();
            System.out.println("- Sub Menu -");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("0. Back");
            System.out.print("Pilihan: ");
            try {
                pilSubMenu = scInt.nextInt();
                switch(pilSubMenu) {
                    case 1:
                        System.out.println("\n- Registrasi Tempat Wisata -");
                        System.out.print("ID : ");
                        long idTempat = scLong.nextLong();
                        System.out.print("Nama Tempat Wisata : ");
                        String namaTempat = scString.nextLine();
                        System.out.print("Deskripsi : ");
                        String deskripsiTempat = scString.nextLine();
                        createTempatWisata(idTempat, namaTempat, deskripsiTempat);
                        System.out.println("\'Tempat Wisata Tersimpan\'");
                        break;
                    case 2:
                        break;
                    case 0:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Input Salah");
            }
        }    
    }
}