package com.teamb.paging3roomsample.domain

import androidx.paging.PagingSource
import com.teamb.paging3roomsample.data.StudentDao
import com.teamb.paging3roomsample.data.StudentEntity
import com.teamb.paging3roomsample.data.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(private val studentDao: StudentDao) :
    StudentRepository {
    override fun getAllStudents(): PagingSource<Int, StudentEntity> {
        return studentDao.getAllStudents()
    }
}