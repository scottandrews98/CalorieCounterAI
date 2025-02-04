package com.scottandrews.addfood.data.repository

import data.gateways.AddFoodGateway
import domain.models.AddFoodModel
import javax.inject.Inject

class AddFoodRepository @Inject constructor(
    private val addFoodGateway: AddFoodGateway
) {
    suspend fun getFoodInformation(): AddFoodModel = addFoodGateway.getFoodInformation()
}