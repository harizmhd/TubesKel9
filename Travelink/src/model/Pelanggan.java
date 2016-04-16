
package model;

public class Pelanggan extends Orang {
    private long idPelanggan;

    public Pelanggan(long idPelanggan, String nama, long noKtp) {
        super(nama, noKtp);
        this.idPelanggan = idPelanggan;
    }

    public Pelanggan(long idPelanggan, String nama, long noKtp, char jenisKelamin, String alamat, String email, long noTelp) {
        super(nama, noKtp, jenisKelamin, alamat, email, noTelp);
        this.idPelanggan = idPelanggan;
    }

    public long getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(long idKTP) {
        this.idPelanggan = idKTP;
    }

    @Override
    public String toString() {
        return "ID: " + idPelanggan + super.toString();
    }
}
