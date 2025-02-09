package com.scottandrews.addfood.domain.repository

import com.scottandrews.addfood.data.model.AddFoodModel

interface AddFoodRepository {
    suspend fun getFood(): AddFoodModel
}