package com.scottandrews.addfood.di

import com.scottandrews.addfood.data.repository.AddFoodRepositoryImpl
import com.scottandrews.addfood.domain.usecase.AddFoodUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import network.HTTPClient
import services.httpServices.addFoodService.AddFoodService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AddFoodModule {

    @Provides
    @Singleton
    fun provideAddFoodRepository(addFoodService: AddFoodService): AddFoodRepositoryImpl {
        return AddFoodRepositoryImpl(addFoodService)
    }

    @Provides
    fun provideAddFoodUseCase(repository: AddFoodRepositoryImpl): AddFoodUseCase {
        return AddFoodUseCase(repository)
    }
}