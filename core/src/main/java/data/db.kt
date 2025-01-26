package data

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow


@Database(entities = [GolfDistanceData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clubsDao(): GolfDistanceDao
}

@Dao
interface GolfDistanceDao {
    @Query("SELECT * FROM GolfDistanceData")
    fun getAll(): Flow<List<GolfDistanceData>>

    @Query("SELECT * FROM GolfDistanceData WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<GolfDistanceData>

//    @Query("SELECT * FROM GolfDistanceData WHERE club_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): GolfDistanceData

    @Insert
    suspend fun insertAll(vararg users: GolfDistanceData)

    @Delete
    fun delete(user: GolfDistanceData)
}

@Entity
data class GolfDistanceData(
    @PrimaryKey(autoGenerate = true) val uid: Int  = 0,
    @ColumnInfo(name = "club_name") val clubName: String?,
    @ColumnInfo(name = "distance") val distance: Float?
)