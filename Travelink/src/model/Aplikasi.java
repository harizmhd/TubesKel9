package model;

import java.util.*;

public class Aplikasi {
    private ArrayList<Petugas> listPetugas;
    private ArrayList<TempatWisata> listTempatWisata;
    private ArrayList<PaketWisata> listPaketWisata;
    private ArrayList<Pelanggan> listPelanggan;
    private ArrayList<Perjalanan> listPerjalanan;
    
    public Aplikasi() {
        listPetugas = new ArrayList<>();
        listTempatWisata = new ArrayList<>();
        listPaketWisata = new ArrayList<>();
        listPelanggan = new ArrayList<>();
        listPerjalanan = new ArrayList<>();
    }
    
    public void mainMenu() {
        Scanner scInt = new Scanner(System.in);
        Scanner scLong = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        int pilMainMenu = -1;
        int pilSubMenu;
        String tmpUsername, tmpPassword;
        boolean hakAkses = false;
        while(hakAkses==false && pilMainMenu != 0) {
            System.out.print("\n- Travelink -\n1. Login\n2. Sign Up\n0. Quit\n" +
                    "\nPilih Menu : ");
            pilMainMenu = -1;  
            try {
                pilMainMenu = scInt.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("input mismatch");
            } catch (Exception e) {
                System.out.println("Exception occurred : " + e.getMessage());
            } finally {
                scInt.nextLine();
            }
            switch(pilMainMenu) {
                case 1:
                    System.out.print("\n- Login -\n\n");
                    try {
                        System.out.print("Username : ");
                        tmpUsername = scString.nextLine();
                        System.out.print("Password : ");
                        tmpPassword = scString.nextLine();
                        hakAkses = login(tmpUsername, tmpPassword);
                    } catch (Exception e) {
                        System.out.println("Exception occurred : " + e.getMessage());
                    }
                    if (!hakAkses)
                        System.out.println("\nUsername atau password yang dimasukkan salah");
                    break;
                case 2:
                    System.out.println(printPetugas());
                    System.out.print("\n- Registrasi Petugas -\n");
                    try {
                        System.out.print("Username : ");
                        tmpUsername = scString.nextLine();
                        System.out.print("Password : ");
                        tmpPassword = scString.nextLine();
                        System.out.print("Ulang password : ");
                        String tmpPassword2 = scString.nextLine();
                        if (!tmpPassword.equals(tmpPassword2))
                            throw new RuntimeException("Password yang dimasukkan tidak sama");
                        long idPegawai = incrementId(1);
                        System.out.println("ID : " + idPegawai);
                        System.out.print("Nama : ");
                        String nama = scString.nextLine();
                        System.out.print("No KTP : ");
                        Long noKtp = scLong.nextLong();
                        System.out.print("Jenis Kelamin :\n(1) Laki-laki\n(2) Perempuan"
                                + "\nPilihan : ");
                        int pilihJenisKelamin = scInt.nextInt();
                        char jenisKelamin;
                        switch (pilihJenisKelamin) {
                            case 1:
                                jenisKelamin = 'L';
                                break;
                            case 2:
                                jenisKelamin = 'P';
                                break;
                            default:
                                throw new RuntimeException("Pilihan tidak valid");
                        }
                        System.out.print("Alamat : ");
                        String alamat = scString.nextLine();
                        System.out.print("E-mail : ");
                        String email = scString.nextLine();
                        System.out.print("No Telp : ");
                        Long noTelp = scLong.nextLong();
                        createPetugas(idPegawai, tmpUsername, tmpPassword, nama, noKtp, jenisKelamin, alamat, email, noTelp);
                        System.out.println("\'Akun berhasil dibuat\'");
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("input mismatch");
                        System.out.println("\'Registrasi dibatalkan\'");
                    } catch(RuntimeException e) {
                        System.out.println(e.getMessage());
                        System.out.println("\'Registrasi dibatalkan\'");
                    } catch (Exception e) {
                        System.out.println("Exception occurred : " + e.getMessage());
                        System.out.println("\'Registrasi dibatalkan\'");
                    } finally {
                        scLong.nextLine();
                        scInt.nextLine();
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Input tidak valid.\n");
            }
        }
        
        while(pilMainMenu != 0) {
            System.out.print("\n- Main Menu -\n1. Tempat Wisata\n2. Paket Wisata\n" +
                    "3. Pelanggan\n4. Perjalanan\n0. Logout\n\nPilih Menu : ");         
            pilMainMenu = -1;           
            try {
                pilMainMenu = scInt.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("input mismatch");
            } catch (Exception e) {
                System.out.println("Exception occurred : " + e.getMessage());
            } finally {
                scInt.nextLine();
            }
            
            switch (pilMainMenu) {
                case 1:
                    pilSubMenu = -1;
                    while (pilSubMenu != 0) {
                        System.out.println(printTempatWisata());
                        System.out.print("- Kelola Tempat Wisata -\n1. Add\n"
                                + "2. Remove\n0. Back\nPilihan: ");
                        try {
                            pilSubMenu = scInt.nextInt();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("input mismatch");
                        } catch (Exception e) {
                            System.out.println("Exception occurred : " + e.getMessage());
                        } finally {
                            scInt.nextLine();
                        }
                        subMenuTempatWisata(pilSubMenu);
                    }                 
                    break;
                case 2:
                    pilSubMenu = -1;
                    while (pilSubMenu != 0) {
                        System.out.println(printPaketWisata());
                        System.out.print("- Kelola Paket Wisata -\n1. Add\n"
                                + "2. Remove\n0. Back\nPilihan: ");
                        try {
                            pilSubMenu = scInt.nextInt();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("input mismatch");
                        } catch (Exception e) {
                            System.out.println("Exception occurred : " + e.getMessage());
                        } finally {
                            scInt.nextLine();
                        }
                        subMenuPaketWisata(pilSubMenu);
                    }
                    break;
                case 3:
                    pilSubMenu = -1;
                    while (pilSubMenu != 0) {
                        System.out.println(printPelanggan());
                        System.out.println("- Kelola Pelanggan -\n1. Add\n"
                                + "2. Remove\n0. Back\nPilihan: ");
                        try {
                            pilSubMenu = scInt.nextInt();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("input mismatch");
                        } catch (Exception e) {
                            System.out.println("Exception occurred : " + e.getMessage());
                        } finally {
                            scInt.nextLine();
                        }
                        subMenuPelanggan(pilSubMenu);
                    }
                    break;
                case 4:
                    pilSubMenu = -1;
                    while (pilSubMenu != 0) {
                        System.out.println(printPerjalanan());
                        System.out.println("- Kelola Perjalanan -\n1. Add\n"
                                + "2. Remove\n0. Back\nPilihan: ");
                        try {
                            pilSubMenu = scInt.nextInt();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("input mismatch");
                        } catch (Exception e) {
                            System.out.println("Exception occurred : " + e.getMessage());
                        } finally {
                            scInt.nextLine();
                        }
                        subMenuPerjalanan(pilSubMenu);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Input tidak valid.\n");
            }
        }
    }
    
    
    private void subMenuTempatWisata(int pilSubMenu) {
        Scanner scLong = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        boolean lanjutInput, hapus;
        long idTempat;
        String namaTempat, deskripsiTempat;
        
        switch (pilSubMenu) {
            case 1:
                System.out.print("\n- Registrasi Tempat Wisata -\n");
                try {
                    idTempat = incrementId(2);
                    System.out.println("ID : " + idTempat);
                    System.out.print("Nama Tempat Wisata : ");
                    namaTempat = scString.nextLine();
                    System.out.print("Deskripsi : ");
                    deskripsiTempat = scString.nextLine();
                    createTempatWisata(idTempat, namaTempat, deskripsiTempat);
                    System.out.println("\'Registrasi selesai\'");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("input mismatch");
                    System.out.println("\'Registrasi dibatalkan\'");
                } catch (Exception e) {
                    System.out.println("Exception occurred : " + e.getMessage());
                    System.out.println("\'Registrasi dibatalkan\'");
                }
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
                    System.out.println("Exception occurred : " + e.getMessage());
                    lanjutInput = false;
                } finally {
                    scLong.nextLine();
                }

                if (lanjutInput) {
                    try {
                        hapus = searchDeleteTempatWisata(idTempat);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        hapus = false;
                    }
                    if (hapus) {
                        System.out.println("\'Tempat Wisata " + idTempat + " terhapus\'");
                    } else {
                        System.out.println("\'Penghapusan dibatalkan\'");
                    }
                } else {
                    System.out.println("\'Penghapusan dibatalkan\'");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Pilihan tidak valid.\n");
        }
    }
    
    private void subMenuPaketWisata(int pilSubMenu) {
        Scanner scLong = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        boolean lanjutInput, hapus;
        long idPaket, idTempat, hargaPaket;
        String namaPaket;
        TempatWisata[] dtw;
        TempatWisata tw;
        int nTw;

        switch (pilSubMenu) {
            case 1:
                lanjutInput = true;
                idPaket = -1;
                idTempat = -2;
                namaPaket = " ";
                hargaPaket = -1;
                dtw = new TempatWisata[50];
                nTw = 0;

                System.out.print("\n- Tambah Paket Wisata -\n");
                idPaket = incrementId(3);
                System.out.println("ID : " + idPaket);
                
                if (lanjutInput) {
                    do {
                        System.out.println("\nPilih Tempat Wisata akan disimpan"
                                + " pada Paket-" + idPaket + " :");
                        System.out.println(printTempatWisata());
                        System.out.print("ID Tempat (-1 jika selesai memilih): ");
                        try {
                            idTempat = scLong.nextLong();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("input mismatch");
                        } catch (Exception e) {
                            System.out.println("Exception occurred : " + e.getMessage());
                        } finally {
                            scLong.nextLine();
                        }
                        if (idTempat != -1) {
                            boolean isSelected = false;
                            if (nTw != 0) {
                                for (int i=0; i<nTw; i++) {
                                    if (dtw[i].getIdTempat() == idTempat) {
                                        isSelected = true;
                                        System.out.println("\'idTempat sudah dipilih\'");
                                    }
                                }
                            }
                            if (!isSelected) {
                                tw = searchTempatWisata(idTempat);
                                if (tw != null) {
                                    dtw[nTw] = tw;
                                    nTw++;
                                } else {
                                    System.out.println("\'idTempat " + idTempat + " not found\'");
                                }
                            }    
                        } else {
                            System.out.println("\'Selesai memilih Tempat Wisata\'");
                        }
                    } while (idTempat != -1);

                    System.out.print("\nNama Paket Wisata : ");
                    try {
                        namaPaket = scString.nextLine();
                    } catch (Exception e) {
                        System.out.println("Exception occurred : " + e.getMessage());
                        lanjutInput = false;
                    }
                }

                if (lanjutInput) {
                    System.out.print("Harga Paket (Rp): ");
                    try {
                        hargaPaket = scLong.nextLong();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("input mismatch");
                        lanjutInput = false;
                    } catch (Exception e) {
                        System.out.println("Exception occurred : " + e.getMessage());
                        lanjutInput = false;
                    } finally {
                        scLong.nextLine();
                    }
                }

                if (lanjutInput) {
                    createPaketWisata(idPaket, namaPaket, hargaPaket, dtw);
                    System.out.println("\'Penambahan Paket selesai\'");
                } else {
                    System.out.println("\'Penambahan Paket dibatalkan\'");
                }
                break;

            case 2:
                lanjutInput = true;
                idPaket = -1;
                System.out.print("\nID Paket Wisata : ");

                try {
                    idPaket = scLong.nextLong();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("input mismatch");
                    lanjutInput = false;
                } catch (Exception e) {
                    System.out.println("Exception occurred : " + e.getMessage());
                    lanjutInput = false;
                } finally {
                    scLong.nextLine();
                }

                if (lanjutInput) {
                    try {
                        hapus = searchDeletePaketWisata(idPaket);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        hapus = false;
                    }
                    if (hapus) {
                        System.out.println("\'Paket Wisata " + idPaket + " terhapus\'");
                    } else {
                        System.out.println("\'Penghapusan dibatalkan\'");
                    }
                } else {
                    System.out.println("\'Penghapusan dibatalkan\'");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Pilihan tidak valid.\n");
        }
    }
    
    private void subMenuPelanggan(int pilSubMenu) {
        Scanner scLong = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        boolean lanjutInput, hapus;
        long idPelanggan, noKtp, noTelp;
        String nama, alamat, email;
        char jenisKelamin;
        int pilihJenisKelamin;
        
        switch (pilSubMenu) {
            case 1:
                    System.out.print("\n- Registrasi Pelangggan -\n");
                try {
                    idPelanggan = incrementId(4);
                    System.out.println("ID : " + idPelanggan);
                    System.out.print("Nama : ");
                    nama = scString.nextLine();
                    System.out.print("No KTP : ");
                    noKtp = scLong.nextLong();
                    scLong.nextLine();
                    System.out.print("Jenis Kelamin :\n(1) Laki-laki\n(2) Perempuan"
                            + "\nPilihan : ");
                    pilihJenisKelamin = scInt.nextInt();
                    switch (pilihJenisKelamin) {
                        case 1:
                            jenisKelamin = 'L';
                            break;
                        case 2:
                            jenisKelamin = 'P';
                            break;
                        default:
                            throw new RuntimeException("Pilihan tidak valid");
                    }
                    System.out.print("Alamat : ");
                    alamat = scString.nextLine();
                    System.out.print("E-mail : ");
                    email = scString.nextLine();
                    System.out.print("No Telp : ");
                    noTelp = scLong.nextLong();
                    createPelanggan(idPelanggan, nama, noKtp, jenisKelamin, alamat, email, noTelp);
                    System.out.println("\'Registrasi selesai\'");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("input mismatch");
                    System.out.println("\'Registrasi dibatalkan\'");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("\'Registrasi dibatalkan\'");
                } catch (Exception e) {
                    System.out.println("Exception occurred : " + e.getMessage());
                    System.out.println("\'Registrasi dibatalkan\'");
                } finally {
                    scLong.nextLine();
                    scInt.nextLine();
                }
                break;

            case 2:
                lanjutInput = true;
                idPelanggan = -1;
                System.out.print("\nID Pelanggan : ");

                try {
                    idPelanggan = scLong.nextLong();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("input mismatch");
                    lanjutInput = false;
                } catch (Exception e) {
                    System.out.println("Exception occurred : " + e.getMessage());
                    lanjutInput = false;
                } finally {
                    scLong.nextLine();
                }

                if (lanjutInput) {
                    try {
                        hapus = searchDeletePelanggan(idPelanggan);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        hapus = false;
                    }
                    if (hapus) {
                        System.out.println("\'Pelanggan " + idPelanggan + " terhapus\'");
                    } else {
                        System.out.println("\'Penghapusan dibatalkan\'");
                    }
                } else {
                    System.out.println("\'Penghapusan dibatalkan\'");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Pilihan tidak valid.\n");
        }
    }
    
    private void subMenuPerjalanan(int pilSubMenu) {
        Scanner scLong = new Scanner(System.in);
        boolean lanjutInput, hapus;
        long idPerjalanan, idPaket, idPelanggan;
        PaketWisata paket;
        Pelanggan[] dpg;
        Pelanggan pg;
        int nPg;
        
        switch (pilSubMenu) {
            case 1:
                lanjutInput = true;
                idPelanggan = -2;
                idPaket = -1;
                paket = null;
                dpg = new Pelanggan[100];
                nPg = 0;

                System.out.print("\n- Registrasi Perjalanan -\n");                    
                idPerjalanan = incrementId(5);
                System.out.println("ID : " + idPerjalanan);
                
                if (lanjutInput) {
                    System.out.println("\nPilih Paket Wisata akan didaftarkan"
                            + " pada Perjalanan-" + idPerjalanan + " :");
                    System.out.println(printPaketWisata());
                    System.out.print("ID Paket: ");
                    try {
                        idPaket = scLong.nextLong();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("input mismatch");
                        lanjutInput = false;
                    } catch (Exception e) {
                        System.out.println("Exception occurred : " + e.getMessage());
                        lanjutInput = false;
                    } finally {
                        scLong.nextLine();
                    }
                }
                
                if (lanjutInput) {
                    paket = searchPaketWisata(idPaket);
                    if (paket == null) {
                        System.out.println("\'idPaket " + idPaket + " not found\'");
                        lanjutInput =false;
                    }
                }
                
                if (lanjutInput) {
                    do {
                        System.out.println("\nPilih Pelanggan akan didaftarkan"
                                + " pada Perjalanan-" + idPerjalanan + " :");
                        System.out.println(printPelanggan());
                        System.out.print("ID Pelanggan (-1 jika selesai memilih): ");
                        try {
                            idPelanggan = scLong.nextLong();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("input mismatch");
                        } catch (Exception e) {
                            System.out.println("Exception occurred : " + e.getMessage());
                        } finally {
                            scLong.nextLine();
                        }
                        if (idPelanggan != -1) {
                            boolean isSelected = false;
                            if (nPg != 0) {
                                for (int i=0; i<nPg; i++) {
                                    if (dpg[i].getIdPelanggan() == idPelanggan) {
                                        isSelected = true;
                                        System.out.println("\'idPelanggan sudah dipilih\'");
                                    }
                                }
                            }
                            if (!isSelected) {
                                pg = searchPelanggan(idPelanggan);
                                if (pg != null) {
                                    dpg[nPg] = pg;
                                    nPg++;
                                } else {
                                    System.out.println("\'idPelanggan " + idPelanggan + " not found\'");
                                }
                            }    
                        } else {
                            System.out.println("\'Selesai memilih Pelanggan\'");
                        }
                    } while (idPelanggan != -1);
                }
                
                if (lanjutInput) {
                    createPerjalanan(idPerjalanan, paket, dpg);
                    System.out.println("\'Registrasi Perjalanan selesai\'");
                } else {
                    System.out.println("\'Registrasi Perjalanan dibatalkan\'");
                }
                break;

            case 2:
                lanjutInput = true;
                idPerjalanan = -1;
                System.out.print("\nID Perjalanan : ");

                try {
                    idPerjalanan = scLong.nextLong();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("input mismatch");
                    lanjutInput = false;
                } catch (Exception e) {
                    System.out.println("Exception occurred : " + e.getMessage());
                    lanjutInput = false;
                } finally {
                    scLong.nextLine();
                }

                if (lanjutInput) {
                    try {
                        hapus = searchDeletePerjalanan(idPerjalanan);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        hapus = false;
                    }
                    if (hapus) {
                        System.out.println("\'Perjalanan " + idPerjalanan + " terhapus\'");
                    } else {
                        System.out.println("\'Penghapusan dibatalkan\'");
                    }
                } else {
                    System.out.println("\'Penghapusan dibatalkan\'");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Pilihan tidak valid.\n");
        }
    }
    
    // createPetugas melakukan instansiasi dan insert objek ke dalam listPetugas 
    private void createPetugas(long idPegawai, String username, String password, String nama, long noKtp, char jenisKelamin,
    String alamat, String email, long noTelp) {
        boolean usernameExist = false;
        for (Petugas x : listPetugas) {
            if (x.getUsername().equals(username)) {
                usernameExist = true;
            }
        }
        if (usernameExist) {
            throw new RuntimeException("Username telah digunakan oleh ID lain");
        } else {
            Petugas pt = new Petugas(idPegawai, username, password, nama, noKtp, jenisKelamin, alamat, email, noTelp);
            listPetugas.add(pt);
        }
    }
    
    // createTempatWisata melakukan instansiasi dan insert objek ke dalam listTempatWisata 
    private void createTempatWisata(long idTempat, String namaTempat, String deskripsiTempat) {
        TempatWisata tw = new TempatWisata(idTempat, namaTempat, deskripsiTempat);
        try {
            listTempatWisata.add(tw);
        } catch(Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }        
    }
    
    /* createPaketWisata melakukan instansiasi, addPaketWisata, dan insert objek ke dalam listPaketWisata
       dtw adlh 'array of TempatWisata' yang sementara menampung kumpulan TempatWisata sebelum di add ke PaketWisata
       method ini akan satu per satu meng-add (menyalin) isi dari dtw ke objek PaketWisata */
    private void createPaketWisata(long idPaket, String namaPaket, float hargaPaket, TempatWisata[] dtw) {
        PaketWisata pw = new PaketWisata(idPaket, namaPaket, hargaPaket);
        int n = 0;
        while (n < dtw.length && dtw[n] != null) {
            pw.addTempatWisata(dtw[n]);
            n++;
        }
        try {
            listPaketWisata.add(pw);
        } catch(Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
    }
    
    // createPelanggan melakukan instansiasi dan insert objek ke dalam listPelanggan 
    private void createPelanggan(long idPelanggan, String nama, long noKtp, char jenisKelamin, String alamat, String email, long noTelp) {
        Pelanggan pg = new Pelanggan(idPelanggan, nama, noKtp, jenisKelamin, alamat, email, noTelp);
        try {
            listPelanggan.add(pg);
        } catch(Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }        
    }
    
    /* createPerjalanan melakukan instansiasi, addPelanggan, dan insert objek ke dalam listPaketWisata
       dpg adlh 'array of Pelanggan' yang sementara menampung kumpulan Pelanggan sebelum di add ke Perjalanan
       method ini akan satu per satu meng-add (menyalin) isi dari dpg ke objek Perjalanan */
    private void createPerjalanan(long idPerjalanan, PaketWisata paket, Pelanggan[] dpg) {
        Perjalanan pj = new Perjalanan(idPerjalanan);
        pj.setPaket(paket);
        int n = 0;
        while (n < dpg.length && dpg[n] != null) {
            pj.addPelanggan(dpg[n]);
            n++;
        }
        try {
            listPerjalanan.add(pj);
        } catch(Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
    }
    
    /* mencari dan menghapus Petugas dengan idPegawai x di dalam listPetugas
       mengeluarkan hasil true jika berhasil menghapus, mengeluarkan hasil false jika Petugas
       tidak ditemukan */
    private boolean searchDeletePetugas(long x) {
        boolean delete = false;
        Petugas y = searchPetugas(x);
        /* Antara proses mencari instance dengan menghapus instance perlu dipisah
           agar tidak terjadi Runtime Error */
        if (y != null) {
            try {
                delete = listPetugas.remove(y);
            } catch (Exception e) {
                System.out.println("Exception occurred : " + e.getMessage());
            }
        }
        else
            throw new RuntimeException("idPegawai " + x + " not found");        
        return delete;
    }
    
    /* mencari dan menghapus TempatWisata dengan idTempat x di dalam listTempatWisata
       mengeluarkan hasil true jika berhasil menghapus, mengeluarkan hasil false jika TempatWisata
       tidak ditemukan */
    private boolean searchDeleteTempatWisata(long x) {
        boolean delete = false;       
        TempatWisata y = searchTempatWisata(x);        
        /* Antara proses mencari instance dengan menghapus instance perlu dipisah
           agar tidak terjadi Runtime Error */
        if (y != null) {
            try {
                delete = listTempatWisata.remove(y);
            } catch (Exception e) {
                System.out.println("Exception occurred : " + e.getMessage());
            }
        }
        else
            throw new RuntimeException("idTempat " + x + " not found");        
        return delete;
    }
    
    /* mencari dan menghapus PaketWisata dengan idPaket x di dalam listPaketWisata
       mengeluarkan hasil true jika berhasil menghapus, mengeluarkan hasil false jika PaketWisata
       tidak ditemukan */
    private boolean searchDeletePaketWisata(long x) {
        boolean delete = false;        
        PaketWisata y = searchPaketWisata(x);
        /* Antara proses mencari instance dengan menghapus instance perlu dipisah
           agar tidak terjadi Runtime Error */
        if (y != null) {
            try {
                delete = listPaketWisata.remove(y);
            } catch (Exception e) {
                System.out.println("Exception occurred : " + e.getMessage());
            }
        }
        else
            throw new RuntimeException("idPaket " + x + " not found");        
        return delete;
    }
    
    /* mencari dan menghapus Pelanggan dengan idPelanggan x di dalam listPelanggan
       mengeluarkan hasil true jika berhasil menghapus, mengeluarkan hasil false jika Pelanggan
       tidak ditemukan */
    private boolean searchDeletePelanggan(long x) {
        boolean delete = false;
        Pelanggan y = searchPelanggan(x);
        /* Antara proses mencari instance dengan menghapus instance perlu dipisah
           agar tidak terjadi Runtime Error */
        if (y != null) {
            try {
                delete = listPelanggan.remove(y);
            } catch (Exception e) {
                System.out.println("Exception occurred : " + e.getMessage());
            }
        }
        else
            throw new RuntimeException("idPelanggan " + x + " not found");        
        return delete;
    }
    
    /* mencari dan menghapus Perjalanan dengan idPerjalanan x di dalam listPerjalanan
       mengeluarkan hasil true jika berhasil menghapus, mengeluarkan hasil false jika Pejalanan
       tidak ditemukan */
    private boolean searchDeletePerjalanan(long x) {
        boolean delete = false;
        Perjalanan y = searchPerjalanan(x);        
        /* Antara proses mencari instance dengan menghapus instance perlu dipisah
           agar tidak terjadi Runtime Error */
        if (y != null) {
            try {
                delete = listPerjalanan.remove(y);
            } catch (Exception e) {
                System.out.println("Exception occurred : " + e.getMessage());
            }
        }
        else
            throw new RuntimeException("idPerjalanan " + x + " not found");
        
        return delete;
    }
    
    /* mencari Petugas dengan idPegawai x di dalam listPetugas
       return object jika ditemukan dan return null jika tidak ditemukan */
    private Petugas searchPetugas(long x) {
        Petugas result = null;
        for (Petugas y : listPetugas) {
            if (y.getIdPegawai() == x) {
                result = y;
            }
        }
        return result;
    }
    
    /* mencari Petugas dengan username x di dalam listPetugas
       return object jika ditemukan dan return null jika tidak ditemukan */
    private Petugas searchPetugas(String x) {
        Petugas result = null;
        for (Petugas y : listPetugas) {
            if (y.getUsername().equals(x)) {
                result = y;
            }
        }
        return result;
    }
    
    /* mencari TempatWisata dengan idTempat x di dalam listPerjalanan
       return object jika ditemukan dan return null jika tidak ditemukan */
    private TempatWisata searchTempatWisata(long x) {
        TempatWisata result = null;
        for (TempatWisata y : listTempatWisata) {
            if (y.getIdTempat() == x) {
                result = y;
            }
        }
        return result;
    }
    
    /* mencari TempatWisata dengan idTempat x di dalam listPerjalanan
       return object jika ditemukan dan return null jika tidak ditemukan */
    private PaketWisata searchPaketWisata(long x) {
        PaketWisata result = null;
        for (PaketWisata y : listPaketWisata) {
            if (y.getIdPaket() == x) {
                result = y;
            }
        }
        return result;
    }
    
    /* mencari TempatWisata dengan idTempat x di dalam listPerjalanan
       return object jika ditemukan dan return null jika tidak ditemukan */
    private Pelanggan searchPelanggan(long x) {
        Pelanggan result = null;
        for (Pelanggan y : listPelanggan) {
            if (y.getIdPelanggan() == x) {
                result = y;
            }
        }
        return result;
    }
    
    /* mencari TempatWisata dengan idTempat x di dalam listPerjalanan
       return object jika ditemukan dan return null jika tidak ditemukan */
    private Perjalanan searchPerjalanan(long x) {
        Perjalanan result = null;
        for (Perjalanan y : listPerjalanan) {
            if (y.getIdPerjalanan() == x) {
                result = y;
            }
        }
        return result;
    }
    
    //print isi listPetugas
    private String printPetugas() {
        String printOut = "\n- List Petugas-\n";
        
        if (!listPetugas.isEmpty()) {
            for (int i = 0; i < listPetugas.size(); i++)
                printOut += ("\n" + (i + 1) + ": " + listPetugas.get(i).toString() + "\n");
        } else printOut += "\nList kosong.\n";
        
        return printOut;
    }
    
    //print isi listTempatWisata
    private String printTempatWisata() {
        String printOut = ("\n- List Tempat Wisata -\n");
        
        if (!listTempatWisata.isEmpty()) {
            for (int i = 0; i < listTempatWisata.size(); i++)
                printOut += ("\n" + (i + 1) + ": " + listTempatWisata.get(i).toString() + "\n");
        } else printOut += "\nList kosong.\n";
        
        return printOut;
    }
    
    //print isi listPaketWisata
    private String printPaketWisata() {
        String printOut = ("\n- List Paket Wisata -\n");
        
        if (!listPaketWisata.isEmpty()) {
            for (int i = 0; i < listPaketWisata.size(); i++)
                printOut += ("\n" + (i + 1) + ": " + listPaketWisata.get(i).toString() + "\n");
        } else printOut += "\nList kosong.\n";
        
        return printOut;
    }
    
    //print isi listPelanggan
    private String printPelanggan() {
        String printOut = "\n- List Pelanggan-\n";
        
        if (!listPelanggan.isEmpty()) {
            for (int i = 0; i < listPelanggan.size(); i++)
                printOut += ("\n" + (i + 1) + ": " + listPelanggan.get(i).toString() + "\n");
        } else printOut += "\nList kosong.\n";
        
        return printOut;
    }
    
    //print isi listPerjalanan
    private String printPerjalanan() {
        String printOut = "\n- List Perjalanan-\n";
        
        if (!listPerjalanan.isEmpty()) {
            for (int i = 0; i < listPerjalanan.size(); i++)
                printOut += ("\n" + (i + 1) + ": " + listPerjalanan.get(i).toString() + "\n");
        } else printOut += "\nList kosong.\n";
        
        return printOut;
    }

    private boolean login(String username, String password) {
        Petugas x = searchPetugas(username);
        if (x!=null) {
            if (x.getPassword().equals(password))
                return true;
            else
                return false;
        } else
            return false;
    }
    
    /* tipeData:
        (1) mengeluarkan increment dari idPegawai tertinggi
        (2) mengeluarkan increment dari idTempat tertinggi
        (3) mengeluarkan increment dari idPaket tertinggi
        (4) mengeluarkan increment dari idPelanggan tertinggi
        (5) mengeluarkan increment dari idPerjalanan tertinggi
       Format ID:
        idPegawai   : 1xxxxxxx    idTempat    : 2xxxxxxx
        idPaket     : 3xxxxxxx    idPelanggan : 4xxxxxxx
        idPerjalanan: 5xxxxxxx
    */ 
    private long incrementId(int tipeData){
        long id = 0;
        switch(tipeData) {
            case 1:
                id = 10000001;
                for (Petugas x : listPetugas) {
                    if (id <= x.getIdPegawai()) {
                        id = x.getIdPegawai() + 1;
                    }
                }
                break;
            case 2:
                id = 20000001;
                for (TempatWisata x : listTempatWisata) {
                    if (id <= x.getIdTempat()) {
                        id = x.getIdTempat() + 1;
                    }
                }
                break;
            case 3:
                id = 30000001;
                for (PaketWisata x : listPaketWisata) {
                    if (id <= x.getIdPaket()) {
                        id = x.getIdPaket() + 1;
                    }
                }
                break;
            case 4:
                id = 40000001;
                for (Pelanggan x : listPelanggan) {
                    if (id <= x.getIdPelanggan()) {
                        id = x.getIdPelanggan() + 1;
                    }
                }
                break;
            case 5:
                id = 50000001;
                for (Perjalanan x : listPerjalanan) {
                    if (id <= x.getIdPerjalanan()) {
                        id = x.getIdPerjalanan() + 1;
                    }
                }
                break;
        }
        return id;
    }
}