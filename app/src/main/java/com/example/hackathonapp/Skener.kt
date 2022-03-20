package com.example.hackathonapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode

class Skener : AppCompatActivity() {

    val REQUEST_ID_MULTIPLE_PERMISSIONS = 7

    lateinit var preferences: SharedPreferences
    private lateinit var codeScanner: CodeScanner

    var SKENER = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skener)
        val scannerView = findViewById<CodeScannerView>(R.id.scanner_view)
        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        codeScanner = CodeScanner(this, scannerView)

        // Parameters (default values)
        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
        codeScanner.formats = CodeScanner.ALL_FORMATS // list of type BarcodeFormat,
        // ex. listOf(BarcodeFormat.QR_CODE)
        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not

        // Callbacks
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                if (it.text.toString() == "http://www.chek-me.ba"){
                    SKENER = true
                    val editor: SharedPreferences.Editor = preferences.edit()
                    editor.putBoolean("SKENER", SKENER)
                    editor.apply()
                    val intentt = Intent(this, PraviAktiviti::class.java )
                    startActivity(intentt)
                    finish()
                }
            }

        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            runOnUiThread {
                Toast.makeText(this, "Camera initialization error: ${it.message}",
                    Toast.LENGTH_LONG).show()
            }
        }

        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }
    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()

    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

}