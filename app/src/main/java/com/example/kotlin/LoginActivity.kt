package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin.Dao.StudentDao
import com.example.kotlin.Dao.TeacherDao
import com.example.kotlin.databinding.ActivityLoginBinding
import com.example.kotlin.model.Student
import com.tumblr.remember.Remember

class LoginActivity : AppCompatActivity() {
    private lateinit var bind: ActivityLoginBinding

    lateinit var studentDao: StudentDao
    lateinit var teacherDao: TeacherDao

    companion object {
        val rememberId = "id"
        val rememberType = "type"
    }



     enum class Type {
        STUDENT, TEACHER
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //inits remember
        Remember.init(applicationContext, "com.example.kotlin")



        bind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bind.root)


        studentDao = MyDatabase.getDatabase(this).studentDao
        teacherDao = MyDatabase.getDatabase(this).teacherDao

        studentButton()
        teacherButton()

        bind.btnSwitch.setOnClickListener {
            intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

    fun gotoActivityIfLogged() {
        val id = Remember.getInt(rememberId, -1)
        if (id != -1) {
            val type = Remember.getString(rememberType, "")
            if (type == Type.STUDENT.toString()) {
                val intent = Intent(this, StudentActivity::class.java)
                startActivity(intent)
                finish()
            } else if (type == Type.TEACHER.toString()) {
                val intent = Intent(this, TeacherActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    fun studentButton() {
        bind.btnStudent.setOnClickListener {
            val username = bind.editText1.text.toString()
            val pass = bind.editText2.text.toString()
            val student = studentDao.login(username, pass)


            if (student != null) {
                Remember.putInt(rememberId, student.id!!)
                Remember.putString(rememberType, Type.STUDENT.toString())
                intent = Intent(applicationContext, StudentActivity::class.java)
                startActivity(intent)
                finish()

            } else
                Toast.makeText(this, "wrong user or pass", Toast.LENGTH_SHORT).show()

        }
    }

    fun teacherButton() {

        bind.btnTeacher.setOnClickListener {

            val username = bind.editText1.text.toString()
            val pass = bind.editText2.text.toString()
            val teacher = teacherDao.login(username, pass)

            //checking login
            if (teacher != null) {

                Remember.putInt(rememberId, teacher.id!!)
                Remember.putString(rememberType, Type.TEACHER.toString())
                intent = Intent(applicationContext, TeacherActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "wrong user or pass", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        gotoActivityIfLogged()

    }

}