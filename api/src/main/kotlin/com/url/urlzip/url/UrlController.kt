package com.url.urlzip.url

import com.url.urlzip.ApiResponse
import com.url.urlzip.url.domain.Url
import com.url.urlzip.url.domain.UrlService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlController(
    private val urlService: UrlService
) {
    @PostMapping("/url")
    fun postUrl(@Validated @RequestBody request: PostUrlRequest): ApiResponse<String> {
        val result = urlService.saveUrl(Url(request.url!!))

        return ApiResponse(data = result)
    }
}
