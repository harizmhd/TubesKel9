package travelink;

public class PaketWisata {
    private TempatWisata[] daftarTujuanWisata = new TempatWisata[10];
    private long idPaket;
    private String namaPaket;
    private float hargaPaket;
    private int jmlTempatWisata = 0;
    private String hapusVariabelIni;
    
    public PaketWisata(long idPaket, String namaPaket, float hargaPaket) {
        this.idPaket = idPaket;
        this.namaPaket = namaPaket;
        this.hargaPaket = hargaPaket;
    }

    public void setIdPaket(long idPaket) {
        this.idPaket = idPaket;
    }

    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }

    public void setHargaPaket(float hargaPaket) {
        this.hargaPaket = hargaPaket;
    }
    
    public void addTempatWisata(TempatWisata w){
        this.daftarTujuanWisata[jmlTempatWisata] = w;
        jmlTempatWisata++;
    }

    public long getIdPaket() {
        return idPaket;
    }

    public String getNamaPaket() {
        return namaPaket;
    }

    public float getHargaPaket() {
        return hargaPaket;
    }
}
