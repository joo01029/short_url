package com.url.urlzip

data class ApiResponse<t> (
    val code: String = "success",
    val message: String = "your request processed successfully",
    val data: t? = null
) {
    companion object {
        fun <t> success(data: t): ApiResponse<t> = ApiResponse(data = data)
        fun fail(message: String): ApiResponse<Nothing> = ApiResponse(code = "fail", message = message)
    }
}
