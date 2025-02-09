package com.scottandrews.addfood.presentation


sealed class UiState<out T> {
    object Loading : UiState<Nothing>()   // When loading data
    data class Success<AddFoodModel>(val data: AddFoodModel) : UiState<AddFoodModel>()  // When data is successfully loaded
    data class Error(val message: String) : UiState<Nothing>()  // When an error occurs
}