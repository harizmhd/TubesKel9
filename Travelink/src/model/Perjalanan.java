
package model;

public class Perjalanan {
    private Pelanggan[] pelanggan;
    private int nPelanggan = 0;
    private int maxPelanggan;
    private PaketWisata paket;
    private long idPerjalanan;
    
    public Perjalanan(long idPerjalanan){
        this.idPerjalanan=idPerjalanan;
        maxPelanggan = 100;
        pelanggan=new Pelanggan[maxPelanggan];
    }
    
    public void addPelanggan(Pelanggan p){
        if(nPelanggan<maxPelanggan){
            this.pelanggan[nPelanggan] = p;
            nPelanggan++;
        }
    }
    
    public void setPaket(PaketWisata paket) {
        this.paket = paket;
    }

    public void setIdPerjalanan(long idPerjalanan) {
        this.idPerjalanan = idPerjalanan;
    }

    public long getIdPerjalanan() {
        return idPerjalanan;
    }

    @Override
    public String toString() {
        String daftarPelanggan = " ";
        for (int i=0; i<nPelanggan; i++) {
            if (i==0)
                daftarPelanggan += pelanggan[i].getNama();
            else
                daftarPelanggan += ", " + pelanggan[i].getNama();
        }
        return "ID: " + idPerjalanan + ", paket=" + paket.getNamaPaket() +
                ", Pelanggan:" + daftarPelanggan;
    }
}
