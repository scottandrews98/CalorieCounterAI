package network.okhttp3

import com.google.gson.Gson
import network.HttpMethod
import network.NetworkClient
import network.NetworkRequest
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class Okhttp3Client @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val gson: Gson
) : NetworkClient {

    override suspend fun <T> makeRequest(
        request: NetworkRequest,
        responseType: Class<T>
    ): T {
        val builder = Request.Builder()
            .url(request.url)

        // Set headers
        request.headers.forEach { (key, value) ->
            builder.addHeader(key, value)
        }

        // Set method and body
        val requestBody = request.body?.let {
            gson.toJson(it).toRequestBody("application/json".toMediaType())
        }
        when (request.method) {
            HttpMethod.GET -> builder.get()
            HttpMethod.POST -> builder.post(requestBody ?: "".toRequestBody())
            HttpMethod.PUT -> builder.put(requestBody ?: "".toRequestBody())
            HttpMethod.DELETE -> builder.delete(requestBody)
            HttpMethod.PATCH -> builder.patch(requestBody ?: "".toRequestBody())
        }

        val response = okHttpClient.newCall(builder.build()).execute()
        if (!response.isSuccessful) {
            throw Exception("Request failed with code: ${response.code}")
        }

        return gson.fromJson(response.body?.string(), responseType)
    }
}