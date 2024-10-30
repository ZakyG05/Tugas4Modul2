import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
  // Refactor Extract Constant
    /**
     * Variabel Konstan BUKU dan HARGA
     * BUKU adalah array berisi daftar judul buku,
     * sementara HARGA adalah array berisi harga dari setiap buku.
     * Keduanya merupakan variabel konstan (public static final)
     * yang menyimpan data buku yang tersedia untuk dibeli.
     */
    public static final String[] BUKU = new String[]{"1. Belajar Java", "2. Pemrograman Web", "3. Algoritma & Struktur Data", "4. Pengantar Basis Data", "5. Buku Filsafat"};
    public static final double[] HARGA = new double[]{75000, 65000, 90000, 80000, 50000};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar buku dan harga //Refactor Extract Method
        Buku Buku = new Buku(BUKU, HARGA);

        // Menampilkan daftar buku //Refactor Extract Method
        printBookList(Buku);

        /**
         * printBookList Method
         * Method ini menampilkan daftar buku yang tersedia,
         * mencetak setiap buku dengan format "judul buku - harga" menggunakan
         * method formatRupiah untuk memformat harga ke dalam bentuk mata uang Rupiah.
         */
        // Pengguna memasukkan jumlah buku yang ingin dibeli
        int[] jumlahBeli = new int[Buku.buku().length];
        char lanjut;
        do {
            System.out.print("\nPilih nomor buku yang ingin dibeli: ");
            int pilihan = scanner.nextInt();

            // Validasi input nomor buku
            if (pilihan >= 1 && pilihan <= Buku.buku().length) {
                System.out.print("Masukkan jumlah yang ingin dibeli untuk " + Buku.buku()[pilihan - 1] + ": ");
                int jumlah = scanner.nextInt();
                jumlahBeli[pilihan - 1] += jumlah;
            } else {
                System.out.println("Pilihan tidak valid.");
            }

            // Menanyakan apakah ingin membeli buku lain
            System.out.print("Apakah Anda ingin membeli buku lain? (y/n): ");
            lanjut = scanner.next().charAt(0);

            /**
             * Loop Pembelian Buku:
             *Menggunakan do-while loop untuk membolehkan
             * pengguna memilih lebih dari satu buku. Di dalam loop,
             * pengguna diminta untuk memasukkan nomor buku dan jumlah yang ingin dibeli.
             * Jika nomor buku yang dimasukkan valid, jumlah buku ditambahkan ke array jumlahBeli.
             * Setelah setiap pemilihan, pengguna ditanya apakah ingin membeli buku lain.
             */
        } while (lanjut == 'y' || lanjut == 'Y');

        // Menghitung total harga
        double totalHarga = getTotalHarga(Buku.buku(), jumlahBeli, Buku.harga());

        // Pembayaran
        System.out.print("Masukkan jumlah uang yang dibayarkan: Rp ");
        double bayar = scanner.nextDouble();

        // Menghitung kembalian
        if (bayar >= totalHarga) {
            double kembalian = bayar - totalHarga;
            System.out.println("Pembayaran sukses! Kembalian Anda: Rp " + formatRupiah(kembalian));
        } else {
            System.out.println("Uang yang Anda masukkan tidak mencukupi.");
        }

        System.out.println("Terima kasih sudah berbelanja di Toko Buku!");
    }

    private static void printBookList(Buku Buku) {
        System.out.println("Selamat datang di Toko Buku!");
        System.out.println("Berikut daftar buku yang tersedia:");
        for (int i = 0; i < Buku.buku().length; i++) {
            System.out.println(Buku.buku()[i] + " - Rp " + formatRupiah(Buku.harga()[i]));
        }
    }

    private record Buku(String[] buku, double[] harga) {
    }

    //Refactor Extract Method
    private static double getTotalHarga(String[] buku, int[] jumlahBeli, double[] harga) {
        double totalHarga = 0;
        System.out.println("\nStruk Pembelian:");
        System.out.println("-----------------------------");
        for (int i = 0; i < buku.length; i++) {
            if (jumlahBeli[i] > 0) {
                double subtotal = harga[i] * jumlahBeli[i];
                System.out.println(buku[i] + " (x" + jumlahBeli[i] + ") - Rp " + formatRupiah(subtotal));
                totalHarga += subtotal;
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Total Harga: Rp " + formatRupiah(totalHarga));
        return totalHarga;
    }

    // Method untuk format uang //Refactor Rename

    private static String formatRupiah(double jumlah) {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(Locale.of("id", "ID"));

        return formatRupiah.format(jumlah);
    }
}
