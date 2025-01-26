package com.scottandrews.clubs.individualView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.ClubsDataRepository
import data.GolfDistanceData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class IndividualClubsViewModel @Inject constructor(repository: ClubsDataRepository): ViewModel() {

    private val _minAge = MutableStateFlow(18)
    @OptIn(ExperimentalCoroutinesApi::class)
//    val users: StateFlow<List<GolfDistanceData>> = _minAge.flatMapLatest { minAge ->
//        repository.getClubs()
//    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val users: StateFlow<List<GolfDistanceData>> =  repository.getClubs()
    .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

//    fun setMinAge(minAge: Int) {
//        _minAge.value = minAge
//    }
}