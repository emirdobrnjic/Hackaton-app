package com.example.hackathonapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PrvaSlika : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prva_slika)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val username = preferences.getString("USERNAME", "")
        val password = preferences.getString("PASSWORD", "")
        val skener = preferences.getBoolean("SKENER", false)
        val button = findViewById<Button>(R.id.NEXTbtn)

        button.setOnClickListener{
            if (username.toString().isEmpty()){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                if (skener){
                    val intentt = Intent (this, PraviAktiviti::class.java)
                    startActivity(intentt)
                    finish()
                }else{
                    val intenttt = Intent (this, Skener::class.java)
                    startActivity(intenttt)
                    finish()
                }

            }
        }

    }
}