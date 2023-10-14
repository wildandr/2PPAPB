package com.example.ppapb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inisialisasi view
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        // Set OnClickListener pada Button "Login"
        btnLogin.setOnClickListener {
            // Ambil input username dan password
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()

            // Cek apakah username dan password benar
            if(username == "salsa123" && password == "123") {
                // Jika benar, buat Intent untuk pindah ke HomeActivity
                val intent = Intent(this, HomeActivity::class.java)

                // Tambahkan username sebagai extra
                intent.putExtra("USERNAME", username)

                // Pindah ke HomeActivity
                startActivity(intent)
                finish()
            } else {
                // Jika salah, tampilkan pesan error
                Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
