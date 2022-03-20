package com.example.hackathonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sos)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val intent = Intent(this, PraviAktiviti::class.java)
            startActivity(intent)
            finish()
        }
    }
}