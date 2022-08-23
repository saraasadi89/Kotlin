package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var bind: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Student","there is not")
        super.onCreate(savedInstanceState)
        bind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.editText1.setText("User name")
        bind.editText2.setText("password")
        bind.textButton1.setOnClickListener {
            val username = bind.editText1.text.toString()
            val pass = bind.editText2.text.toString()
            if (username == "Teacher" && pass == "123456")
//                Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show()
                intent = Intent(applicationContext, Teacher::class.java)
            startActivity(intent)
        }
        bind.textButton2.setOnClickListener {
            val username = bind.editText1.text.toString()
            val pass = bind.editText2.text.toString()
            if (username == "Student" && pass == "123456") {
                intent = Intent(applicationContext, Student::class.java)
                startActivity(intent)
            }
        }
    }

}