package com.scottandrews.addfood.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AddFoodModule {
    @Provides
    fun provideUserGateway(apiService: ApiService, userMapper: UserMapper): UserGateway {
        return UserGatewayImpl(apiService, userMapper)
    }

    @Provides
    fun provideUserRepository(userGateway: UserGateway): UserRepository {
        return UserRepository(userGateway)
    }
}