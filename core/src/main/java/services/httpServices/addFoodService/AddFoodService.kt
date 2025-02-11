package services.httpServices.addFoodService

import com.google.gson.Gson
import network.HTTPClient
import network.HTTPRequest
import network.HttpMethod
import services.httpServices.addFoodService.request.BarcodeRequest
import services.httpServices.addFoodService.response.BarcodeResponse
import java.nio.charset.Charset
import javax.inject.Inject
import javax.inject.Named

class AddFoodService@Inject constructor(
    @Named("OkHttp") private val networkClient: HTTPClient,
) {

    suspend fun makeBarcodeRequest(request: BarcodeRequest): BarcodeResponse{

        val requestObject = HTTPRequest(
            url = "https://world.openfoodfacts.org/api/v3/product/${request.barcode}?fields=nutriments",
            method = HttpMethod.GET
        )

        val response = networkClient.makeRequest(requestObject)

        return Gson().fromJson(response.respose?.toString(Charset.defaultCharset()), BarcodeResponse::class.java)
    }
}