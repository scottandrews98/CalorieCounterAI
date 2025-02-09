    package di

    import android.content.Context
    import androidx.room.Room
    import dagger.Module
    import dagger.Provides
    import dagger.hilt.InstallIn
    import dagger.hilt.android.qualifiers.ApplicationContext
    import dagger.hilt.components.SingletonComponent
    import data.AppDatabase
    import data.ClubsDataRepository
    import data.ClubsRepository
    import data.GolfDistanceDao
    import javax.inject.Singleton

    @Module
    @InstallIn(SingletonComponent::class)
    object RepositoryModule {

        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "golfClubs"
            ).build()
        }

        @Provides
        fun provideGolfDistanceDao(database: AppDatabase): GolfDistanceDao {
            return database.clubsDao()
        }

        @Provides
        fun provideClubsRepository(clubsDao: GolfDistanceDao): ClubsRepository {
            return ClubsDataRepository(clubsDao)
        }
    }