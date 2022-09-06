package com.example.kotlin.Dao

import androidx.room.*
import com.example.kotlin.model.Quiz

@Dao
interface QuizDao {

    @Insert
    fun insert(quiz: Quiz)

    @Query("SELECT * FROM Quiz")
    fun getAllQuiz():List<Quiz>

    @Delete
    fun delete(quiz: Quiz)

    @Update
    fun update(quiz: Quiz)

    @Query("DELETE FROM Quiz")
    fun deleteAll()
}