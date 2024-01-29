package entity;

public class PelangganEntity {
    private String namaPelanggan;
    private String nik;
    private String alamat;
    private String noTelp;

    public PelangganEntity(String namaPelanggan, String nik, String alamat, String noTelp) {
        this.namaPelanggan = namaPelanggan;
        this.nik = nik;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNoKamar() {
        return null;
    }

    public String getJenisPembayaran() {
        return null;
    }
}
