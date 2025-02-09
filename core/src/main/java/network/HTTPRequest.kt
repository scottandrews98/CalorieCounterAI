package network


data class HTTPRequest(
    val url: String,
    val method: HttpMethod,
    val headers: Map<String, String> = emptyMap(),
    val body: Any? = null
)

enum class HttpMethod {
    GET, POST, PUT, DELETE, PATCH
}