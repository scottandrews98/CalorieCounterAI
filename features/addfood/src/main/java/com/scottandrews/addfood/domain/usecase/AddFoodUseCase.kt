package com.scottandrews.addfood.domain.usecase

import com.scottandrews.addfood.data.repository.AddFoodRepository
import com.scottandrews.addfood.domain.model.AddFoodModel
import javax.inject.Inject

class AddFoodUseCase @Inject constructor(
    private val addFoodRepository: AddFoodRepository
) {
    suspend operator fun invoke(): List<AddFoodModel> {
        return addFoodRepository.getUsers()
    }
}