package models;

import entity.KamarEntity;
import entity.PelangganEntity;
import entity.ReservasiEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservasiModel {
    private List<KamarEntity> daftarKamar = new ArrayList<>();
    private List<ReservasiEntity> reservasiList = new ArrayList<>();
    private List<PelangganEntity> pelangganList = new ArrayList<>();

    public ReservasiModel(){
        tambahDataKamar(new KamarEntity("101", "Single Bed", 100, true));
        tambahDataKamar(new KamarEntity("102", "Double Bed", 150, true));
        tambahDataKamar(new KamarEntity("103", "Suite", 200, true));
        tambahDataKamar(new KamarEntity("104", "Single Bed", 100, true));
    }

    public List<KamarEntity> lihatInformasiKamar() {
        return daftarKamar;
    }

    public void tambahDataKamar(KamarEntity kamar) {
        daftarKamar.add(kamar);
    }

    public void editDataKamar(KamarEntity kamarEntity) {
        int index = daftarKamar.indexOf(kamarEntity);
        daftarKamar.set(index, kamarEntity);
    }

    public void reservasiKamar(int idReservasi, PelangganEntity pelanggan, KamarEntity kamar, String tanggalCheckIn, String tanggalCheckOut, int totalMenginap, int hargaPerMalam, String jenisPembayaran) {
        int jumlahMalam = hitungJumlahMalam(tanggalCheckIn, tanggalCheckOut);
        double totalHarga = hitungTotalHarga(hargaPerMalam, jumlahMalam);

        ReservasiEntity reservasi = new ReservasiEntity(idReservasi, pelanggan, kamar, tanggalCheckIn, tanggalCheckOut, jumlahMalam, totalHarga, jenisPembayaran, true);
        reservasiList.add(reservasi);
        kamar.setStatus(false);
        pelangganList.add(pelanggan);
    }


    public ReservasiEntity lihatDetailReservasi(int idReservasi) {
        for (ReservasiEntity reservasi : reservasiList) {
            if (reservasi.getIdReservasi() == idReservasi) {
                return reservasi;
            }
        }
        return null;
    }

    public void checkOut(int idReservasi) {
        for (ReservasiEntity reservasi : reservasiList) {
            if (reservasi.getIdReservasi() == idReservasi) {
                reservasi.setStatus(false);
                reservasi.getKamar().setStatus(true);
            }
        }
    }

    public int jumlahKamarTersedia() {
        int jumlahTersedia = 0;
        for (KamarEntity kamar : daftarKamar) {
            if (kamar.isStatus()) {
                jumlahTersedia++;
            }
        }
        return jumlahTersedia;
    }

    public List<PelangganEntity> lihatDataPelanggan() {
        return pelangganList;
    }

    public int hitungJumlahMalam(String tanggalCheckIn, String tanggalCheckOut) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date checkInDate = dateFormat.parse(tanggalCheckIn);
            Date checkOutDate = dateFormat.parse(tanggalCheckOut);

            long differenceInMilliseconds = checkOutDate.getTime() - checkInDate.getTime();
            long differenceInDays = differenceInMilliseconds / (24 * 60 * 60 * 1000);

            return (int) differenceInDays;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public double hitungTotalHarga(int hargaPerMalam, int totalMenginap) {
        return hargaPerMalam * totalMenginap;
    }

}