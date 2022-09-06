package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin.model.Quiz

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        val quiz = Quiz(question = "q", op1 = "o1", op2 = "o2", op3 = "o3", op4 = "o4", answer = 2)
        val quizDao = MyDatabase.getDatabase(this).quizDao
        quizDao.insert(quiz)
        Toast.makeText(this, quizDao.getAllQuiz()[0].question, Toast.LENGTH_SHORT).show()

    }
}