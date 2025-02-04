package domain.models

data class AddFoodModel(
    val barcode: String,
    val protein: Double,
    val kcal: Double,
)