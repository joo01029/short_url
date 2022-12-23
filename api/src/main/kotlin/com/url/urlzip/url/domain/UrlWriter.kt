package com.url.urlzip.url.domain

import com.url.urlzip.mongodb.shorturl.ShortUrl
import com.url.urlzip.mongodb.shorturl.ShortUrlRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class UrlWriter(
    private val shortUrlRepository: ShortUrlRepository,
    @Value("\${this.server.address}")
    private val serverAddress: String
) {

    private val log = LoggerFactory.getLogger(javaClass)
    fun save(hashedUrl: String, url: Url): String {
        val shortUrl = serverAddress + hashedUrl

        log.info(
            """
            shortUrl : $shortUrl
            realUrl : $url
            """.trimIndent()
        )
        val shortUrlData = ShortUrl(
            shortUrl = shortUrl,
            realUrl = url.url
        )

        return shortUrlRepository.save(shortUrlData).shortUrl
    }
}
