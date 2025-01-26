package data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ClubsDataRepository @Inject constructor(private val clubsDao: GolfDistanceDao): ClubsRepository {

    override fun getClubs(): Flow<List<GolfDistanceData>> {
        return clubsDao.getAll()
    }

    override suspend fun insertClub(club: GolfDistanceData) {
        clubsDao.insertAll(club)
    }
}

interface ClubsRepository {
    fun getClubs(): Flow<List<GolfDistanceData>>
    suspend fun insertClub(club: GolfDistanceData)
}