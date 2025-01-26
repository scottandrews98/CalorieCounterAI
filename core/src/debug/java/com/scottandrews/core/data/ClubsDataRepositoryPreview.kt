package com.scottandrews.core.data


import data.ClubsRepository
import data.GolfDistanceData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject


class ClubsDataRepositoryPreview @Inject constructor(): ClubsRepository {

    private val fakeUsers = listOf(
        GolfDistanceData(uid = 1, clubName = "test",  distance = 1.0f),
    )

    override fun getClubs(): Flow<List<GolfDistanceData>> {
        return flowOf(fakeUsers)
    }

    override suspend fun insertClub(club: GolfDistanceData) {
    }
}