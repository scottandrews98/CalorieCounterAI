package network

interface HTTPClient {
    suspend fun makeRequest(
        request: HTTPRequest,
    ): HTTPResponse
}