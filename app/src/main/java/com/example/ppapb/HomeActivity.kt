package com.example.ppapb

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {
    private lateinit var tvWelcome: TextView

    private lateinit var cardSpiderman: CardView
    private lateinit var cardHulk: CardView
    private lateinit var cardSusterNgesot: CardView
    private lateinit var cardAvenger: CardView
    private lateinit var cardAyatAyatCinta: CardView
    private lateinit var cardRatatouille: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inisialisasi view
        tvWelcome = findViewById(R.id.tvWelcome)

        cardSpiderman = findViewById(R.id.cardSpiderman)
        cardHulk = findViewById(R.id.cardHulk)
        cardSusterNgesot = findViewById(R.id.cardSusterNgesot)
        cardAvenger = findViewById(R.id.cardAvenger)
        cardAyatAyatCinta = findViewById(R.id.cardAyatAyatCinta)
        cardRatatouille = findViewById(R.id.cardRatatouille)

        // Ambil username dari intent
        val username = intent.getStringExtra("USERNAME")

        // Tampilkan sapaan pengguna di TextView
        tvWelcome.text = "Hello, \n$username!"

        // Set OnClickListener pada setiap CardView untuk menampilkan detail film
        cardSpiderman.setOnClickListener {
            showDetail("Spiderman")
        }

        cardHulk.setOnClickListener {
            showDetail("Hulk")
        }

        cardSusterNgesot.setOnClickListener {
            showDetail("Suster Ngesot")
        }

        cardAvenger.setOnClickListener {
            showDetail("Avenger")
        }

        cardAyatAyatCinta.setOnClickListener {
            showDetail("Ayat Ayat Cinta")
        }

        cardRatatouille.setOnClickListener {
            showDetail("Ratatouille")
        }
    }

    private fun showDetail(filmTitle: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("FILM_TITLE", filmTitle)
        startActivity(intent)
    }
}
