package com.url.urlzip.url

import javax.validation.constraints.NotBlank

data class PostUrlRequest(
    @field:NotBlank(message = "url은 null일 수 없습니다.")
    val url: String?
)
