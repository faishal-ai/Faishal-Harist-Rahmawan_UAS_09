import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Kendaraan {
    String noTnkb;
    String jenis;
    String merk;

    Kendaraan(String noTnkb, String jenis, String merk) {
        this.noTnkb = noTnkb;
        this.jenis = jenis;
        this.merk = merk;
    }
}

class Peminjam {
    String nama;
    String noKtp;

    Peminjam(String nama, String noKtp) {
        this.nama = nama;
        this.noKtp = noKtp;
    }
}

class Transaksi {
    Kendaraan kendaraan;
    Peminjam peminjam;
    String tanggalPinjam;
    String tanggalKembali;

    Transaksi(Kendaraan kendaraan, Peminjam peminjam, String tanggalPinjam, String tanggalKembali) {
        this.kendaraan = kendaraan;
        this.peminjam = peminjam;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }
}

public class RentalKendaraan {
    private ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    private ArrayList<Peminjam> daftarPeminjam = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menuUtama() {
        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Peminjam");
            System.out.println("3. Tampilkan Seluruh Transaksi");
            System.out.println("4. Urutkan Transaksi Menurut No TNKB");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    inputDaftarKendaraan();
                    break;
                case 2:
                    daftarPeminjam();
                    break;
                case 3:
                    tampilkanSeluruhTransaksi();
                    break;
                case 4:
                    urutkanTransaksiMenurutNoTnkb();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi rental kendaraan.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    // Metode input daftar kendaraan menggunakan Scanner
    private void inputDaftarKendaraan() {
        System.out.print("Masukkan nomor TNKB: ");
        String noTnkb = scanner.nextLine();
        System.out.print("Masukkan jenis kendaraan: ");
        String jenis = scanner.nextLine();
        System.out.print("Masukkan merk kendaraan: ");
        String merk = scanner.nextLine();
        daftarKendaraan(noTnkb, jenis, merk);
    }

    // Metode daftar kendaraan tanpa Scanner
    public void daftarKendaraan(String noTnkb, String jenis, String merk) {
        daftarKendaraan.add(new Kendaraan(noTnkb, jenis, merk));
        System.out.println("Kendaraan berhasil didaftarkan.");
    }

    private void daftarPeminjam() {
        System.out.print("Masukkan nama peminjam: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan nomor KTP peminjam: ");
        String noKtp = scanner.nextLine();
        Peminjam peminjam = new Peminjam(nama, noKtp);

        daftarPeminjam.add(peminjam);

        System.out.print("Masukkan nomor TNKB kendaraan yang dipinjam: ");
        String noTnkb = scanner.nextLine();
        Kendaraan kendaraan = null;
        for (Kendaraan k : daftarKendaraan) {
            if (k.noTnkb.equals(noTnkb)) {
                kendaraan = k;
                break;
            }
        }

        if (kendaraan != null) {
            System.out.print("Masukkan tanggal pinjam (dd/mm/yyyy): ");
            String tanggalPinjam = scanner.nextLine();
            System.out.print("Masukkan tanggal kembali (dd/mm/yyyy): ");
            String tanggalKembali = scanner.nextLine();
            daftarTransaksi.add(new Transaksi(kendaraan, peminjam, tanggalPinjam, tanggalKembali));
            System.out.println("Transaksi berhasil didaftarkan.");
        } else {
            System.out.println("Kendaraan tidak ditemukan.");
        }
    }

    private void tampilkanSeluruhTransaksi() {
        for (Transaksi transaksi : daftarTransaksi) {
            System.out.println("No TNKB: " + transaksi.kendaraan.noTnkb + ", Peminjam: " + transaksi.peminjam.nama +
                    ", Tanggal Pinjam: " + transaksi.tanggalPinjam + ", Tanggal Kembali: " + transaksi.tanggalKembali);
        }
    }

    private void urutkanTransaksiMenurutNoTnkb() {
        Collections.sort(daftarTransaksi, new Comparator<Transaksi>() {
            @Override
            public int compare(Transaksi t1, Transaksi t2) {
                return t1.kendaraan.noTnkb.compareTo(t2.kendaraan.noTnkb);
            }
        });
        System.out.println("Transaksi telah diurutkan menurut No TNKB.");
    }
}