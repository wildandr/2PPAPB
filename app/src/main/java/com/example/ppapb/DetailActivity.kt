// DetailActivity.kt

package com.example.ppapb

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ppapb.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data yang Anda terima dari intent
        val filmTitle = intent.getStringExtra("FILM_TITLE")

        // Set data berdasarkan film yang dipilih
        when (filmTitle) {
            "Spiderman" -> {
                binding.ivFilm.setImageResource(R.drawable.spiderman)
                binding.tvJudulFilm.text = "Spiderman"
                binding.tvPembuatDanRating.text = "Pembuat Film | ⭐ 4.9"
                binding.tvDeskripsi.text = "Spiderman adalah film superhero yang mengisahkan tentang seorang remaja bernama Peter Parker yang mendapatkan kekuatan super setelah digigit oleh laba-laba yang dimodifikasi genetik."
                binding.tvGenre.text = "Action, Adventure, Sci-Fi"
                binding.tvStoryline.text = "Storyline"
            }
            "Hulk" -> {
                binding.ivFilm.setImageResource(R.drawable.hulk)
                binding.tvJudulFilm.text = "Hulk"
                binding.tvPembuatDanRating.text = "Pembuat Film | ⭐ 4.5"
                binding.tvDeskripsi.text = "Hulk adalah film superhero yang berpusat pada Bruce Banner, seorang ilmuwan yang berubah menjadi makhluk besar berwarna hijau dengan kekuatan super saat dia marah."
                binding.tvGenre.text = "Action, Adventure, Sci-Fi"
                binding.tvStoryline.text = "Storyline"
            }
            "Suster Ngesot" -> {
                binding.ivFilm.setImageResource(R.drawable.susterngesot)
                binding.tvJudulFilm.text = "Suster Ngesot"
                binding.tvPembuatDanRating.text = "Pembuat Film | ⭐ 3.8"
                binding.tvDeskripsi.text = "Suster Ngesot adalah film horor Indonesia yang mengisahkan tentang hantu seorang suster yang tewas dalam kecelakaan dan kini menghantui sebuah rumah sakit."
                binding.tvGenre.text = "Horror"
                binding.tvStoryline.text = "Storyline"
            }
            "Avenger" -> {
                binding.ivFilm.setImageResource(R.drawable.avenger)
                binding.tvJudulFilm.text = "Avenger"
                binding.tvPembuatDanRating.text = "Pembuat Film | ⭐ 4.7"
                binding.tvDeskripsi.text = "Avenger adalah film superhero yang mengisahkan tentang kelompok pahlawan super yang bekerja sama untuk menghentikan ancaman besar yang mengancam bumi."
                binding.tvGenre.text = "Action, Adventure, Sci-Fi"
                binding.tvStoryline.text = "Storyline"
            }
            "Ayat Ayat Cinta" -> {
                binding.ivFilm.setImageResource(R.drawable.ayatayatcinta)
                binding.tvJudulFilm.text = "Ayat Ayat Cinta"
                binding.tvPembuatDanRating.text = "Pembuat Film | ⭐ 4.2"
                binding.tvDeskripsi.text = "Ayat Ayat Cinta adalah film drama romantis Indonesia yang diadaptasi dari novel dengan judul yang sama, mengisahkan tentang kehidupan seorang mahasiswa di Mesir dan pencariannya akan cinta sejati."
                binding.tvGenre.text = "Drama, Romance"
                binding.tvStoryline.text = "Storyline"
            }
            "Ratatouille" -> {
                binding.ivFilm.setImageResource(R.drawable.ratatouille)
                binding.tvJudulFilm.text = "Ratatouille"
                binding.tvPembuatDanRating.text = "Pembuat Film | ⭐ 4.6"
                binding.tvDeskripsi.text = "Ratatouille adalah film animasi yang mengisahkan tentang seekor tikus bernama Remy yang memiliki impian menjadi koki dan mencoba untuk mencapainya dengan bermitra dengan seorang tukang sampah di sebuah restoran terkenal di Paris."
                binding.tvGenre.text = "Animation, Comedy, Family"
                binding.tvStoryline.text = "Storyline"
            }
        }

        binding.ivBack.setOnClickListener {
            // Mengakhiri activity ini, kembali ke activity sebelumnya
            finish()
        }

        binding.btnBeliTiket.setOnClickListener {
            // Buka TicketPaymentActivity
            startActivity(Intent(this, TicketPaymentActivity::class.java))
        }
    }
}
