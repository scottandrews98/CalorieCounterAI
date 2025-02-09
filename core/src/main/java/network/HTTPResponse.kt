package network

data class HTTPResponse(
    val respose: ByteArray?,
    val responseCode: Int,
)