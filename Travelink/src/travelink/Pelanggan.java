
package travelink;

class Pelanggan extends Orang {
    private long idKTP;

    public Pelanggan(long idKTP, String nama, long noKtp) {
        super(nama, noKtp);
        this.idKTP = idKTP;
    }

    public Pelanggan(long idKTP, String nama, long noKtp, char jenisKelamin, String alamat, String email, long noTelp) {
        super(nama, noKtp, jenisKelamin, alamat, email, noTelp);
        this.idKTP = idKTP;
    }

    public long getIdKTP() {
        return idKTP;
    }

    public void setIdKTP(long idKTP) {
        this.idKTP = idKTP;
    }
    
    
}
