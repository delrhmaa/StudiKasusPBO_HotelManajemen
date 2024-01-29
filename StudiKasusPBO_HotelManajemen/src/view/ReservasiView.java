package view;

import controller.ReservasiController;
import entity.KamarEntity;
import entity.PelangganEntity;
import entity.ReservasiEntity;

import java.util.List;
import java.util.Scanner;

public class ReservasiView {
    private ReservasiController controller;
    private Scanner scanner;

    public ReservasiView(ReservasiController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void menuUtama() {
        int pilihan;
        do {
            System.out.println("=== MENU UTAMA ===");
            System.out.println("1. Lihat Informasi Kamar");
            System.out.println("2. Tambah Data Kamar");
            System.out.println("3. Edit Data Kamar");
            System.out.println("4. Reservasi Kamar");
            System.out.println("5. Lihat Detail Reservasi");
            System.out.println("6. Check-Out");
            System.out.println("7. Lihat Jumlah Kamar Tersedia");
            System.out.println("8. Lihat Data Pelanggan");
            System.out.println("9. Keluar");
            System.out.print("Pilih menu (1-9): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    lihatInformasiKamar();
                    break;
                case 2:
                    tambahDataKamar();
                    break;
                case 3:
                    editDataKamar();
                    break;
                case 4:
                    reservasiKamar();
                    break;
                case 5:
                    lihatDetailReservasi();
                    break;
                case 6:
                    checkOut();
                    break;
                case 7:
                    lihatJumlahKamarTersedia();
                    break;
                case 8:
                    lihatDataPelanggan();
                    break;
                case 9:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 9);
    }
    

    private void lihatInformasiKamar() {
        List<KamarEntity> daftarKamar = controller.viewKamar();
        System.out.println("=== INFORMASI KAMAR ===");
        for (KamarEntity kamar : daftarKamar) {
            System.out.println("Nomor Kamar: " + kamar.getNoKamar());
            System.out.println("Jenis Bed: " + kamar.getJenisBed());
            System.out.println("Harga per Malam: " + kamar.getHargaPerMalam());
            System.out.println("Status: " + (kamar.isStatus() ? "Tersedia" : "Tidak Tersedia"));
            System.out.println("--------------------");
        }
    }

    private void tambahDataKamar() {
        System.out.println("=== TAMBAH DATA KAMAR ===");
        System.out.print("Nomor Kamar: ");
        String noKamar = scanner.next();
        System.out.print("Jenis Bed: ");
        String jenisBed = scanner.next();
        System.out.print("Harga per Malam: ");
        int hargaPerMalam = scanner.nextInt();

        KamarEntity kamar = new KamarEntity(noKamar, jenisBed, hargaPerMalam, true);
        controller.tambahDataKamar(kamar);
        System.out.println("Data kamar berhasil ditambahkan!");
    }

    private void editDataKamar() {
        System.out.println("=== EDIT DATA KAMAR ===");
        System.out.print("Nomor Kamar yang akan diubah: ");
        String noKamar = scanner.next();
        KamarEntity kamar = controller.findKamarByNo(noKamar);

        if (kamar != null) {
            System.out.print("Jenis Bed baru: ");
            String jenisBed = scanner.next();
            System.out.print("Harga per Malam baru: ");
            int hargaPerMalam = scanner.nextInt();

            kamar.setJenisBed(jenisBed);
            kamar.setHargaPerMalam(hargaPerMalam);
            controller.updateKamar(kamar);

            System.out.println("Data kamar berhasil diubah!");
        } else {
            System.out.println("Kamar tidak ditemukan.");
        }
    }

    private void reservasiKamar() {
        System.out.println("=== RESERVASI KAMAR ===");
        System.out.print("ID Reservasi: ");
        int idReservasi = scanner.nextInt();
        System.out.print("Nomor Kamar: ");
        String noKamar = scanner.next();
        System.out.print("Tanggal Check-In (yyyy-MM-dd): ");
        String tanggalCheckIn = scanner.next();
        System.out.print("Tanggal Check-Out (yyyy-MM-dd): ");
        String tanggalCheckOut = scanner.next();
        System.out.print("Jumlah Malam: ");
        int totalMenginap = scanner.nextInt();
        System.out.print("Harga per Malam: ");
        int hargaPerMalam = scanner.nextInt();
        System.out.print("Jenis Pembayaran (Cash/Card): ");
        String jenisPembayaran = scanner.next();  // Ambil input jenis pembayaran dari pengguna

        // Memanggil metode reservasiKamar dengan parameter yang sesuai
        controller.reservasiKamar(idReservasi, noKamar, tanggalCheckIn, tanggalCheckOut, totalMenginap, hargaPerMalam, jenisPembayaran);
        System.out.println("Reservasi berhasil dilakukan!");
    }



    private void lihatDetailReservasi() {
        System.out.println("=== LIHAT DETAIL RESERVASI ===");
        System.out.print("ID Reservasi: ");
        int idReservasi = scanner.nextInt();
        ReservasiEntity reservasi = controller.lihatDetailReservasiKamar(idReservasi);

        if (reservasi != null) {
            System.out.println("=== DETAIL RESERVASI ===");
            System.out.println("ID Reservasi: " + reservasi.getIdReservasi());
            System.out.println("Nomor Kamar: " + reservasi.getKamar().getNoKamar());
            System.out.println("Nama Pelanggan: " + reservasi.getPelanggan().getNamaPelanggan());
            System.out.println("Tanggal Check-In: " + reservasi.getTanggalCheckIn());
            System.out.println("Tanggal Check-Out: " + reservasi.getTanggalCheckOut());
            System.out.println("Jumlah Malam: " + reservasi.getTotalMenginap());
            System.out.println("Total Harga: " + reservasi.getTotalHarga());
            System.out.println("Jenis Pembayaran: " + reservasi.getJenisPembayaran());
            System.out.println("Status: " + (reservasi.isStatus() ? "Aktif" : "Nonaktif"));

            // Tambahkan handling untuk menampilkan status kamar
            if (!reservasi.isStatus()) {
                System.out.println("Status Kamar: Tersedia");
            } else {
                System.out.println("Status Kamar: Tidak Tersedia");
            }
        } else {
            System.out.println("Reservasi tidak ditemukan.");
        }
    }


    private void checkOut() {
        System.out.println("=== CHECK-OUT ===");
        System.out.print("ID Reservasi: ");
        int idReservasi = scanner.nextInt();
        controller.checkOut(idReservasi);
        System.out.println("Check-out berhasil!");
    }

    private void lihatJumlahKamarTersedia() {
        int jumlahTersedia = controller.jumlahKamarTersedia();
        System.out.println("Jumlah kamar tersedia: " + jumlahTersedia);
    }

    private void lihatDataPelanggan() {
        List<PelangganEntity> pelangganList = controller.lihatDataPelanggan();
        System.out.println("=== DATA PELANGGAN ===");
        for (PelangganEntity pelanggan : pelangganList) {
            System.out.println("Nama: " + pelanggan.getNamaPelanggan());
            System.out.println("Nomor Kamar: " + pelanggan.getNoKamar());
            System.out.println("Jenis Pembayaran: " + pelanggan.getJenisPembayaran());
            System.out.println("--------------------");
        }
    }

}
