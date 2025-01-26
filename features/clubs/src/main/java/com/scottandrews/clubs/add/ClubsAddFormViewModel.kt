package com.scottandrews.clubs.add

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.ClubsDataRepository
import data.GolfDistanceData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableFloatStateOf
import data.ClubsRepository
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class ClubsAddFormViewModel @Inject constructor(repository: ClubsRepository): ViewModel() {

    private var _clubName = mutableStateOf("")
    private var _distance = mutableFloatStateOf(0f)
    private val repo = repository

    var onCloseBottomSheet: (() -> Unit)? = null

    fun requestClose() {
        viewModelScope.launch {
            onCloseBottomSheet?.invoke()
        }
    }

    val clubName: State<String> get() = _clubName
    val clubDistance: State<Float> get() = _distance

    fun setClubName(clubName: String) {
        _clubName.value = clubName
    }

    fun setClubDistance(clubDistance: String) {
        _distance.floatValue = clubDistance.filter { it.isDigit() }.toFloat()
    }

    fun addClub() {
        onCloseBottomSheet?.invoke()
        val golfDistanceData = GolfDistanceData(clubName = _clubName.value, distance =  _distance.value)
        viewModelScope.launch {
            repo.insertClub(golfDistanceData)
        }
    }
}