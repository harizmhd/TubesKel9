package travelink;

public class Petugas extends Orang {
    private long idPegawai;

    public Petugas(long idPegawai, String nama, long noKtp) {
        super(nama, noKtp);
        this.idPegawai = idPegawai;
    }

    public Petugas(long idPegawai, String nama, long noKtp, char jenisKelamin,
    String alamat, String email, long noTelp) {
        super(nama, noKtp, jenisKelamin, alamat, email, noTelp);
        this.idPegawai = idPegawai;
    }

    public void setIdPegawai(long idPegawai) {
        this.idPegawai = idPegawai;
    }

    public long getIdPegawai() {
        return idPegawai;
    }
}
