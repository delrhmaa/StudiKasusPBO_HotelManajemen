package entity;

public class KamarEntity {
    private String noKamar;
    private String jenisBed;
    private int hargaPerMalam;
    private boolean status;

    public KamarEntity(String noKamar, String jenisBed, int hargaPerMalam, boolean status) {
        this.noKamar = noKamar;
        this.jenisBed = jenisBed;
        this.hargaPerMalam = hargaPerMalam;
        this.status = status;
    }

    public String getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }

    public String getJenisBed() {
        return jenisBed;
    }

    public void setJenisBed(String jenisBed) {
        this.jenisBed = jenisBed;
    }

    public int getHargaPerMalam() {
        return hargaPerMalam;
    }

    public void setHargaPerMalam(int hargaPerMalam) {
        this.hargaPerMalam = hargaPerMalam;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
