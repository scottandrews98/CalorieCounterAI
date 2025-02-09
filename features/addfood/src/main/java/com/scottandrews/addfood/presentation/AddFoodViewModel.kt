package com.scottandrews.addfood.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scottandrews.addfood.data.model.AddFoodModel
import com.scottandrews.addfood.domain.usecase.AddFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class AddFoodViewModel @Inject constructor(private val useCase: AddFoodUseCase): ViewModel() {

    private val _uiState = MutableLiveData<UiState<AddFoodModel>>()
    val uiState: LiveData<UiState<AddFoodModel>> = _uiState

    init {
        fetchFeatureAData()
    }

    private fun fetchFeatureAData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                withContext(Dispatchers.Main) {
                    _uiState.value = UiState.Loading
                }

                val data = useCase.invoke()

                withContext(Dispatchers.Main) {
                    _uiState.value = UiState.Success(data)
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _uiState.value = UiState.Error(e.message ?: "Unknown error")
                }

            }
        }
    }
}