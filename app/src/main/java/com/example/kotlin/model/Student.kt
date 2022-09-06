package com.example.kotlin.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class Student(

    @PrimaryKey(autoGenerate = true)
    val id :Int?=null,

    var userName:String,
    var password:String
)
