package di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.gateways.AddFoodGateway
import data.gateways.AddFoodGatewayImpl
import data.mappers.AddFoodMapper
import network.NetworkClient

@Module
@InstallIn(SingletonComponent::class)
object GatewayModule {
    @Provides
    fun provideAddFoodGateway(apiService: NetworkClient, userMapper: AddFoodMapper): AddFoodGateway {
        return AddFoodGatewayImpl(apiService, userMapper)
    }

    @Provides
    fun provideAddFoodMapper(): AddFoodMapper {
        return AddFoodMapper()
    }
}