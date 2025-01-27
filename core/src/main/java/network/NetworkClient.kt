package network

interface NetworkClient {
    suspend fun <T> makeRequest(
        request: NetworkRequest,
        responseType: Class<T>
    ): T
}