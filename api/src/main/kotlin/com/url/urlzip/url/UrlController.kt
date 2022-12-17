package com.url.urlzip.url

import com.url.urlzip.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlController {
    @PostMapping("/url")
    fun postUrl(@RequestBody request: PostUrlRequest): ApiResponse<String> {

        return ApiResponse(data = request.url)
    }
}
