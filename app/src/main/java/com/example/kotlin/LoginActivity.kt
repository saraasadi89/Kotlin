package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin.databinding.ActivityLoginBinding
import com.example.kotlin.model.Student
import com.tumblr.remember.Remember

class LoginActivity : AppCompatActivity() {
    private lateinit var bind: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val studentDao = MyDatabase.getDatabase(this).studentDao


        //inits remember
        Remember.init(applicationContext, "com.example.kotlin")


        bind = ActivityLoginBinding.inflate(layoutInflater)
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

            val student=studentDao.login(username,pass)

////TODO unfawear

            if (student!=null) {
                intent = Intent(applicationContext, StudentActivity::class.java)
                startActivity(intent)
            }else
                Toast.makeText(this, "wrong user or pass", Toast.LENGTH_SHORT).show()

        }
        bind.btnSwitch.setOnClickListener{
            intent = Intent(applicationContext, RegesterActivity::class.java)
            startActivity(intent)
        }


    }

}