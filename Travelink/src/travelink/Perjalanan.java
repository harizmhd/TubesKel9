
package travelink;

public class Perjalanan {
    private Pelanggan[] pelanggan;
    private int nPelanggan = 0;
    private int maxPelanggan;
    private PaketWisata[] paket;
    private long idPerjalanan;
    private long idPelanggan;
    private int nPaket = 0;
    
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
       if(nPaket<15){
           this.paket[nPaket] = paket;
           nPaket++;
       }
    }
    public void setIdPelanggan(long idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    public long getIdPelanggan() {
        return idPelanggan;
    }   
}