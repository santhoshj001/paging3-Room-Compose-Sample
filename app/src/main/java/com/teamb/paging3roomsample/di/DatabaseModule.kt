package com.teamb.paging3roomsample.di

import android.app.Application
import androidx.room.Room
import com.teamb.paging3roomsample.data.StudentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): StudentDatabase {
        return Room.databaseBuilder(
            application,
            StudentDatabase::class.java,
            "student_database"
        ).build()
    }

    @Provides
    fun provideStudentDao(database: StudentDatabase) = database.studentDao()
}