package travelink;

public class TempatWisata {
    private long idTempat;
    private String namaTempat;
    private String deskripsiTempat;

    public TempatWisata(long idTempat, String namaTempat, String deskripsiTempat) {
        this.idTempat = idTempat;
        this.namaTempat = namaTempat;
        this.deskripsiTempat = deskripsiTempat;
    }
    
    public void setIdTempat(long idTempat){
        this.idTempat = idTempat;
    }
    
    public void setNamaTempat(String namaTempat){
        this.namaTempat = namaTempat;
    }
    
    public long getIdTempat(){
        return idTempat;
    }
    
    public String getNamaTempat(){
        return namaTempat;
    }
   
    public void setDeskripsiTempat(String deskripsiTempat) {
        this.deskripsiTempat = deskripsiTempat;
    }

    public String getDeskripsiTempat() {
        return deskripsiTempat;
    }

    @Override
    public String toString() {
        return "ID : " + idTempat + ", Nama Tempat Wisata  : " + namaTempat + ", Deskripsi Tempat: " + deskripsiTempat;
    }
    
    
}
