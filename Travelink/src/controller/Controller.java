package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.*;
import view.*;

public class Controller extends MouseAdapter implements ActionListener, ListSelectionListener {
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
        regPakWisata.addListSelectionListener(this);
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
        view = regPerjalanan;
    }
    
    public void goToRegistrasiPerjalananNext() {
        RegistrasiPerjalananNext regPerjalananNxt = new RegistrasiPerjalananNext();
        regPerjalananNxt.setVisible(true);
        regPerjalananNxt.addListener(this);
        view = regPerjalananNxt;
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
            LoginPetugas login = (LoginPetugas) view;
            if (source.equals(login.getBtnExit())) {
                JOptionPane.showMessageDialog(null, "Thank You");
                System.exit(0);
            } else if (source.equals(login.getBtnSignIn())) {
                //temporary
                goToMainMenu();
                login.dispose();
            } else if (source.equals(login.getBtnSignUp())) {
                goToRegistrasiPetugas();
                login.dispose();
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
                JOptionPane.showMessageDialog(null, "Thank You");
                System.exit(0);
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
                if (selected == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin"
                    + "dihapus.");
                } else {
                    TempatWisata x = model.getListTempatWisata().get(selected);
                    int pilihan = JOptionPane.showConfirmDialog(null, "Hapus "
                        + x.getNamaTempat() + "?");
                    if (pilihan == 1) {
                        boolean isDeleted = model.deleteTempatWisata(x);
                        if (isDeleted) {
                            JOptionPane.showMessageDialog(null, "Tempat wisata "
                                    + "berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Tempat wisata "
                                    + "gagal dihapus.");
                        }
                    }
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
                if (selected == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin"
                    + "dihapus.");
                } else {
                    PaketWisata x = model.getListPaketWisata().get(selected);
                    int pilihan = JOptionPane.showConfirmDialog(null, "Hapus "
                        + x.getNamaPaket() + "?");
                    if (pilihan == 1) {
                        boolean isDeleted = model.deletePaketWisata(x);
                        if (isDeleted) {
                            JOptionPane.showMessageDialog(null, "Paket wisata "
                                    + "berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Paket wisata "
                                    + "gagal dihapus.");
                        }
                    }
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
                    if (pilihan == 1) {
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
                if (selected == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin"
                    + " dihapus.");
                } else {
                    Perjalanan x = model.getListPerjalanan().get(selected);
                    int pilihan = JOptionPane.showConfirmDialog(null, "Hapus?");
                    if (pilihan == 1) {
                        boolean isDeleted = model.deletePerjalanan(x);
                        if (isDeleted) {
                            JOptionPane.showMessageDialog(null, "Data perjalanan"
                                    + " berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Data perjalanan"
                                    + " gagal dihapus.");
                        }
                    }
                }
            }
        } else if (view instanceof RegistrasiPetugas) {
            RegistrasiPetugas registrasi = (RegistrasiPetugas) view;
            if (source.equals(registrasi.getBtnBack())) {
                goToLogin();
                registrasi.dispose();
            } else if (source.equals(registrasi.getBtnSubmit())) {
                
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
                
            } else if (source.equals(registrasi.getBtnAdd())) {
                
            } else if (source.equals(registrasi.getBtnRemove())) {
                
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
                
            }
        } else if (view instanceof RegistrasiPerjalananNext) {
            RegistrasiPerjalananNext registrasi = (RegistrasiPerjalananNext) view;
            if (source.equals(registrasi.getBtnBack())) {
                goToRegistrasiPerjalanan();
                registrasi.dispose();
            } else if (source.equals(registrasi.getBtnSubmit())) {
                
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

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
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
