package com.scottandrews.addfood.data

import com.scottandrews.addfood.domain.model.AddFoodModel

class AddFoodMapper {
    fun mapToDomain(userDto: UserDto): AddFoodModel {
        return AddFoodModel(
            id = userDto.id,
            name = userDto.name,
            email = userDto.email,
            createdAt = formatDate(userDto.createdAt)
        )
    }

    private fun formatDate(rawDate: String): String {
        return rawDate.substring(0, 10) // Example: Simplified date formatting
    }
}