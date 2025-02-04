package com.scottandrews.addfood.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddFoodViewRoot(
    addFoodViewModel: AddFoodViewModel = hiltViewModel()
){
    Text("SCOTT THIS SHOWS")
}

class AddFoodView {
}