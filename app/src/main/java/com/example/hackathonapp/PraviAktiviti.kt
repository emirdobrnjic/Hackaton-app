package com.example.hackathonapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PraviAktiviti : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pravi_aktiviti)
        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        //ODJAVA BUTTON
        val buttonOdjavi = findViewById<Button>(R.id.buttonOdjava)
        buttonOdjavi.setOnClickListener{
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this, PrvaSlika::class.java)
            startActivity(intent)
            finish()

        }
    }
}