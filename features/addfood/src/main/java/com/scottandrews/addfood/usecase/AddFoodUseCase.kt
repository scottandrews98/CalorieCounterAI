package com.scottandrews.addfood.usecase

import com.scottandrews.addfood.data.repository.AddFoodRepository
import domain.models.AddFoodModel
import javax.inject.Inject

class AddFoodUseCase @Inject constructor(
    private val addFoodRepository: AddFoodRepository
) {
    suspend operator fun invoke(): AddFoodModel {
        return addFoodRepository.getFoodInformation()
    }
}