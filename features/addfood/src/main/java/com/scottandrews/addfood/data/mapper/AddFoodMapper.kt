package com.scottandrews.addfood.data.mapper

import com.scottandrews.addfood.data.model.AddFoodModel
import org.json.JSONObject
import java.nio.charset.Charset

object AddFoodMapper {
    fun mapToFood(response: ByteArray): AddFoodModel {
        val jsonObject = JSONObject(response.toString(Charset.defaultCharset()))

        val productObject = jsonObject.getJSONObject("product")
        val nutrimentsObject = productObject.getJSONObject("nutriments")
        val proteins = nutrimentsObject.getDouble("proteins")
        val energy = nutrimentsObject.getDouble("energy-kcal")

        return AddFoodModel(
            barcode = jsonObject.getString("code"),
            protein = proteins,
            kcal = energy
        )
    }
}