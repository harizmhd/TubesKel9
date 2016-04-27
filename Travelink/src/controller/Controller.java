package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.*;
import view.*;

public class Controller extends MouseAdapter implements ActionListener {
    private Aplikasi model;
    private View view;
    private int selected;
    
    public Controller() {
        model = new Aplikasi();
        goToLogin();
    }
    
    public void goToLogin() {
        LoginPetugas login = new LoginPetugas();
        login.setVisible(true);
        login.addListener(this);
        view = login;
    }
    
    public void goToMainMenu() {
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        menu.addListener(this);
        view = menu;
    }
    
    public void goToRegistrasiPetugas() {
        RegistrasiPetugas regPetugas = new RegistrasiPetugas();
        regPetugas.setVisible(true);
        regPetugas.addListener(this);
        view = regPetugas;
    }
    
    public void goToRegistrasiTempatWisata() {
        RegistrasiTempatWisata regTemWisata = new RegistrasiTempatWisata();
        regTemWisata.setVisible(true);
        regTemWisata.addListener(this);
        view = regTemWisata;
    }
    
    public void goToRegistrasiPaketWisata() {
        RegistrasiPaketWisata regPakWisata = new RegistrasiPaketWisata();
        regPakWisata.setVisible(true);
        regPakWisata.addListener(this);
        regPakWisata.setTbTempatWisata(model.getListTempatWisata());
        view = regPakWisata;
    }
    
    public void goToRegistrasiPelanggan() {
        RegistrasiPelanggan regPelanggan = new RegistrasiPelanggan();
        regPelanggan.setVisible(true);
        regPelanggan.addListener(this);
        view = regPelanggan;
    }
    
    public void goToRegistrasiPerjalanan() {
        RegistrasiPerjalanan regPerjalanan = new RegistrasiPerjalanan();
        regPerjalanan.setVisible(true);
        regPerjalanan.addListener(this);
        regPerjalanan.setCbPaketWisata(model.getListPaketWisata());
        regPerjalanan.setTbPelanggan(model.getListPelanggan());
        view = regPerjalanan;
    }
    
    public void goToSubMenuTempatWisata() {
        SubMenuTempatWisata subTemWisata = new SubMenuTempatWisata();
        subTemWisata.setVisible(true);
        subTemWisata.addListener(this);
        subTemWisata.addAdapter(this);
        subTemWisata.viewAll(model.getListTempatWisata());
        view = subTemWisata;
        selected = -1;
    }
    
    public void goToSubMenuPaketWisata() {
        SubMenuPaketWisata subPakWisata = new SubMenuPaketWisata();
        subPakWisata.setVisible(true);
        subPakWisata.addListener(this);
        subPakWisata.addAdapter(this);
        subPakWisata.viewAll(model.getListPaketWisata());
        view = subPakWisata;
        selected = -1;
    }
    
    public void goToSubMenuPelanggan() {
        SubMenuPelanggan subPelanggan = new SubMenuPelanggan();
        subPelanggan.setVisible(true);
        subPelanggan.addListener(this);
        subPelanggan.addAdapter(this);
        subPelanggan.viewAll(model.getListPelanggan());
        view = subPelanggan;
        selected = -1;
    }
    
    public void goToSubMenuPerjalanan() {
        SubMenuPerjalanan subPerjalanan = new SubMenuPerjalanan();
        subPerjalanan.setVisible(true);
        subPerjalanan.addListener(this);
        subPerjalanan.addAdapter(this);
        subPerjalanan.viewAll(model.getListPerjalanan());
        view = subPerjalanan;
        selected = -1;
    }
    
    public void goToDeleteTempatWisata() {
        DeleteTempatWisata delTemWisata = new DeleteTempatWisata();
        delTemWisata.setVisible(true);
        delTemWisata.addListener(this);
        view = delTemWisata;
    }
    
    public void goToDeletePaketWisata() {
        DeletePaketWisata delPakWisata = new DeletePaketWisata();
        delPakWisata.setVisible(true);
        delPakWisata.addListener(this);
        view = delPakWisata;
    }
    
