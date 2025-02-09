package com.scottandrews.addfood.domain.usecase

import com.scottandrews.addfood.domain.repository.AddFoodRepository
import com.scottandrews.addfood.data.model.AddFoodModel
import javax.inject.Inject

class AddFoodUseCase @Inject constructor(
    private val addFoodRepository: AddFoodRepository
) {
    // NOTE ONLY NEED A USE CASE IF WE'RE ADDING BUSINESS LOGIC
    suspend operator fun invoke(): AddFoodModel {
        return addFoodRepository.getFood()
    }
}