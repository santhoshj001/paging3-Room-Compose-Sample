package com.teamb.paging3roomsample.data

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao {
    @Query("SELECT * FROM students")
    fun getAllStudents(): PagingSource<Int, StudentEntity>

    @Insert
    suspend fun insert(student: StudentEntity)

    @Update
    suspend fun update(student: StudentEntity)

    @Delete
    suspend fun delete(student: StudentEntity)
}