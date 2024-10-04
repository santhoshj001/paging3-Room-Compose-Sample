package com.teamb.paging3roomsample.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.teamb.paging3roomsample.presentation.viewmodel.StudentListViewmodel


@Composable
fun StudentListScreen(viewModel: StudentListViewmodel = hiltViewModel()) {
    val studentPagingItems = viewModel.students.collectAsLazyPagingItems()
    val TAG = "StudentListScreen"

    LazyColumn {
        if (studentPagingItems.loadState.refresh is LoadState.Loading) {
            Log.i(TAG, "StudentListScreen: Refresh")
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        } else if (studentPagingItems.loadState.refresh is LoadState.Error) {
            Log.i(TAG, "StudentListScreen: Refresh Error")
            item {
                Text("Error loading data")
            }
        }

        items(
            count = studentPagingItems.itemCount
        ) { index ->
            val student = studentPagingItems[index]
            if (student != null) {
                StudentCardView(student)
            }
        }
        if (studentPagingItems.loadState.append is LoadState.Loading) {
            Log.i(TAG, "StudentListScreen: Append")
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        } else if (studentPagingItems.loadState.append is LoadState.Error) {
            Log.i(TAG, "StudentListScreen: Append error")
            item {
                Text("Error loading more data")
            }
        }
    }
}