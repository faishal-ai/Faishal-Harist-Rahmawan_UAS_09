public class Main {
    public static void main(String[] args) {
        RentalKendaraan rentalKendaraan = new RentalKendaraan();
        // Menambahkan beberapa kendaraan tanpa menggunakan Scanner
        rentalKendaraan.daftarKendaraan("L 1234 XYZ", "Mobil", "Toyota");
        rentalKendaraan.daftarKendaraan("N 5678A BC", "Mobil", "Honda");
        rentalKendaraan.daftarKendaraan("AG 5645 ADC", "Mobil", "Subaru");
        rentalKendaraan.daftarKendaraan("B 8978 AAC", "Mobil", "Mitsubishi");

        rentalKendaraan.menuUtama();
    }
}