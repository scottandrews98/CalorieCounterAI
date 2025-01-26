package com.scottandrews.clubs.individualView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import data.GolfDistanceData


@Composable
fun IndivdualClubsViewRoot(clubsViewModel: IndividualClubsViewModel = hiltViewModel(), selectedClub: String) {
    val clubs by clubsViewModel.users.collectAsStateWithLifecycle()
    IndividualClubsView(clubs, selectedClub)
}

@Composable
fun IndividualClubsView(
    state: List<GolfDistanceData>,
    selectedClub: String = ""
) {
    Column(
        Modifier
            .padding(10.dp)
    ) {
        Text("Individual Clubs View $selectedClub")
    }
}

@Preview(showBackground = true)
@Composable
fun IndividualClubsViewPreview() {
    IndividualClubsView(
        state = listOf(
            GolfDistanceData(uid = 1, clubName = "test",  distance = 1.0f),
            GolfDistanceData(uid = 2, clubName = "iron",  distance = 1.0f),
            GolfDistanceData(uid = 3, clubName = "driver",  distance = 1.0f),
        )
    )
}