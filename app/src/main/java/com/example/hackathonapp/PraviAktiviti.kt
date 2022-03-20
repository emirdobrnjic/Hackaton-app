package com.example.hackathonapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
//import com.example.hackathonapp.databinding.ActivityMainBinding
import java.util.*

class PraviAktiviti : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    //lateinit var  binding: ActivityMainBinding
    /*lateinit var dataHelper: DataHelper
    private val timer  = Timer()*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pravi_aktiviti)
        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        //dataHelper = DataHelper(applicationContext)

        val textSat = findViewById<TextView>(R.id.textView2)
        //val button = findViewById<Button>(R.id.startButton)
        val textPauza = findViewById<TextView>(R.id.pauzoTex)
        val slikaa = findViewById<ImageView>(R.id.imageViewPAUZA)
        slikaa.setOnClickListener{
            textPauza.visibility = View.VISIBLE
        }

        val textIme = findViewById<TextView>(R.id.IME_TEXT)
        val username = preferences.getString("USERNAME", "")
        //textIme.text = username



        /*if(dataHelper.timerCounting()){
            //startTimer()
        }*/
        /*else{
            //stopTimer()
            if ( dataHelper.startTime() != null && dataHelper.stopTime() != null){
                //val time = Date().time - calcResetTime().time
                //textSat.text = timeStringFromLong(time)

            }
        }*/
        //timer.scheduleAtFixedRate(TimeTask(), 0, 500)

        /*button.setOnClickListener{
            startStopAction()
        }*/

        //ODJAVA BUTTON
        val buttonOdjavi = findViewById<Button>(R.id.buttonOdjava)
        buttonOdjavi.setOnClickListener{
            //resetAction()
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this, PrvaSlika::class.java)
            startActivity(intent)
            finish()
            //textSat.text = timeStringFromLong(0)
        }
    }

    /*private inner class TimeTask: TimerTask(){
        override fun run(){
            if (dataHelper.timerCounting())
            {
                val textSat = findViewById<TextView>(R.id.textView2)
                val time  = Date().time - dataHelper.startTime()!!.time
                textSat.text = timeStringFromLong(time)
            }
        }
    }*/

    /*private fun timeStringFromLong(ms: Long): String? {
        val seconds = (ms / 1000) % 60
        val minutes = ((ms / 1000 * 60) % 60)
        val hours = ((ms / 1000 * 60 * 60 ) % 24 )
        return makeTimeString(hours, minutes, seconds)
    }*/

    /*private fun makeTimeString(hours: Long,  minutes: Long, seconds: Long): String? {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }*/

    /*private fun resetAction() {
        dataHelper.setStopTime(null)
        dataHelper.setStartTime(null)
        stopTimer()

    }*/

    /*private fun stopTimer() {
        dataHelper.setTimerCounting(false)
    }*/
    /*private fun startTimer() {
        dataHelper.setTimerCounting(true)
    }*/

    /*private fun startStopAction() {
        if(dataHelper.timerCounting())
        {
            dataHelper.setStopTime(Date())
            stopTimer()
        }
        else{
            if(dataHelper.stopTime() != null){
                dataHelper.setStartTime(calcResetTime())
                dataHelper.setStopTime(null)
            }
            else{
                dataHelper.setStartTime(Date())
            }
            startTimer()
        }
    }*/

    /*private fun calcResetTime(): Date {
    val diff =  dataHelper.startTime()!!.time - dataHelper.stopTime()!!.time
        return Date(System.currentTimeMillis() + diff )
    }*/
}