    public void goToDeletePelanggan() {
        DeletePelanggan delPelanggan = new DeletePelanggan();
        delPelanggan.setVisible(true);
        delPelanggan.addListener(this);
        view = delPelanggan;
    }
    
    public void goToDeletePerjalanan() {
        DeletePerjalanan delPerjalanan = new DeletePerjalanan();
        delPerjalanan.setVisible(true);
        delPerjalanan.addListener(this);
        view = delPerjalanan;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (view instanceof LoginPetugas) {
            LoginPetugas log = (LoginPetugas) view;
            if (source.equals(log.getBtnExit())) {
                JOptionPane.showMessageDialog(null, "Thank You");
                System.exit(0);
            } else if (source.equals(log.getBtnSignIn())) {
                try{
                    String username = log.getTextUsername();
                    String password = log.getTextPassword();
                    boolean hakAkses = model.login(username, password);
                    if (!hakAkses) {
                        JOptionPane.showMessageDialog(null, "Username atau Passowrd yang dimasukkan salah");
                    } else {
                        goToMainMenu();
                        log.dispose();
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (source.equals(log.getBtnSignUp())) {
                goToRegistrasiPetugas();
                log.dispose();
            }
        } else if (view instanceof MainMenu) {
            MainMenu menu = (MainMenu) view;
            if (source.equals(menu.getBtnTempatWisata())) {
                goToSubMenuTempatWisata();
                menu.dispose();
            } else if (source.equals(menu.getBtnPaketWisata())) {
                goToSubMenuPaketWisata();
                menu.dispose();
            } else if (source.equals(menu.getBtnPelanggan())) {
                goToSubMenuPelanggan();
                menu.dispose();
            } else if (source.equals(menu.getBtnPerjalanan())) {
                goToSubMenuPerjalanan();
                menu.dispose();
            } else if (source.equals(menu.getBtnSignOut())) {
                int pilihan = JOptionPane.showConfirmDialog(null, "Keluar?");
                if (pilihan == JOptionPane.YES_OPTION) {
                    goToLogin();
                    menu.dispose();
                }
            }
        } else if (view instanceof SubMenuTempatWisata) {
            SubMenuTempatWisata submenu = (SubMenuTempatWisata) view;
            if (source.equals(submenu.getBtnAdd())) {
                goToRegistrasiTempatWisata();
                submenu.dispose();
            } else if (source.equals(submenu.getBtnBack())) {
                goToMainMenu();
                submenu.dispose();
            } else if (source.equals(submenu.getBtnDelete())) {
                try {
                    selected = submenu.getSelectedTempatWisata();
                    TempatWisata x = model.getListTempatWisata().get(selected);
                    int pilihan = JOptionPane.showConfirmDialog(null, "Hapus "
                            + x.getNamaTempat() + "?");
                    if (pilihan == JOptionPane.YES_OPTION) {
                        boolean isDeleted = model.deleteTempatWisata(x);
                        if (isDeleted) {
                            JOptionPane.showMessageDialog(null, "Tempat Wisata"
                                    + " berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Tempat Wisata"
                                    + " gagal dihapus.");
                        }
                    }
                } catch (IllegalStateException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } finally {
                    submenu.dispose();
                    goToSubMenuTempatWisata();
                }
            }
        } else if (view instanceof SubMenuPaketWisata) {
            SubMenuPaketWisata submenu = (SubMenuPaketWisata) view;
            if (source.equals(submenu.getBtnAdd())) {
                goToRegistrasiPaketWisata();
                submenu.dispose();
            } else if (source.equals(submenu.getBtnBack())) {
                goToMainMenu();
                submenu.dispose();
            } else if (source.equals(submenu.getBtnDelete())) {
                try {
                    selected = submenu.getSelectedPaketWisata();
                    PaketWisata x = model.getListPaketWisata().get(selected);
                    int pilihan = JOptionPane.showConfirmDialog(null, "Hapus "
                            + x.getNamaPaket() + "?");
                    if (pilihan == JOptionPane.YES_OPTION) {
                        boolean isDeleted = model.deletePaketWisata(x);
                        if (isDeleted) {
                            JOptionPane.showMessageDialog(null, "Tempat Wisata"
                                    + " berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Tempat Wisata"
                                    + " gagal dihapus.");
                        }
                    }
                } catch (IllegalStateException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } finally {
                    submenu.dispose();
                    goToSubMenuPaketWisata();
                }
            }
        } else if (view instanceof SubMenuPelanggan) {
            SubMenuPelanggan submenu = (SubMenuPelanggan) view;
            if (source.equals(submenu.getBtnAdd())) {
                goToRegistrasiPelanggan();
                submenu.dispose();
            } else if (source.equals(submenu.getBtnBack())) {
                goToMainMenu();
                submenu.dispose();
            } else if (source.equals(submenu.getBtnDelete())) {
                try {
                    selected = submenu.getSelectedPelanggan();
                    Pelanggan x = model.getListPelanggan().get(selected);
                    int pilihan = JOptionPane.showConfirmDialog(null, "Hapus "
                            + x.getNama() + "?");
                    if (pilihan == JOptionPane.YES_OPTION) {
                        boolean isDeleted = model.deletePelanggan(x);
                        if (isDeleted) {
                            JOptionPane.showMessageDialog(null, "Data pelanggan"
                                    + " berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Data pelanggan"
                                    + " gagal dihapus.");
                        }
                    }
                } catch (IllegalStateException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } finally {
                    submenu.dispose();
                    goToSubMenuPelanggan();
                }
            }
        } else if (view instanceof SubMenuPerjalanan) {
            SubMenuPerjalanan submenu = (SubMenuPerjalanan) view;
            if (source.equals(submenu.getBtnAdd())) {
                goToRegistrasiPerjalanan();
                submenu.dispose();
            } else if (source.equals(submenu.getBtnBack())) {
                goToMainMenu();
                submenu.dispose();
            } else if (source.equals(submenu.getBtnDelete())) {
                try {
                    selected = submenu.getSelectedPerjalanan();
                    Perjalanan x = model.getListPerjalanan().get(selected);
                    int pilihan = JOptionPane.showConfirmDialog(null, "Hapus "
                            + "data pejalanan?");
                    if (pilihan == JOptionPane.YES_OPTION) {
                        boolean isDeleted = model.deletePerjalanan(x);
                        if (isDeleted) {
                            JOptionPane.showMessageDialog(null, "Data perjalanan"
                                    + " berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Data perjalanan"
                                    + " gagal dihapus.");
                        }
                    }
                } catch (IllegalStateException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } finally {
                    submenu.dispose();
                    goToSubMenuPerjalanan();
                }
            }
        } else if (view instanceof RegistrasiPetugas) {
            RegistrasiPetugas registrasi = (RegistrasiPetugas) view;
            if (source.equals(registrasi.getBtnBack())) {
                goToLogin();
                registrasi.dispose();
            } else if (source.equals(registrasi.getBtnSubmit())) {
                try{
                    String username = registrasi.getUsername();
                    String password1 = registrasi.getPassword1();
                    String password2 = registrasi.getPassword2();
                    if (!password1.equals(password2))
                            throw new RuntimeException("Password yang dimasukkan tidak sama");
                    long idPegawai = model.incrementId(1);
                    String nama = registrasi.getNama();
                    long noKtp = registrasi.getNoKtp();
                    char jenisKelamin = registrasi.getJenisKelamin();
                    String alamat = registrasi.getAlamat();
                    String email = registrasi.getEmail();
                    long noTelp = registrasi.getNoTelp();
                    model.createPetugas(idPegawai, username, password1, nama, noKtp, jenisKelamin, alamat, email, noTelp);
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(),
                            "Tidak dapat menyimpan data", JOptionPane.ERROR_MESSAGE);
                } catch (RuntimeException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(),
                            "Tidak dapat menyimpan data", JOptionPane.ERROR_MESSAGE);
                } finally{
                    registrasi.dispose();
                    goToLogin();
                }
            }
        } else if (view instanceof RegistrasiTempatWisata) {
            RegistrasiTempatWisata registrasi = (RegistrasiTempatWisata) view;
            if (source.equals(registrasi.getBtnBack())) {
                goToSubMenuTempatWisata();
                registrasi.dispose();
            } else if (source.equals(registrasi.getBtnSimpan())) {
                try {
                    long idTempat = model.incrementId(2);
                    String namaTempat = registrasi.getNamaTempat();
                    String deskripsiTempat = registrasi.getDeskripsi();
                    model.createTempatWisata(idTempat, namaTempat, deskripsiTempat);
                } catch (java.util.InputMismatchException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), 
                            "Tidak dapat menyimpan data", JOptionPane.ERROR_MESSAGE);
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(),
                            "Tidak dapat menyimpan data", JOptionPane.ERROR_MESSAGE);
                } finally {
                    registrasi.dispose();
                    goToSubMenuTempatWisata();
                }
            }
        } else if (view instanceof RegistrasiPaketWisata) {
            RegistrasiPaketWisata registrasi = (RegistrasiPaketWisata) view;
            if (source.equals(registrasi.getBtnBack())) {
                goToSubMenuPaketWisata();
                registrasi.dispose();
            } else if (source.equals(registrasi.getBtnSubmit())) {
                try {
                    long idPaket = model.incrementId(3);
                    String namaPaket = registrasi.getNamaPaket();
                    long hargaPaket = registrasi.getHarga();
                    boolean[] listSelected = registrasi.getListSelected();
                    ArrayList<TempatWisata> listTempatWisata = new ArrayList<>();
                    for (int i=0; i<listSelected.length; i++) {
                        if (listSelected[i] == true) {
                            listTempatWisata.add(model.getListTempatWisata().get(i));
                        }
                    }
                    if (listTempatWisata.isEmpty()) {
                        throw new IllegalStateException("Pilih minimal satu pelanggan");
                    }
                    TempatWisata[] dtw = new TempatWisata[listTempatWisata.size()];
                    for (int i=0; i<dtw.length; i++) {
                        dtw[i] = listTempatWisata.get(i);
                    }                    
                    model.createPaketWisata(idPaket, namaPaket, hargaPaket, (TempatWisata[])dtw);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), 
                            "Tidak dapat menyimpan data", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalStateException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), 
                            "Tidak dapat menyimpan data", JOptionPane.ERROR_MESSAGE);
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(),
                            "Tidak dapat menyimpan data", JOptionPane.ERROR_MESSAGE);
                } finally {
                    registrasi.dispose();
                    goToSubMenuPaketWisata();
                }
            }
        } else if (view instanceof RegistrasiPelanggan) {
            RegistrasiPelanggan registrasi = (RegistrasiPelanggan) view;
            if (source.equals(registrasi.getBtnBack())) {
                goToSubMenuPelanggan();
                registrasi.dispose();
            } else if (source.equals(registrasi.getBtnSubmit())) {
                try {
                    long idPelanggan = model.incrementId(4);
                    String nama = registrasi.getNama();
                    long noKtp = registrasi.getNoKtp();
                    char jenisKelamin = registrasi.getJenisKelamin();
                    String alamat = registrasi.getAlamat();
                    String email = registrasi.getEmail();
                    long noTelp = registrasi.getNoTelp();
                    model.createPelanggan(idPelanggan, nama, noKtp, jenisKelamin, alamat, email, noTelp);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), 
                            "Tidak dapat menyimpan data", JOptionPane.ERROR_MESSAGE);
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(),
                            "Tidak dapat menyimpan data", JOptionPane.ERROR_MESSAGE);
                } finally {
                    registrasi.dispose();
                    goToSubMenuPelanggan();
                }
            }
        } else if (view instanceof RegistrasiPerjalanan) {
            RegistrasiPerjalanan registrasi = (RegistrasiPerjalanan) view;
            if (source.equals(registrasi.getBtnBack())) {
                goToSubMenuPerjalanan();
                registrasi.dispose();
            } else if (source.equals(registrasi.getBtnSubmit())) {
                try {
                    long idPerjalanan = model.incrementId(5);
                    selected = registrasi.getSelectedPaketWisata();
                    PaketWisata paket = model.getListPaketWisata().get(selected);
                    boolean listSelected[] = registrasi.getListSelected();
                    ArrayList<Pelanggan> listPelanggan = new ArrayList<>();
                    for (int i=0; i<listSelected.length; i++) {
                        if (listSelected[i] == true) {
                            listPelanggan.add(model.getListPelanggan().get(i));
                        }
                    }
                    if (listPelanggan.isEmpty()) {
                        throw new IllegalStateException("Pilih minimal satu pelanggan");
                    }
                    Pelanggan[] dpg = new Pelanggan[listPelanggan.size()];
                    for (int i=0; i<dpg.length; i++) {
                        dpg[i] = listPelanggan.get(i);
                    }  
                    model.createPerjalanan(idPerjalanan, paket, (Pelanggan[])dpg);
                } catch (IllegalStateException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), 
                            "Tidak dapat menyimpan data", JOptionPane.ERROR_MESSAGE);
                } finally {
                    registrasi.dispose();
                    goToSubMenuPerjalanan();
                }
            }
        } else if (view instanceof DeleteTempatWisata) {
            DeleteTempatWisata delete = (DeleteTempatWisata) view;
            if (source.equals(delete.getBtnBack())) {
                goToSubMenuTempatWisata();
                delete.dispose();
            } else if (source.equals(delete.getBtnDelete())) {
                
            }
        } else if (view instanceof DeletePaketWisata) {
            DeletePaketWisata delete = (DeletePaketWisata) view;
            if (source.equals(delete.getBtnBack())) {
                goToSubMenuPaketWisata();
                delete.dispose();
            } else if (source.equals(delete.getBtnDelete())) {
                
            }
        } else if (view instanceof DeletePelanggan) {
            DeletePelanggan delete = (DeletePelanggan) view;
            if (source.equals(delete.getBtnBack())) {
                goToSubMenuPelanggan();
                delete.dispose();
            } else if (source.equals(delete.getBtnDelete())) {
                
            }
        } else if (view instanceof DeletePerjalanan) {
            DeletePerjalanan delete = (DeletePerjalanan) view;
            if (source.equals(delete.getBtnBack())) {
                goToSubMenuPerjalanan();
                delete.dispose();
            } else if (source.equals(delete.getBtnDelete())) {
                
            }
        }
    }
    
    public void MouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (view instanceof SubMenuPaketWisata) {
            SubMenuPaketWisata x = (SubMenuPaketWisata) view;
            if (source.equals(x.getTbPaketWisata())) {
                selected = x.getSelectedPaketWisata();
                PaketWisata pw = model.getListPaketWisata().get(selected);
                String keterangan = "Tujuan Wisata yang terdaftar: \n";
                for (int i = 0; i < pw.getnTempatWisata(); i++) {
                    if (i == 0) {
                        keterangan += pw.getDaftarTujuanWisata()[i].getNamaTempat();
                    } else {
                        keterangan += ", " + pw.getDaftarTujuanWisata()[i].getNamaTempat();
                    }
                }
                x.setKeterangan(keterangan);
            }
        } else if (view instanceof SubMenuPerjalanan) {
            SubMenuPerjalanan y = (SubMenuPerjalanan) view;
            if (source.equals(y.getTbPerjalanan())) {
                selected = y.getSelectedPerjalanan();
                Perjalanan pj = model.getListPerjalanan().get(selected);
                String keterangan = "Pelanggan yang terdaftar: \n";
                for (int i = 0; i < pj.getnPelanggan(); i++) {
                    if (i == 0) {
                        keterangan += pj.getPelanggan()[i].getNama();
                    } else {
                        keterangan += ", " + pj.getPelanggan()[i].getNama();
                    }
                }
                y.setKeterangan(keterangan);
            }
        }
    }
}
