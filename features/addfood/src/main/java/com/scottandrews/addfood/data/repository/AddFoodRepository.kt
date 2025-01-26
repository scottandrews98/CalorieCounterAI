package com.scottandrews.addfood.data.repository

import com.scottandrews.addfood.data.gateway.AddFoodGateway
import com.scottandrews.addfood.domain.model.AddFoodModel
import javax.inject.Inject

class AddFoodRepository @Inject constructor(
    private val addFoodGateway: AddFoodGateway
) {
    suspend fun getUsers(): List<AddFoodModel> = addFoodGateway.getUsers()
}