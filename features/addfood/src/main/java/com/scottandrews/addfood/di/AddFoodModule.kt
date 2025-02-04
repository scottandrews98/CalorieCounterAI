package com.scottandrews.addfood.di

import com.scottandrews.addfood.data.repository.AddFoodRepository
import com.scottandrews.addfood.usecase.AddFoodUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AddFoodViewModel {

    @Provides
    fun provideGetUsersUseCase(userRepository: AddFoodRepository): AddFoodUseCase {
        return AddFoodUseCase(userRepository)
    }
}