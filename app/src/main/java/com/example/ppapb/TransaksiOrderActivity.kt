package com.example.ppapb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ppapb.databinding.ActivityTransaksiOrderBinding
import java.text.NumberFormat
import java.util.Locale
import java.util.Random

class TransaksiOrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransaksiOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransaksiOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari intent
        val namaFilm = intent.getStringExtra("NAMA_FILM") ?: "Tidak diketahui"
        val orderNumber = generateRandomOrderNumber()
        val seat = intent.getStringExtra("SEAT") ?: "Tidak diketahui"
        val lokasiBioskop = intent.getStringExtra("LOKASI_BIOSKOP") ?: "Tidak diketahui"
        val tanggalFilm = intent.getStringExtra("TANGGAL_FILM") ?: "Tidak diketahui"
        val metodePembayaran = intent.getStringExtra("METODE_PEMBAYARAN") ?: "Tidak diketahui"
        val bankPembayaran = intent.getStringExtra("BANK_PEMBAYARAN")
        val dompetDigitalPembayaran = intent.getStringExtra("DOMPET_DIGITAL_PEMBAYARAN")
        val jumlahTiket = intent.getIntExtra("JUMLAH_TIKET", 0)
        val biayaAdmin = intent.getIntExtra("BIAYA_ADMIN", 0)
        val totalHarga = intent.getIntExtra("TOTAL_HARGA", 0)

        // Set data ke view
        binding.tvFilmName.text = "Nama Film: $namaFilm"
        binding.tvOrderNumber.text = "Order Number: $orderNumber"
        binding.tvSeat.text = "Seat: $seat"
        binding.tvBioskopLocation.text = "Lokasi Bioskop: $lokasiBioskop"
        binding.tvTanggalFilm.text = "Tanggal Film: $tanggalFilm"
        val detailPembayaran = when (metodePembayaran) {
            "Pembayaran Bank" -> "(${bankPembayaran})"
            "Pembayaran Dompet Digital" -> "(${dompetDigitalPembayaran})"
            else -> ""
        }
        binding.tvMetodePembayaran.text = "Metode Pembayaran: $metodePembayaran $detailPembayaran"
        binding.tvJumlahTiket.text = "Jumlah Tiket: $jumlahTiket"
        binding.tvBiayaAdmin.text = "Biaya Admin: Rp${formatCurrency(biayaAdmin)}"
        binding.tvTotalHarga.text = "Total Harga: Rp${formatCurrency(totalHarga)}"

        binding.ivBack.setOnClickListener {
            // Mengakhiri activity ini, kembali ke activity sebelumnya
            finish()
        }
    }

    private fun generateRandomOrderNumber(): String {
        val random = Random()
        return "ORD-${random.nextInt(1000000)}"
    }

    private fun formatCurrency(amount: Int): String {
        val localeID = Locale("in", "ID")
        return NumberFormat.getCurrencyInstance(localeID).format(amount)
    }
}