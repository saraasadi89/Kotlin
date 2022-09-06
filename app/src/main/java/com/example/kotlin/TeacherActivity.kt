package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.databinding.ActivityLoginBinding
import com.example.kotlin.databinding.ActivityTeacherBinding

class TeacherActivity : AppCompatActivity() {
    private lateinit var bind: ActivityTeacherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTeacherBinding.inflate(layoutInflater)
        setContentView(bind.root)
        //TODO direkt login after regester
        bind.fabExit.setOnClickListener {
            finish()
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)


        }
        bind.fabAdd.setOnClickListener {
            intent = Intent(this,CreateActivity::class.java)
            startActivity(intent)
        }
    }
}