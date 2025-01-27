package network.retrofitClient

import network.HttpMethod
import network.NetworkClient
import network.NetworkRequest
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Url
import javax.inject.Inject

class RetrofitClient @Inject constructor(
    private val retrofit: Retrofit
) : NetworkClient {

    override suspend fun <T> makeRequest(
        request: NetworkRequest,
        responseType: Class<T>
    ): T {
        // Build a dynamic request using Retrofit's support for annotations
        val dynamicService = retrofit.create(DynamicService::class.java)
        val response = when (request.method) {
            HttpMethod.GET -> dynamicService.get(request.url, request.headers)
            HttpMethod.POST -> dynamicService.post(request.url, request.body, request.headers)
            HttpMethod.PUT -> dynamicService.put(request.url, request.body, request.headers)
            HttpMethod.DELETE -> dynamicService.delete(request.url, request.headers)
            HttpMethod.PATCH -> dynamicService.patch(request.url, request.body, request.headers)
        }

        return response as T // Retrofit handles JSON parsing automatically
    }

    interface DynamicService {
        @GET
        suspend fun get(
            @Url url: String,
            @HeaderMap headers: Map<String, String>
        ): Any

        @POST
        suspend fun post(
            @Url url: String,
            @Body body: Any?,
            @HeaderMap headers: Map<String, String>
        ): Any

        @PUT
        suspend fun put(
            @Url url: String,
            @Body body: Any?,
            @HeaderMap headers: Map<String, String>
        ): Any

        @DELETE
        suspend fun delete(
            @Url url: String,
            @HeaderMap headers: Map<String, String>
        ): Any

        @PATCH
        suspend fun patch(
            @Url url: String,
            @Body body: Any?,
            @HeaderMap headers: Map<String, String>
        ): Any
    }
}