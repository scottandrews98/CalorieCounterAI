package data.gateways


import data.mappers.AddFoodMapper
import domain.models.AddFoodModel
import network.HttpMethod
import network.NetworkClient
import network.NetworkRequest
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Named

interface AddFoodGateway {
    suspend fun getFoodInformation(): AddFoodModel
}

class AddFoodGatewayImpl @Inject constructor(
    @Named("OkHttp") private val networkClient: NetworkClient,
    private val mapper: AddFoodMapper
) : AddFoodGateway {

    override suspend fun getFoodInformation(): AddFoodModel {
        val request = NetworkRequest(
            url = "https://test.com",
            method = HttpMethod.GET
        )

        val response = networkClient.makeRequest(request)

        return mapper.mapToFood(response.respose!!)
    }
}