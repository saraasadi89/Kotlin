package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.kotlin.Dao.QuizDao
import com.example.kotlin.databinding.ActivityCreateBinding
import com.example.kotlin.databinding.ActivityTeacherBinding
import com.example.kotlin.model.Quiz

class CreateActivity : AppCompatActivity() {

    private lateinit var bind: ActivityCreateBinding

    lateinit var quizDao: QuizDao
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(bind.root)

        quizDao = MyDatabase.getDatabase(this).quizDao



        var quiz: Quiz
        id = intent.getIntExtra("id", -1)
        if (id != -1) {
            quiz = quizDao.getQuizById(id)
            putQuiz(quiz)
           // Toast.makeText(this , quiz.toString(), Toast.LENGTH_SHORT).show()
            updateQuiz()
        }
        else
            saveQuiz()


    }

    fun findAnswer(): Int {
        var answer = 0
        if (bind.rb1.isChecked) {
            answer = 1
        } else if (bind.rb2.isChecked) {
            answer = 2
        } else if (bind.rb3.isChecked) {
            answer = 3
        } else if (bind.rb4.isChecked) {
            answer = 4
        }

        return answer
    }

    fun saveQuiz() {

        bind.btnCreate.setOnClickListener {
            if (isAllFilled()) {
                val quiz = Quiz(
                    question = bind.etxQuestion.text.toString(),
                    op1 = bind.etxAnswer1.text.toString(),
                    op2 = bind.etxAnswer2.text.toString(),
                    op3 = bind.etxAnswer3.text.toString(),
                    op4 = bind.etxAnswer4.text.toString(),
                    answer = findAnswer()
                )
                quizDao.insert(quiz)
                var result: String
                result = quizDao.getAllQuiz().toString()
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
                finish()
            }
        }

    }

    fun isAllFilled(): Boolean {
        var result = true
        if (bind.etxQuestion.text.toString().isEmpty()) {
            bind.etxQuestion.error = "Please fill this"
            result = false
        }

        if (bind.etxAnswer1.text.toString().isEmpty()) {
            bind.etxAnswer1.error = "Please fill this"
            result = false
        }

        if (bind.etxAnswer2.text.toString().isEmpty()) {
            bind.etxAnswer2.error = "Please fill this"
            result = false
        }

        if (bind.etxAnswer3.text.toString().isEmpty()) {
            bind.etxAnswer3.error = "Please fill this"
            result = false
        }

        if (bind.etxAnswer4.text.toString().isEmpty()) {
            bind.etxAnswer4.error = "Please fill this"
            result = false
        }
        if (findAnswer() == 0) {
            bind.rgAnswer.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            result = false
        }
        return result
    }

    fun putQuiz(quiz: Quiz){
        bind.etxQuestion.setText(quiz.question.toString())
        bind.etxAnswer1.setText(quiz.op1.toString())
        bind.etxAnswer2.setText(quiz.op2.toString())
        bind.etxAnswer3.setText(quiz.op3.toString())
        bind.etxAnswer4.setText(quiz.op4.toString())

        if(quiz.answer==1)
            bind.rb1.performClick()
        else if (quiz.answer==2)
            bind.rb2.performClick()
        else if (quiz.answer==3)
            bind.rb3.performClick()
        else if (quiz.answer==4)
            bind.rb4.performClick()
    }

    fun updateQuiz(){
        bind.btnCreate.setOnClickListener {

            if (isAllFilled()) {
                var quiz = Quiz(
                    question = bind.etxQuestion.text.toString(),
                    op1 = bind.etxAnswer1.text.toString(),
                    op2 = bind.etxAnswer2.text.toString(),
                    op3 = bind.etxAnswer3.text.toString(),
                    op4 = bind.etxAnswer4.text.toString(),
                    answer = findAnswer()
                )

                //id chon az quiz dihjari amade benabarin null mibashad in dastur baraye meghdar dehi be id estefade shode
                quiz.id=id
                Toast.makeText(this,quiz.toString() , Toast.LENGTH_SHORT).show()
                quizDao.update(quiz)
//                var result: String
//                result = quizDao.getAllQuiz().toString()
//                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}