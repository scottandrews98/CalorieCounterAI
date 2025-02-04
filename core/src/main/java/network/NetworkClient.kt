package network

interface NetworkClient {
    suspend fun makeRequest(
        request: NetworkRequest,
    ): NetworkResponse
}