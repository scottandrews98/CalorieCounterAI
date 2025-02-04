package com.scottandrews.addfood.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scottandrews.addfood.usecase.AddFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFoodViewModel @Inject constructor(
    private val getFoodUseCase: AddFoodUseCase
): ViewModel() {

    init {
        viewModelScope.launch {
            fetchFoodInfo()
        }
    }

    suspend fun fetchFoodInfo() {
        print(getFoodUseCase().protein)
    }
}