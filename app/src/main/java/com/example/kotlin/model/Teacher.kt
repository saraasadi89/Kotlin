package com.example.kotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Teacher")
data class Teacher(

    @PrimaryKey(autoGenerate = true)
    val id :Int?=null,

    val userName:String,
    val password:String
)
