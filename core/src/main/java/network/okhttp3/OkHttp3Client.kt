package network.okhttp3

import network.HTTPClient
import network.HTTPRequest
import network.HTTPResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

class OkHttp3Client @Inject constructor(
    private val okHttpClient: OkHttpClient,
) : HTTPClient {

    override suspend fun makeRequest(
        request: HTTPRequest,
    ): HTTPResponse {
        val builder = Request.Builder()
            .url(request.url)

        // Set headers
        request.headers.forEach { (key, value) ->
            builder.addHeader(key, value)
        }

        // Set method and body
//        val requestBody = request.body?.let {
//            gson.toJson(it).toRequestBody("application/json".toMediaType())
//        }
//        when (request.method) {
//            HttpMethod.GET -> builder.get()
//            HttpMethod.POST -> builder.post(requestBody ?: "".toRequestBody())
//            HttpMethod.PUT -> builder.put(requestBody ?: "".toRequestBody())
//            HttpMethod.DELETE -> builder.delete(requestBody)
//            HttpMethod.PATCH -> builder.patch(requestBody ?: "".toRequestBody())
//        }

        val response = okHttpClient.newCall(builder.build()).execute()
        if (!response.isSuccessful) {
            throw Exception("Request failed with code: ${response.code}")
        }

        return HTTPResponse(response.body?.bytes(), response.code)
    }
}