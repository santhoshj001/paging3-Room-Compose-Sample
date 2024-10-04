package com.teamb.paging3roomsample.data

import androidx.paging.PagingSource

interface StudentRepository {
    fun getAllStudents(): PagingSource<Int, StudentEntity>
}