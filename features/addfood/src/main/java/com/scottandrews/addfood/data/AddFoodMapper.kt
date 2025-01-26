package com.scottandrews.addfood.data

class AddFoodMapper {
    fun mapToDomain(userDto: UserDto): User {
        return User(
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