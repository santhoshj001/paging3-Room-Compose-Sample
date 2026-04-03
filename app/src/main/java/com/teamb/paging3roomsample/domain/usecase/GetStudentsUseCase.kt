package com.teamb.paging3roomsample.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.teamb.paging3roomsample.data.StudentRepository
import com.teamb.paging3roomsample.data.toDomain
import com.teamb.paging3roomsample.domain.model.StudentUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetStudentsUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    operator fun invoke(): Flow<PagingData<StudentUiModel>> {
        return Pager(
            config = PagingConfig(pageSize = 20) // Configuring the paging
        ) {
            studentRepository.getAllStudents() // Fetches PagingSource<Int, StudentEntity>
        }.flow.map { pagingData ->
            pagingData.map { entity ->
                entity.toDomain() // Transform entity to domain model here
            }
        }
    }
}