package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {
    private lateinit var bind: ActivityStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnExit.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        bind.btnStartQuiz.setOnClickListener{
            intent= Intent(this, StartQuizActivity::class.java)
            startActivity(intent)
        }
    }
}