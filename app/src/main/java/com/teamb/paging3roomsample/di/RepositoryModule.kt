package com.teamb.paging3roomsample.di

import com.teamb.paging3roomsample.data.StudentDao
import com.teamb.paging3roomsample.data.StudentRepository
import com.teamb.paging3roomsample.domain.StudentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideStudentRepository(
        dao: StudentDao
    ): StudentRepository {
        return StudentRepositoryImpl(dao)
    }
}
