package travelink;

public class Petugas extends Orang {
    private long idPegawai;
    private String username;
    private String password;

    public Petugas(long idPegawai, String username, String password, String nama, long noKtp) {
        super(nama, noKtp);
        this.idPegawai = idPegawai;
        this.username = username;
        this.password = password;
    }

    public Petugas(long idPegawai, String username, String password, String nama, long noKtp, char jenisKelamin,
    String alamat, String email, long noTelp) {
        super(nama, noKtp, jenisKelamin, alamat, email, noTelp);
        this.idPegawai = idPegawai;
        this.username = username;
        this.password = password;
    }

    public void setIdPegawai(long idPegawai) {
        this.idPegawai = idPegawai;
    }

    public long getIdPegawai() {
        return idPegawai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Username: " + username + ", ID Pegawai: " + idPegawai + ", Nama: " + super.getNama();
    }
}
