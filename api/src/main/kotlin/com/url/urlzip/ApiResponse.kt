package com.url.urlzip

data class ApiResponse<t> (
    val code: String = "success",
    val message: String = "your request processed successfully",
    val data: t
)
