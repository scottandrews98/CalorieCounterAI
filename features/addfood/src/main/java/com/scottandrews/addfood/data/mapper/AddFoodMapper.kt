package com.scottandrews.addfood.data.mapper

import com.scottandrews.addfood.data.model.AddFoodModel
import services.httpServices.addFoodService.response.BarcodeResponse

object AddFoodMapper {
    fun mapToFood(response: BarcodeResponse): AddFoodModel {

        val productObject = response.product
        val proteins = productObject.nutriments.proteins
        val energy = productObject.nutriments.energyKcal

        return AddFoodModel(
            barcode = response.code,
            protein = proteins,
            kcal = energy
        )
    }
}