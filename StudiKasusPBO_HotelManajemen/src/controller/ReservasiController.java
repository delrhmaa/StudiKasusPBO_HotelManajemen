package controller;

import entity.KamarEntity;
import entity.PelangganEntity;
import entity.ReservasiEntity;
import models.ReservasiModel;

import java.util.List;
import java.util.Scanner;

public class ReservasiController {
    private ReservasiModel model;

    public ReservasiController(ReservasiModel model) {
        this.model = model;
    }

    public void tambahDataKamar(KamarEntity kamar) {
        model.tambahDataKamar(kamar);
    }

    public List<KamarEntity> viewKamar() {
        return model.lihatInformasiKamar();
    }

    public void updateKamar(KamarEntity kamar) {
        model.editDataKamar(kamar);
    }

    public ReservasiEntity lihatDetailReservasiKamar(int idReservasi) {
        return model.lihatDetailReservasi(idReservasi);
    }

    public void reservasiKamar(int idReservasi, String noKamar, String tanggalCheckIn, String tanggalCheckOut, int totalMenginap, int hargaPerMalam, String jenisPembayaran) {
        PelangganEntity pelanggan = inputDataPelanggan();
        KamarEntity kamar = findKamarByNo(noKamar);

        if (kamar != null && kamar.isStatus()) {
            model.reservasiKamar(idReservasi, pelanggan, kamar, tanggalCheckIn, tanggalCheckOut, totalMenginap, hargaPerMalam, jenisPembayaran);
        } else {
            System.out.println("Kamar tidak tersedia atau tidak ditemukan.");
        }
    }


    public void checkOut(int idReservasi) {
        model.checkOut(idReservasi);
    }

    public int jumlahKamarTersedia() {
        return model.jumlahKamarTersedia();
    }

    public List<PelangganEntity> lihatDataPelanggan() {
        return model.lihatDataPelanggan();
    }

    public int hitungJumlahMalam(String tanggalCheckIn, String tanggalCheckOut) {
        return model.hitungJumlahMalam(tanggalCheckIn, tanggalCheckOut);
    }

    public double hitungTotalHarga(int totalMenginap, int hargaPerMalam) {
        return model.hitungTotalHarga(totalMenginap, hargaPerMalam);
    }

    public KamarEntity findKamarByNo(String noKamar) {
        for (KamarEntity kamar : model.lihatInformasiKamar()) {
            if (kamar.getNoKamar().equals(noKamar)) {
                return kamar;
            }
        }
        return null;
    }

    private PelangganEntity inputDataPelanggan() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Pelanggan: ");
        String namaPelanggan = scanner.next();
        System.out.print("Nomor Telepon: ");
        String nomorTelepon = scanner.next();
        System.out.print("Alamat: ");
        String alamat = scanner.next();
        System.out.print("Jenis Pembayaran (Cash/Card): ");
        String jenisPembayaran = scanner.next();

        return new PelangganEntity(namaPelanggan, nomorTelepon, alamat, jenisPembayaran);
    }
}