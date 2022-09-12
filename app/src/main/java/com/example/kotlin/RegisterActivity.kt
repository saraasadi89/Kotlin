package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin.Dao.StudentDao
import com.example.kotlin.Dao.TeacherDao
import com.example.kotlin.databinding.ActivityLoginBinding
import com.example.kotlin.databinding.ActivityRegisterBinding
import com.example.kotlin.model.Student
import com.example.kotlin.model.Teacher
import com.tumblr.remember.Remember

class RegisterActivity : AppCompatActivity() {
    private lateinit var bind: ActivityRegisterBinding

    lateinit var studentDao: StudentDao
    lateinit var teacherDao: TeacherDao
    val teacherregister = "teacherregister"
    val studentregister = "studentregister"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        bind = ActivityRegisterBinding.inflate(layoutInflater)
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

                //Login after register
                var teacherRegister = teacherDao.login(username, pass)
                var teacherId = teacherRegister.id
                Remember.putInt(LoginActivity.rememberId, teacherId!!)
                Remember.putString(
                    LoginActivity.rememberType,
                    LoginActivity.Type.TEACHER.toString()
                )

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
                studentDao.register(student)

                //Login after register
                var studentregister = studentDao.login(username, pass)
                var studentId = studentregister.id
                Remember.putInt(LoginActivity.rememberId, studentId!!)
                Remember.putString(
                    LoginActivity.rememberType,
                    LoginActivity.Type.STUDENT.toString()
                )

                finish()


            }

        }
    }


}
