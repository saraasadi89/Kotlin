package com.example.kotlin.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnswerDao {
    @Insert
    fun insert(answer: Answer)

    @Query("SELECT * FROM Answer WHERE id=:id")
    fun getUserAnswers (id:Int):Answer


}