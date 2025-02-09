package com.scottandrews.addfood.presentation

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.scottandrews.addfood.data.model.AddFoodModel

@Composable
fun AddFoodView(viewModel: AddFoodViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.observeAsState()

    when (uiState) {
        is UiState.Loading -> CircularProgressIndicator()
        is UiState.Success -> Text("Success: ${((uiState as UiState.Success<AddFoodModel>).data.protein)}")
        is UiState.Error -> Text("Error: ${(uiState as UiState.Error).message}")
        null -> Text("NULL")
    }
}