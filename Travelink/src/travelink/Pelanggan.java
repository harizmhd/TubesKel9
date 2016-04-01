
package travelink;

class Pelanggan extends Orang {
    private long idPelanggan;

    public Pelanggan(long idKTP, String nama, long noKtp) {
        super(nama, noKtp);
        this.idPelanggan = idKTP;
    }

    public Pelanggan(long idKTP, String nama, long noKtp, char jenisKelamin, String alamat, String email, long noTelp) {
        super(nama, noKtp, jenisKelamin, alamat, email, noTelp);
        this.idPelanggan = idKTP;
    }

    public long getIdKTP() {
        return idPelanggan;
    }

    public void setIdKTP(long idKTP) {
        this.idPelanggan = idKTP;
    }

    @Override
    public String toString() {
        return "ID: " + idPelanggan + super.toString();
    }
}
