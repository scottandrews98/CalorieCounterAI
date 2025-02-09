package com.scottandrews.addfood.di

import com.scottandrews.addfood.data.repository.AddFoodRepositoryImpl
import com.scottandrews.addfood.domain.usecase.AddFoodUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import network.HTTPClient

@Module
@InstallIn(SingletonComponent::class)
object AddFoodModule {

    @Provides
    fun provideAddFoodRepository(httpClient: HTTPClient): AddFoodRepositoryImpl {
        return AddFoodRepositoryImpl(httpClient)
    }

    @Provides
    fun provideAddFoodUseCase(repository: AddFoodRepositoryImpl): AddFoodUseCase {
        return AddFoodUseCase(repository)
    }
}