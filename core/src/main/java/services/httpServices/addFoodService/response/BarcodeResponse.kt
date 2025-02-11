package services.httpServices.addFoodService.response

import com.google.gson.annotations.SerializedName

data class BarcodeResponse(
    val code: String,
    val errors: List<Any?>,
    val product: Product,
    val result: Result,
    val status: String,
    val warnings: List<Warning>,
)

data class Product(
    val nutriments: Nutriments,
)

data class Nutriments(
    val calcium: Double,
    @SerializedName("calcium_100g")
    val calcium100g: Double,
    @SerializedName("calcium_serving")
    val calciumServing: Double,
    @SerializedName("calcium_unit")
    val calciumUnit: String,
    @SerializedName("calcium_value")
    val calciumValue: Long,
    val carbohydrates: Double,
    @SerializedName("carbohydrates_100g")
    val carbohydrates100g: Double,
    @SerializedName("carbohydrates_serving")
    val carbohydratesServing: Long,
    @SerializedName("carbohydrates_unit")
    val carbohydratesUnit: String,
    @SerializedName("carbohydrates_value")
    val carbohydratesValue: Double,
    val cholesterol: Long,
    @SerializedName("cholesterol_100g")
    val cholesterol100g: Long,
    @SerializedName("cholesterol_serving")
    val cholesterolServing: Long,
    @SerializedName("cholesterol_unit")
    val cholesterolUnit: String,
    @SerializedName("cholesterol_value")
    val cholesterolValue: Long,
    val energy: Long,
    @SerializedName("energy-kcal")
    val energyKcal: Long,
    @SerializedName("energy-kcal_100g")
    val energyKcal100g: Long,
    @SerializedName("energy-kcal_serving")
    val energyKcalServing: Long,
    @SerializedName("energy-kcal_unit")
    val energyKcalUnit: String,
    @SerializedName("energy-kcal_value")
    val energyKcalValue: Long,
    @SerializedName("energy-kcal_value_computed")
    val energyKcalValueComputed: Double,
    @SerializedName("energy_100g")
    val energy100g: Long,
    @SerializedName("energy_serving")
    val energyServing: Long,
    @SerializedName("energy_unit")
    val energyUnit: String,
    @SerializedName("energy_value")
    val energyValue: Long,
    val fat: Double,
    @SerializedName("fat_100g")
    val fat100g: Double,
    @SerializedName("fat_serving")
    val fatServing: Long,
    @SerializedName("fat_unit")
    val fatUnit: String,
    @SerializedName("fat_value")
    val fatValue: Double,
    val fiber: Double,
    @SerializedName("fiber_100g")
    val fiber100g: Double,
    @SerializedName("fiber_serving")
    val fiberServing: Double,
    @SerializedName("fiber_unit")
    val fiberUnit: String,
    @SerializedName("fiber_value")
    val fiberValue: Double,
    @SerializedName("fruits-vegetables-legumes-estimate-from-ingredients_100g")
    val fruitsVegetablesLegumesEstimateFromIngredients100g: Double,
    @SerializedName("fruits-vegetables-legumes-estimate-from-ingredients_serving")
    val fruitsVegetablesLegumesEstimateFromIngredientsServing: Double,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")
    val fruitsVegetablesNutsEstimateFromIngredients100g: Double,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_serving")
    val fruitsVegetablesNutsEstimateFromIngredientsServing: Double,
    val iron: Double,
    @SerializedName("iron_100g")
    val iron100g: Double,
    @SerializedName("iron_serving")
    val ironServing: Double,
    @SerializedName("iron_unit")
    val ironUnit: String,
    @SerializedName("iron_value")
    val ironValue: Double,
    @SerializedName("nova-group")
    val novaGroup: Long,
    @SerializedName("nova-group_100g")
    val novaGroup100g: Long,
    @SerializedName("nova-group_serving")
    val novaGroupServing: Long,
    @SerializedName("nutrition-score-fr")
    val nutritionScoreFr: Long,
    @SerializedName("nutrition-score-fr_100g")
    val nutritionScoreFr100g: Long,
    val proteins: Double,
    @SerializedName("proteins_100g")
    val proteins100g: Double,
    @SerializedName("proteins_serving")
    val proteinsServing: Long,
    @SerializedName("proteins_unit")
    val proteinsUnit: String,
    @SerializedName("proteins_value")
    val proteinsValue: Double,
    val salt: Double,
    @SerializedName("salt_100g")
    val salt100g: Double,
    @SerializedName("salt_serving")
    val saltServing: Double,
    @SerializedName("salt_unit")
    val saltUnit: String,
    @SerializedName("salt_value")
    val saltValue: Long,
    @SerializedName("saturated-fat")
    val saturatedFat: Double,
    @SerializedName("saturated-fat_100g")
    val saturatedFat100g: Double,
    @SerializedName("saturated-fat_serving")
    val saturatedFatServing: Double,
    @SerializedName("saturated-fat_unit")
    val saturatedFatUnit: String,
    @SerializedName("saturated-fat_value")
    val saturatedFatValue: Double,
    val sodium: Double,
    @SerializedName("sodium_100g")
    val sodium100g: Double,
    @SerializedName("sodium_serving")
    val sodiumServing: Double,
    @SerializedName("sodium_unit")
    val sodiumUnit: String,
    @SerializedName("sodium_value")
    val sodiumValue: Long,
    val sugars: Double,
    @SerializedName("sugars_100g")
    val sugars100g: Double,
    @SerializedName("sugars_serving")
    val sugarsServing: Long,
    @SerializedName("sugars_unit")
    val sugarsUnit: String,
    @SerializedName("sugars_value")
    val sugarsValue: Double,
    @SerializedName("trans-fat")
    val transFat: Long,
    @SerializedName("trans-fat_100g")
    val transFat100g: Long,
    @SerializedName("trans-fat_serving")
    val transFatServing: Long,
    @SerializedName("trans-fat_unit")
    val transFatUnit: String,
    @SerializedName("trans-fat_value")
    val transFatValue: Long,
    @SerializedName("vitamin-a")
    val vitaminA: Double,
    @SerializedName("vitamin-a_100g")
    val vitaminA100g: Double,
    @SerializedName("vitamin-a_serving")
    val vitaminAServing: Double,
    @SerializedName("vitamin-a_unit")
    val vitaminAUnit: String,
    @SerializedName("vitamin-a_value")
    val vitaminAValue: Long,
    @SerializedName("vitamin-c")
    val vitaminC: Long,
    @SerializedName("vitamin-c_100g")
    val vitaminC100g: Long,
    @SerializedName("vitamin-c_serving")
    val vitaminCServing: Long,
    @SerializedName("vitamin-c_unit")
    val vitaminCUnit: String,
    @SerializedName("vitamin-c_value")
    val vitaminCValue: Long,
)

data class Result(
    val id: String,
    @SerializedName("lc_name")
    val lcName: String,
    val name: String,
)

data class Warning(
    val field: Field,
    val impact: Impact,
    val message: Message,
)

data class Field(
    val id: String,
    val value: String,
)

data class Impact(
    val id: String,
    @SerializedName("lc_name")
    val lcName: String,
    val name: String,
)

data class Message(
    val id: String,
    @SerializedName("lc_name")
    val lcName: String,
    val name: String,
)
