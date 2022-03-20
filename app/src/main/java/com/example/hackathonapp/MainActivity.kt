package com.example.hackathonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

/*
TODO LISTA
NAPRAVIG FUNKCIONALAN LOGIN
RIJESITI SISTEM BAZA
NAPRAVITI SKENER ZA QR KOD
KRENUTI SA KREIRANJEM GLAVNOG INTENTA (TAJMER, PAUZA, KANTINA,HELP EDUKACIJA....)
 */


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plainTxt1 = findViewById<EditText>(R.id.editTextTextPersonName)
        val plainTxt2 = findViewById<EditText>(R.id.editTextTextPassword)
        val brn = findViewById<Button>(R.id.button)


    }
}