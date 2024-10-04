package com.teamb.paging3roomsample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.teamb.paging3roomsample.domain.model.StudentUiModel
import com.teamb.paging3roomsample.domain.usecase.GetStudentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class StudentListViewmodel @Inject constructor(
    getStudentsUseCase: GetStudentsUseCase
) : ViewModel() {
    val students: Flow<PagingData<StudentUiModel>> = getStudentsUseCase().cachedIn(viewModelScope)
}