package com.example.kotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Answer")
data class Answer(
    @PrimaryKey(autoGenerate = true)
    val id :Int?=null,

    val totalAnswer:Int,
    val rightAnswer:Int
)
