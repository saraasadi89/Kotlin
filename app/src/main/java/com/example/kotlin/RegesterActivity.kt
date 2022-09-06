package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin.databinding.ActivityLoginBinding
import com.example.kotlin.databinding.ActivityRegesterBinding
import com.example.kotlin.model.Student
import com.tumblr.remember.Remember

class RegesterActivity : AppCompatActivity() {
    private lateinit var bind: ActivityRegesterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val studentDao = MyDatabase.getDatabase(this).studentDao


        bind = ActivityRegesterBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.editText1.setText("User name")
        bind.editText2.setText("password")

        bind.textButton1.setOnClickListener {
            val username = bind.editText1.text.toString()
            val pass = bind.editText2.text.toString()

            //checking login
            if (username == "Teacher" && pass == "123456") {
                intent = Intent(applicationContext, TeacherActivity::class.java)
                startActivity(intent)
            }
        }
        bind.textButton2.setOnClickListener {
            val username = bind.editText1.text.toString()
            val pass = bind.editText2.text.toString()
            val student = Student(userName = username, password = pass)

            val studentExists = studentDao.userExists(username)


            if (studentExists) {
                Toast.makeText(this, "username is taken", Toast.LENGTH_SHORT).show()
            } else {
                val newStudent = studentDao.register(student)
                finish()
            }

        }
        bind.btnSwitch.setOnClickListener {
            finish()
        }

    }
}
