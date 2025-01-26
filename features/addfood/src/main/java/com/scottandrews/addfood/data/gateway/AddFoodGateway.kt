package com.scottandrews.addfood.data.gateway

import com.scottandrews.addfood.domain.model.AddFoodModel
import javax.inject.Inject

interface AddFoodGateway {
    suspend fun getUsers(): List<AddFoodModel>
}

class AddFoodGatewayImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: UserMapper
) : AddFoodGateway {

    override suspend fun getUsers(): List<AddFoodModel> {
        return apiService.getUsers().map { mapper.mapToDomain(it) }
    }
}