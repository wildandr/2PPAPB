package com.example.ppapb

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ppapb.databinding.ActivityTicketPaymentBinding

class TicketPaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTicketPaymentBinding
    private var hargaTiket: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup spinner untuk bioskop
        val bioskopAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.bioskop_array,
            android.R.layout.simple_spinner_item
        )
        bioskopAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBioskop.adapter = bioskopAdapter

        // Setup spinner untuk jenis seat
        val jenisSeatAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.jenis_seat_array,
            android.R.layout.simple_spinner_item
        )
        jenisSeatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerJenisSeat.adapter = jenisSeatAdapter

        // Setup spinner untuk metode pembayaran
        val metodePembayaranAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.metode_pembayaran_array,
            android.R.layout.simple_spinner_item
        )
        metodePembayaranAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPaymentMethod.adapter = metodePembayaranAdapter

        // Setup spinner untuk bank
        val bankAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.bank_array,
            android.R.layout.simple_spinner_item
        )
        bankAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBank.adapter = bankAdapter

        // Setup spinner untuk dompet digital
        val dompetDigitalAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.dompet_digital_array,
            android.R.layout.simple_spinner_item
        )
        dompetDigitalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDompetDigital.adapter = dompetDigitalAdapter

        // Mengatur visibility spinner bank dan dompet digital berdasarkan metode pembayaran
        binding.spinnerPaymentMethod.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (binding.spinnerPaymentMethod.selectedItem.toString()) {
                    "Pembayaran Bank" -> {
                        binding.spinnerBank.visibility = View.VISIBLE
                        binding.spinnerDompetDigital.visibility = View.GONE
                    }
                    "Pembayaran Dompet Digital" -> {
                        binding.spinnerBank.visibility = View.GONE
                        binding.spinnerDompetDigital.visibility = View.VISIBLE
                    }
                    else -> {
                        binding.spinnerBank.visibility = View.GONE
                        binding.spinnerDompetDigital.visibility = View.GONE
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.spinnerBank.visibility = View.GONE
                binding.spinnerDompetDigital.visibility = View.GONE
            }
        }

        // Menentukan harga tiket berdasarkan jenis seat yang dipilih
        binding.spinnerJenisSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                hargaTiket = when (position) {
                    0 -> 25000
                    1 -> 30000
                    2 -> 50000
                    else -> 0
                }
                binding.tvHargaValue.text = "Rp $hargaTiket"
                calculateTotal() // Menghitung total harga ketika jenis seat dipilih
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.btnBayar.setOnClickListener {
            // Ambil data dari input pengguna
            val namaFilm = "Film Yang Dipilih"
            val seat = binding.spinnerJenisSeat.selectedItem.toString()
            val lokasiBioskop = binding.spinnerBioskop.selectedItem.toString()
            val tanggalFilm = "${binding.datePicker.dayOfMonth}/${binding.datePicker.month + 1}/${binding.datePicker.year}"
            val metodePembayaran = binding.spinnerPaymentMethod.selectedItem.toString()
            val bankPembayaran = binding.spinnerBank.selectedItem?.toString()
            val dompetDigitalPembayaran = binding.spinnerDompetDigital.selectedItem?.toString()
            val jumlahTiket = 1 // Asumsi jumlah tiket yang dibeli
            val biayaAdmin = 2000

            // Menghitung total harga
            val totalHarga = (hargaTiket + biayaAdmin) * jumlahTiket

            // Membuat intent untuk berpindah ke TransaksiOrderActivity
            val intent = Intent(this@TicketPaymentActivity, TransaksiOrderActivity::class.java)

            // Menambahkan data ke intent
            intent.putExtra("NAMA_FILM", namaFilm)
            intent.putExtra("SEAT", seat)
            intent.putExtra("LOKASI_BIOSKOP", lokasiBioskop)
            intent.putExtra("TANGGAL_FILM", tanggalFilm)
            intent.putExtra("METODE_PEMBAYARAN", metodePembayaran)
            intent.putExtra("BANK_PEMBAYARAN", bankPembayaran)
            intent.putExtra("DOMPET_DIGITAL_PEMBAYARAN", dompetDigitalPembayaran)
            intent.putExtra("JUMLAH_TIKET", jumlahTiket)
            intent.putExtra("BIAYA_ADMIN", biayaAdmin)
            intent.putExtra("TOTAL_HARGA", totalHarga)

            // Memulai activity baru
            startActivity(intent)
        }


        binding.ivBack.setOnClickListener {
            // Mengakhiri activity ini, kembali ke activity sebelumnya
            finish()
        }
    }

    private fun calculateTotal() {
        val biayaAdmin = 2000
        val jumlahTiket = 1 // Asumsi jumlah tiket yang dibeli
        val totalHarga = (hargaTiket + biayaAdmin) * jumlahTiket
        binding.tvTotalValue.text = "Rp $totalHarga"
        binding.tvBiayaAdminValue.text = "Rp $biayaAdmin"
    }
}
