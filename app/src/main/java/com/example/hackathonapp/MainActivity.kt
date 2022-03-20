package com.example.hackathonapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.vishnusivadas.advanced_httpurlconnection.FetchData
import com.vishnusivadas.advanced_httpurlconnection.PutData
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener

/*
TODO LISTA
NAPRAVIG FUNKCIONALAN LOGIN - ZAVRSENO
RIJESITI SISTEM BAZA        - ZAVRSENO
NAPRAVITI SKENER ZA QR KOD
KRENUTI SA KREIRANJEM GLAVNOG INTENTA (TAJMER, PAUZA, KANTINA,HELP EDUKACIJA....)
 */


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username_input = findViewById<EditText>(R.id.username_input)
        val password_input = findViewById<EditText>(R.id.password_input)
        val btn = findViewById<Button>(R.id.login_button)
        val txt = findViewById<TextView>(R.id.text_to_signup)


        txt.setOnClickListener{
            val intentt = Intent(this, SignUp::class.java)
            startActivity(intentt)
            finish()
        }

        btn.setOnClickListener {


            val username = username_input.text.toString()
            val password = password_input.text.toString()
            if (username.isNotEmpty() && password.isNotEmpty())
            {
                //Start ProgressBar first (Set visibility VISIBLE)
                val handlerr = Handler(Looper.getMainLooper())
                handlerr.post(Runnable{
                    val field = arrayOfNulls<String>(2)
                    field[0] = "username"
                    field[1] = "password"
                    //Creating array for data
                    val data = arrayOfNulls<String>(2)
                    data[0] = username
                    data[1] = password
                    val putData = PutData(
                        "http://192.168.43.226/loginregister/login.php",
                        "POST",
                        field,
                        data
                    )
                    if (putData.startPut())
                    {
                        if (putData.onComplete())
                        {
                            val result = putData.result
                            val jObj = JSONObject(result)
                            val error = jObj.getBoolean("error")
                            if (!error){
                                val intent = Intent(this, Skener::class.java)
                                /*intent.putExtra("username", username )
                                intent.putExtra("password", password )*/
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(this, "Nesto nije kako treba", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }

    }
}