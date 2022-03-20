package com.example.hackathonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EduActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edu)

        val button = findViewById<Button>(R.id.button11)
        button.setOnClickListener{
            val intent = Intent(this, PraviAktiviti::class.java)
            startActivity(intent)
            finish()
        }
    }
}