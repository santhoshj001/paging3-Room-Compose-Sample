package com.teamb.paging3roomsample.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentEntity::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}