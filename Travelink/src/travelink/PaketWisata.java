package travelink;

public class PaketWisata {
    private TempatWisata[] daftarTujuanWisata;
    private long idPaket;
    private String namaPaket;
    private float hargaPaket;
    private int nTempatWisata = 0;
    private int maxTempatWisata;
    
    public PaketWisata(long idPaket, String namaPaket, float hargaPaket) {
        this.idPaket = idPaket;
        this.namaPaket = namaPaket;
        this.hargaPaket = hargaPaket;
        maxTempatWisata = 50;
        daftarTujuanWisata = new TempatWisata[maxTempatWisata];
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
        if(nTempatWisata<maxTempatWisata){
            this.daftarTujuanWisata[nTempatWisata] = w;
            nTempatWisata++;
        }
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