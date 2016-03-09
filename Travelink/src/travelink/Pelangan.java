/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelink;

/**
 *
 * @author TOSHIBA
 */
public class Pelangan extends Orang {
    private long idKTP;

    public Pelangan(long idKTP) {
        super(nama,noKtp,jenisKelamin,alamat,email,noTelp);
        this.idKTP = idKTP;
    }
    public long getIdKTP() {
        return idKTP;
    }

    public void setIdKTP(long idKTP) {
        this.idKTP = idKTP;
    }
}
