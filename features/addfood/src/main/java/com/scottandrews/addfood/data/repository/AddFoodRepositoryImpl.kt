package com.scottandrews.addfood.data.repository

import com.scottandrews.addfood.data.mapper.AddFoodMapper
import com.scottandrews.addfood.data.model.AddFoodModel
import com.scottandrews.addfood.domain.repository.AddFoodRepository
import services.httpServices.addFoodService.AddFoodService
import services.httpServices.addFoodService.request.BarcodeRequest
import javax.inject.Inject


class AddFoodRepositoryImpl @Inject constructor(
    private val addFoodService: AddFoodService,
): AddFoodRepository {

    override suspend fun getFood(): AddFoodModel {
        val barcodeRequest = BarcodeRequest(barcode = "737628064502")

        val response = addFoodService.makeBarcodeRequest(barcodeRequest)

        return AddFoodMapper.mapToFood(response)
    }
}