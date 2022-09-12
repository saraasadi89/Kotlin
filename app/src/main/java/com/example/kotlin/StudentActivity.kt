package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.databinding.ActivityStudentBinding
import com.tumblr.remember.Remember

class StudentActivity : AppCompatActivity() {

    private lateinit var bind: ActivityStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnExit.setOnClickListener {

            Remember.putInt(LoginActivity.rememberId,-1)
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        bind.btnStartQuiz.setOnClickListener{
            intent= Intent(this, StartQuizActivity::class.java)
            startActivity(intent)
        }
    }
}