/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelink;

/**
 *
 * @author TOSHIBA
 */
public class Perjalanan {
    private Pelanggan[] pelanggan;
    private int nPelanggan = 0;
    private int maxPelanggan;
    private PaketWisata paket = new PaketWisata();
    private long idPerjalanan;
    
    public Perjalanan(long idPerjalanan){
        this.idPerjalanan=idPerjalanan;
        pelanggan=new Pelanggan[100];
        maxPelanggan = 5;
    }
    public void addPelanggan(Pelanggan p){
        if(nPelanggan<maxPelanggan){
            this.pelanggan[nPelanggan] = p;
            nPelanggan++;
        }
    }
    public void setPaket(PaketWisata paket) {
       
    }
    public void setIdPelanggan(long idPelanggan){
        
    }
    public idPelanggan getIdPelanggan(){
        return 
    }
}
