package com.scottandrews.addfood.domain.model

data class AddFoodModel(
    val id: Int,
    val name: String,
    val email: String,
    val createdAt: String // Example: "Jan 1, 2025"
)