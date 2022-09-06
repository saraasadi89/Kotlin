package com.example.kotlin.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin.model.Student

@Dao
interface StudentDao {
    @Insert
    fun register (student: Student)


    //todo like changed to =
    @Query("SELECT * FROM Student WHERE userName = :username AND password = :password")
    fun login(username:String, password:String): Student

    //
    @Query("SELECT EXISTS(SELECT * FROM Student WHERE userName = :username)")
    fun userExists(username:String):Boolean




}