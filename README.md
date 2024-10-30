++Variabel Konstan BUKU dan HARGA++

BUKU adalah array berisi daftar judul buku, sementara HARGA adalah array berisi harga dari setiap buku. Keduanya merupakan variabel konstan (public static final) yang menyimpan data buku yang tersedia untuk dibeli.
Class Buku:

Menggunakan record untuk mendefinisikan tipe data Buku yang memiliki dua properti buku (untuk daftar buku) dan harga (untuk daftar harga buku). record adalah fitur di Java yang mempermudah deklarasi tipe data hanya untuk penyimpanan data tanpa memerlukan getter atau setter.
printBookList Method:

Method ini menampilkan daftar buku yang tersedia, mencetak setiap buku dengan format "judul buku - harga" menggunakan method formatRupiah untuk memformat harga ke dalam bentuk mata uang Rupiah.
Loop Pembelian Buku:

Menggunakan do-while loop untuk membolehkan pengguna memilih lebih dari satu buku. Di dalam loop, pengguna diminta untuk memasukkan nomor buku dan jumlah yang ingin dibeli. Jika nomor buku yang dimasukkan valid, jumlah buku ditambahkan ke array jumlahBeli. Setelah setiap pemilihan, pengguna ditanya apakah ingin membeli buku lain.
Validasi Input Nomor Buku:

Terdapat validasi yang memastikan bahwa nomor buku yang dipilih oleh pengguna berada dalam rentang yang benar (antara 1 hingga jumlah buku yang tersedia). Jika tidak valid, program menampilkan pesan kesalahan.
getTotalHarga Method:

Menghitung total harga berdasarkan buku yang dipilih oleh pengguna, jumlah buku yang dibeli, dan harga per buku. Metode ini juga menampilkan detail setiap item pembelian, subtotal untuk setiap item, serta total harga akhir. Total harga dikembalikan sebagai output.
Pembayaran dan Validasi Kembalian:

Setelah menghitung total harga, pengguna diminta memasukkan jumlah uang yang akan dibayarkan. Jika jumlah pembayaran cukup atau lebih, program menghitung kembalian dan mencetak jumlah kembalian. Jika jumlah pembayaran kurang, program menampilkan pesan bahwa uang yang dimasukkan tidak mencukupi.
formatRupiah Method:

Digunakan untuk memformat angka menjadi format mata uang Rupiah (dengan menggunakan NumberFormat dan Locale Indonesia), membuat tampilan harga lebih mudah dibaca.
