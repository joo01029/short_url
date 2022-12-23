package com.url.urlzip.url.domain

import com.url.urlzip.mongodb.shorturl.ShortUrlRepository
import org.springframework.stereotype.Component

@Component
class UrlReader(
    private val shortUrlRepository: ShortUrlRepository
) {
    fun read(url: Url) = shortUrlRepository.findByRealUrl(url.url)?.shortUrl
}
