package data.mappers

import domain.models.AddFoodModel
import org.json.JSONObject

class AddFoodMapper {
    fun mapToFood(response: ByteArray): AddFoodModel {

        val jsonObject = JSONObject(response.toString())

        val productObject = jsonObject.getJSONObject("product")
        val nutrimentsObject = productObject.getJSONObject("nutriments")
        val protiens = nutrimentsObject.getDouble("proteins")
        val energy = nutrimentsObject.getDouble("energy-kcal")

        return AddFoodModel(
            barcode = jsonObject.getString("code"),
            protein = protiens,
            kcal = energy
        )
    }
}