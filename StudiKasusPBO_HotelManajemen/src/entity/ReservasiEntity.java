package entity;

public class ReservasiEntity {
    private int idReservasi;
    private KamarEntity kamar;
    private String tanggalCheckIn;
    private String tanggalCheckOut;
    private int totalMenginap;
    private double totalHarga;
    private String jenisPembayaran;
    private boolean status;
    private PelangganEntity pelanggan;

    public ReservasiEntity(int idReservasi, PelangganEntity pelanggan, KamarEntity kamar, String tanggalCheckIn, String tanggalCheckOut,
                           int totalMenginap, double totalHarga, String jenisPembayaran, boolean status) {
        this.idReservasi = idReservasi;
        this.pelanggan = pelanggan;
        this.kamar = kamar;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanggalCheckOut = tanggalCheckOut;
        this.totalMenginap = totalMenginap;
        this.totalHarga = totalHarga;
        this.jenisPembayaran = jenisPembayaran;
        this.status = status;
    }

    public int getIdReservasi() {
        return idReservasi;
    }

    public void setIdReservasi(int idReservasi) {
        this.idReservasi = idReservasi;
    }

    public KamarEntity getKamar() {
        return kamar;
    }

    public void setKamar(KamarEntity kamar) {
        this.kamar = kamar;
    }

    public String getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    public void setTanggalCheckIn(String tanggalCheckIn) {
        this.tanggalCheckIn = tanggalCheckIn;
    }

    public String getTanggalCheckOut() {
        return tanggalCheckOut;
    }

    public void setTanggalCheckOut(String tanggalCheckOut) {
        this.tanggalCheckOut = tanggalCheckOut;
    }

    public int getTotalMenginap() {
        return totalMenginap;
    }

    public void setTotalMenginap(int totalMenginap) {
        this.totalMenginap = totalMenginap;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PelangganEntity getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(PelangganEntity pelanggan) {
        this.pelanggan = pelanggan;
    }

    public String getJumlahMalam() {
        return null;
    }
}