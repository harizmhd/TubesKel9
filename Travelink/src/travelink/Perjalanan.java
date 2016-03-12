
package travelink;

public class Perjalanan {
    private Pelanggan[] pelanggan;
    private int nPelanggan = 0;
    private int maxPelanggan;
    private PaketWisata paket;
    private long idPerjalanan;
    private long idPelanggan;
    
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
    public void setIdPelanggan(long idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    public long getIdPelanggan() {
        return idPelanggan;
    }  

    public void setIdPerjalanan(long idPerjalanan) {
        this.idPerjalanan = idPerjalanan;
    }

    public long getIdPerjalanan() {
        return idPerjalanan;
    }
    
}
