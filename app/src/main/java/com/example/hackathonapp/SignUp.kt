package com.example.hackathonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import com.vishnusivadas.advanced_httpurlconnection.PutData

class SignUp : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val fullname_input = findViewById<EditText>(R.id.FullName_input)
        val email_input = findViewById<EditText>(R.id.email_input)
        val username_input = findViewById<EditText>(R.id.username_input)
        val password_input = findViewById<EditText>(R.id.password_input)
        val btn = findViewById<Button>(R.id.SignUp_button)
        val txt = findViewById<TextView>(R.id.text_to_login)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        txt.setOnClickListener{
            val intentt = Intent(this, MainActivity::class.java)
            startActivity(intentt)
            finish()
        }

        btn.setOnClickListener {


            val fullname = fullname_input.text.toString()
            val email = email_input.text.toString()
            val username = username_input.text.toString()
            val password = password_input.text.toString()
            if (fullname.isNotEmpty() && email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty())
            {
                progressBar.visibility = View.VISIBLE
                val handlerr = Handler(Looper.getMainLooper())
                handlerr.post{
                    val field = arrayOfNulls<String>(4)
                    field[0] = "fullname"
                    field[1] = "username"
                    field[2] = "password"
                    field[3] = "email"
                    val data = arrayOfNulls<String>(4)
                    data[0] = fullname
                    data[1] = username
                    data[2] = password
                    data[3] = email
                    val putData = PutData(
                        "http://192.168.43.226/loginregister/signup.php",
                        "POST",
                        field,
                        data
                    )
                    if (putData.startPut())
                    {
                        if (putData.onComplete())
                        {
                            progressBar.visibility = View.GONE
                            val result = putData.result
                            if (result.toString() == "Sign Up Success"){
                                Toast.makeText(this,result,Toast.LENGTH_LONG).show()
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            else{
                                Toast.makeText(this,result,Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
            }
        }

    }


}