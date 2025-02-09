package com.scottandrews.addfood.data.repository

import com.scottandrews.addfood.data.mapper.AddFoodMapper
import com.scottandrews.addfood.data.model.AddFoodModel
import com.scottandrews.addfood.domain.repository.AddFoodRepository
import network.HTTPClient
import network.HTTPRequest
import network.HttpMethod
import javax.inject.Inject
import javax.inject.Named


class AddFoodRepositoryImpl @Inject constructor(
    @Named("OkHttp") private val networkClient: HTTPClient,
): AddFoodRepository {

    override suspend fun getFood(): AddFoodModel {
        val request = HTTPRequest(
            url = "https://world.openfoodfacts.org/api/v3/product/737628064502?fields=nutriments",
            method = HttpMethod.GET
        )

        val response = networkClient.makeRequest(request)

        return AddFoodMapper.mapToFood(response.respose!!)
    }
}