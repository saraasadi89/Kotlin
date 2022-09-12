package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.kotlin.Dao.QuizDao
import com.example.kotlin.databinding.ActivityLoginBinding
import com.example.kotlin.databinding.ActivityTeacherBinding
import com.tumblr.remember.Remember

class TeacherActivity : AppCompatActivity() {

    private lateinit var bind: ActivityTeacherBinding

    lateinit var quizDao: QuizDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        quizDao = MyDatabase.getDatabase(this).quizDao

        bind = ActivityTeacherBinding.inflate(layoutInflater)
        setContentView(bind.root)



        // direkt login after regester
        bind.fabExit.setOnClickListener {
            Remember.putInt(LoginActivity.rememberId, -1)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        bind.fabAdd.setOnClickListener {
            intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)
        }
    }

    fun refresh() {
        var quizList = quizDao.getAllQuiz()
        var questionList= arrayListOf<String>()
        for (i in quizList.indices){
            questionList.add(quizList[i].question)
        }



        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, questionList)
        bind.lvQuestion.adapter = arrayAdapter
        bind.lvQuestion.setOnItemClickListener { _, _, i, _ ->
          var id= quizList[i].id
            val intent=Intent(this,CreateActivity::class.java)
            intent.putExtra("id",id)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        refresh()
    }
}