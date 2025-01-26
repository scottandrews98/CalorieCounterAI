package com.scottandrews.clubs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import data.GolfDistanceData


@Composable
fun ClubsViewRoot(
    navigateToClub: (String) -> Unit,
    clubsViewModel: ClubsViewModel = hiltViewModel()) {
    val clubs by clubsViewModel.users.collectAsStateWithLifecycle()
    ClubsView(clubs, navigateToClub)
}

@Composable
fun ClubsView(
    state: List<GolfDistanceData>,
    navigateToClub: (String) -> Unit
) {
    Column(
        Modifier
            .padding(10.dp)
    ) {
        LazyColumn {
            state.forEach {
                item {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 5.dp)
                            .background(Color.DarkGray)
                            .clickable { navigateToClub(it.uid.toString()) },
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .height(70.dp)
                                .padding(start = 10.dp, end = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                            ) {
                            Text(
                                text = it.clubName.toString(),
                                color = Color.White,
                                textAlign = TextAlign.Center,
                            )
                        }

                        Box(
                            Modifier
                                .padding(10.dp)
                                .background(Color.Gray, shape = RoundedCornerShape(12.dp))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(it.distance.toString(),
                                Modifier
                                    .background(Color.Gray),
                                textAlign = TextAlign.Center,
                                fontSize = TextUnit(20f, TextUnitType.Sp),
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClubsViewPreview() {
    ClubsView(
        state = listOf(
            GolfDistanceData(uid = 1, clubName = "test",  distance = 1.0f),
            GolfDistanceData(uid = 2, clubName = "iron",  distance = 1.0f),
            GolfDistanceData(uid = 3, clubName = "driver",  distance = 1.0f),
        ),
        navigateToClub = {}
    )
}