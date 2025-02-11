package com.scottandrews.caloriecounterai.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import network.HTTPClient
import services.httpServices.addFoodService.AddFoodService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Provides
    @Singleton
    fun provideAddFoodService(httpClient: HTTPClient): AddFoodService {
        return AddFoodService(httpClient)
    }
}