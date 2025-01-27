package com.scottandrews.addfood.data.gateway

import com.scottandrews.addfood.data.AddFoodMapper
import com.scottandrews.addfood.domain.model.AddFoodModel
import network.HttpMethod
import network.NetworkClient
import network.NetworkRequest
import javax.inject.Inject
import javax.inject.Named

interface AddFoodGateway {
    suspend fun getUsers(): List<AddFoodModel>
}

class AddFoodGatewayImpl @Inject constructor(
    @Named("OkHttp") private val networkClient: NetworkClient,
    private val mapper: AddFoodMapper
) : AddFoodGateway {

    override suspend fun getUsers(): List<AddFoodModel> {
        val request = NetworkRequest(
            url = "https://test.com",
            method = HttpMethod.GET
        )

        networkClient.makeRequest(request)

        return apiService.getUsers().map { mapper.mapToDomain(it) }
    }
}