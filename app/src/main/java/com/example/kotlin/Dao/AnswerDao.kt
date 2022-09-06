package com.example.kotlin.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin.model.Answer

@Dao
interface AnswerDao {
    @Insert
    fun insert(answer: Answer)

    @Query("SELECT * FROM Answer WHERE id=:id")
    fun getUserAnswers (id:Int): Answer


}