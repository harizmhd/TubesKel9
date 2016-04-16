package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.*;
import view.*;

public class Controller implements ActionListener, ListSelectionListener {
    private Aplikasi model;
    private View view;
    
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
        view = subTemWisata;
    }
    
    public void goToSubMenuPaketWisata() {
        SubMenuPaketWisata subPakWisata = new SubMenuPaketWisata();
        subPakWisata.setVisible(true);
        subPakWisata.addListener(this);
        view = subPakWisata;
    }
    
    public void goToSubMenuPelanggan() {
        SubMenuPelanggan subPelanggan = new SubMenuPelanggan();
        subPelanggan.setVisible(true);
        subPelanggan.addListener(this);
        view = subPelanggan;
    }
    
    public void goToSubMenuPerjalanan() {
        SubMenuTempatWisata subTemWisata = new SubMenuTempatWisata();
        subTemWisata.setVisible(true);
        subTemWisata.addListener(this);
        view = subTemWisata;
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
                goToDeleteTempatWisata();
                submenu.dispose();
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
                goToDeletePaketWisata();
                submenu.dispose();
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
                goToDeletePelanggan();
                submenu.dispose();
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
                goToDeletePerjalanan();
                submenu.dispose();
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
}
