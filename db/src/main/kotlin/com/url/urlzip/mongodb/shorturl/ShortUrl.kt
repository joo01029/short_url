package com.url.urlzip.mongodb.shorturl

import org.springframework.data.annotation.Id

class ShortUrl(
    @Id
    val shortUrl: String,
    val realUrl: String
)
