package com.teamb.paging3roomsample.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.teamb.paging3roomsample.domain.model.StudentUiModel

@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val rollNumber: Int
)

fun StudentEntity.toDomain(): StudentUiModel {
    return StudentUiModel(id = id, name = name, rollNumber = rollNumber)
}

fun StudentUiModel.toEntity(): StudentEntity {
    return StudentEntity(id = id, name = name, rollNumber = rollNumber)
}