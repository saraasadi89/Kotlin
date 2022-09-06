package com.example.kotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlin.model.*

@Database(version = 1, exportSchema = false, entities = [Quiz::class,Student::class,Answer::class])
abstract class MyDatabase : RoomDatabase() {
    abstract val quizDao: QuizDao
    abstract val studentDao: StudentDao
    abstract val answerDao: AnswerDao


    companion object {
        var myDatabase: MyDatabase? = null
        fun getDatabase(context: Context):MyDatabase {
            if (myDatabase == null)
                myDatabase = Room.databaseBuilder(context, MyDatabase::class.java, "MyDatabase.db")
                    .allowMainThreadQueries().build()
            return myDatabase!!
        }

    }
}