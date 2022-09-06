package com.example.kotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Quiz")
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val id :Int?=null,
    val question: String,
    @ColumnInfo(name="option1")
    val op1: String,
    val op2: String,
    val op3: String,
    val op4: String,
    val answer: Int
)
