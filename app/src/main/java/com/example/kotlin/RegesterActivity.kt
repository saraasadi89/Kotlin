package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin.Dao.StudentDao
import com.example.kotlin.Dao.TeacherDao
import com.example.kotlin.databinding.ActivityLoginBinding
import com.example.kotlin.databinding.ActivityRegesterBinding
import com.example.kotlin.model.Student
import com.example.kotlin.model.Teacher
import com.tumblr.remember.Remember

class RegesterActivity : AppCompatActivity() {
    private lateinit var bind: ActivityRegesterBinding

    lateinit var studentDao: StudentDao
    lateinit var teacherDao: TeacherDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        bind = ActivityRegesterBinding.inflate(layoutInflater)
        setContentView(bind.root)

        studentDao = MyDatabase.getDatabase(this).studentDao
        teacherDao = MyDatabase.getDatabase(this).teacherDao

        studentButton()
        teacherButton()

        bind.btnSwitch.setOnClickListener {
            finish()
        }

    }

    fun teacherButton() {
        bind.textButton1.setOnClickListener {
            val username = bind.editText1.text.toString()
            val pass = bind.editText2.text.toString()
            val teacher = Teacher(userName = username, password = pass)
            val teacherExists = teacherDao.userExists(username)

            //checking login
            if (teacherExists) {
                Toast.makeText(this, "username is taken", Toast.LENGTH_SHORT).show()
            } else {
                teacherDao.register(teacher)
                finish()
            }
        }
    }

    fun studentButton() {
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
    }
}
