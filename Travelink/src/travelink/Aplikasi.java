package travelink;

import java.util.*;

public class Aplikasi {
    Scanner scLong = new Scanner(System.in);
    Scanner scString = new Scanner(System.in);
    Scanner scInt = new Scanner(System.in);
    Scanner scFloat = new Scanner(System.in);
    
    ArrayList<TempatWisata> listTempatWisata = new ArrayList<>();
    ArrayList<PaketWisata> listPaketWisata = new ArrayList<>();
    ArrayList<Pelanggan> listPelanggan = new ArrayList<>();
    ArrayList<Perjalanan> listPerjalanan = new ArrayList<>();
    
    public void mainMenu() {
        int pilMainMenu = -1;
        
        while(pilMainMenu != 0) {
            System.out.println("- Main Menu -");
            System.out.println("1. Tempat Wisata");
            System.out.println("2. Paket Wisata");
            System.out.println("3. Pelanggan");
            System.out.println("4. Perjalanan");
            System.out.println("0. Logout");
            System.out.println();
            System.out.print("Pilih Menu : ");
            
            pilMainMenu = -1;
            
            try {
                pilMainMenu = scInt.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("input mismatch");
            } catch (Exception e) {
                System.out.println("exception occurs");
            } finally {
                scInt.nextLine();
            }
            
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
                default:
                    System.out.println("Input tidak valid.\n");
            }
        }
    }
    
    private void subMenuTempatWisata() {
        int pilSubMenu = -1;
        boolean lanjutInput;
        boolean hapus;
        long idTempat;
        String namaTempat;
        String deskripsiTempat;
        
        while (pilSubMenu != 0) {
            printTempatWisata();
            System.out.println("- Sub Menu -");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("0. Back");
            System.out.print("Pilihan: ");

            pilSubMenu = -1;

            try {
                pilSubMenu = scInt.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("input mismatch");
            } catch (Exception e) {
                System.out.println("exception occurs");
            } finally {
                scInt.nextLine();
            }

            switch (pilSubMenu) {
                case 1:
                    lanjutInput = true;
                    idTempat = -1;
                    namaTempat = " ";
                    deskripsiTempat = " ";
                    
                    if (lanjutInput) {
                        System.out.println("\n- Registrasi Tempat Wisata -");
                        System.out.print("ID : ");
                        try {
                            idTempat = scLong.nextLong();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("input mismatch");
                            lanjutInput = false;
                        } catch (Exception e) {
                            System.out.println("exception occurs");
                            lanjutInput = false;
                        } finally {
                            scLong.nextLine();
                        }
                    }
                    
                    if (lanjutInput) {
                        System.out.print("Nama Tempat Wisata : ");
                        try {
                            namaTempat = scString.nextLine();
                        } catch (Exception e) {
                            System.out.println("exception occurs");
                            lanjutInput = false;
                        }
                    }
                    
                    if (lanjutInput) {
                        System.out.print("Deskripsi : ");
                        try {
                            deskripsiTempat = scString.nextLine();
                        } catch (Exception e) {
                            System.out.println("exception occurs");
                            lanjutInput = false;
                        }
                    }
                    
                    if (lanjutInput) {
                        createTempatWisata(idTempat, namaTempat, deskripsiTempat);
                        System.out.println("\'Tempat Wisata Tersimpan\'");
                    } else
                        System.out.println("\'Registrasi dibatalkan\'");
                    break;
                    
                case 2:
                    lanjutInput = true;
                    idTempat = -1;                
                    System.out.print("\nID Tempat Wisata : ");
                    
                    try {
                        idTempat = scLong.nextLong();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("input mismatch");
                        lanjutInput = false;
                    } catch (Exception e) {
                        System.out.println("exception occurs");
                        lanjutInput = false;
                    } finally {
                        scLong.nextLine();
                    }
                    
                    if (lanjutInput) {
                        try {
                            hapus = deleteTempatWisata(idTempat);
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                            hapus = false;
                        }
                        if (hapus)
                            System.out.println("\'Tempat Wisata " + idTempat + " terhapus\'");
                        else
                            System.out.println("\'Penghapusan dibatalkan\'");
                    }
                    else {
                        System.out.println("\'Penghapusan dibatalkan\'");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Input tidak valid.\n");
            }
        }
    }
    
    // createTempatWisata melakukan instansiasi dan insert objek ke dalam listTempatWisata 
    private void createTempatWisata(long idTempat, String namaTempat, String deskripsiTempat) {
        TempatWisata tw = new TempatWisata(idTempat, namaTempat, deskripsiTempat);
        listTempatWisata.add(tw);
    }
    
    /* createPaketWisata melakukan instansiasi, addPaketWisata, dan insert objek ke dalam listPaketWisata
       dtw adlh 'array of TempatWisata' yang sementara menampung kumpulan TempatWisata sebelum di add ke PaketWisata
       method ini akan satu per satu meng-add (menyalin) isi dari dtw ke objek PaketWisata */
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
    
    /* createPerjalanan melakukan instansiasi, addPelanggan, dan insert objek ke dalam listPaketWisata
       dpg adlh 'array of Pelanggan' yang sementara menampung kumpulan Pelanggan sebelum di add ke Perjalanan
       method ini akan satu per satu meng-add (menyalin) isi dari dpg ke objek Perjalanan */
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
    
    /* mencari dan menghapus TempatWisata dengan idTempat x di dalam listTempatWisata
       mengeluarkan hasil true jika berhasil menghapus, mengeluarkan hasil false jika TempatWisata
       tidak ditemukan */
    private boolean deleteTempatWisata(long x) {
        boolean found = false;
        boolean delete = false;
        TempatWisata z = null;
        
        for (TempatWisata y : listTempatWisata) {
            if (y.getIdTempat() == x) {
                found = true;
                z = y;
            }
        }
        
        if (found) {
            try {
                delete = listTempatWisata.remove(z);
            } catch (Exception e) {
                System.out.println("exception occurs");
            }
        }
        else
            throw new RuntimeException("idTempat " + x + " not found");
        
        return delete;
    }
    
    private void deletePaketWisata() {
        
    }
    
    private void deletePelanggan() {
        
    }
    
    private void deletePerjalanan() {
        
    }
    
    //print isi listTempatWisata
    private void printTempatWisata() {
        System.out.println("\n- List Tempat Wisata -");
        if (listTempatWisata.isEmpty())
            System.out.println("List kosong.\n");
        else {
            for (int i = 0; i < listTempatWisata.size(); i++)
                System.out.println(i + 1 + ": " + listTempatWisata.get(i).toString());
        }
    }
    
    //print isi listPaketWisata
    private void printPaketWisata() {
        System.out.println("\n- List Paket Wisata -");
        if (listPaketWisata.isEmpty())
            System.out.println("List kosong.\n");
        else {
            for (int i = 0; i < listPaketWisata.size(); i++)
                System.out.println(i + 1 + ": " + listPaketWisata.get(i).toString());
        }
    }
    
    //print isi listPelanggan
    private void printPelanggan() {
        System.out.println("\n- List Pelanggan-");
        if (listPelanggan.isEmpty())
            System.out.println("List kosong.\n");
        else {
            for (int i = 0; i < listPelanggan.size(); i++)
                System.out.println(i + 1 + ": " + listPelanggan.get(i).toString());
        }
    }
    
    //print isi listPerjalanan
    private void printPerjalanan() {
        System.out.println("\n- List Perjalanan-");
        if (listPelanggan.isEmpty())
            System.out.println("List kosong.\n");
        else {
            for (int i = 0; i < listPelanggan.size(); i++)
                System.out.println(i + 1 + ": " + listPelanggan.get(i).toString());
        }
    }

}