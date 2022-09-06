package com.example.kotlin.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin.model.Teacher

@Dao
interface TeacherDao {

    @Insert
    fun register(teacher: Teacher)

    @Query("SELECT * FROM Teacher WHERE userName=:userName AND password=:password")
    fun login(userName: String,password:String):Teacher

    @Query("SELECT EXISTS(SELECT * FROM Teacher WHERE userName=:userName)")
    fun userExists(userName: String):Boolean

}