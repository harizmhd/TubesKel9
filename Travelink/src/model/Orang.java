package model;

public abstract class Orang {
    private String nama;
    private long noKtp;
    private char jenisKelamin;
    private String alamat;
    private String email;
    private long noTelp;
    
    public Orang(String nama, long noKtp) {
        this.nama = nama;
        this.noKtp = noKtp;
    }

    public Orang(String nama, long noKtp, char jenisKelamin, String alamat,
        String email, long noTelp) {
        this.nama = nama;
        this.noKtp = noKtp;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.email = email;
        this.noTelp = noTelp;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setnoKtp(long noKtp){
        this.noKtp = noKtp;
    }
    
    public long getNoKtp() {
        return noKtp;
    }
    
    public void setJenisKelamin(char jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
    public char getJenisKelamin() {
        return jenisKelamin;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setNoTelp(long noTelp) {
        this.noTelp = noTelp;
    }
    
    public long getNoTelp() {
        return noTelp;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", No KTP: " + noKtp + ", J Kelamin: " + jenisKelamin + ", Alamat: " + alamat + ", E-mail: " + email + ", Telp: " + noTelp;
    }
}