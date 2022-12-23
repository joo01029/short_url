package com.url.urlzip.url.domain

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UrlService(
    private val urlReader: UrlReader,
    private val urlHashing: UrlHashing,
    private val urlWriter: UrlWriter
) {
    private val log = LoggerFactory.getLogger(javaClass)
    fun saveUrl(url: Url): String {

        // find
        val shortUrl = urlReader.read(url)

        return if (shortUrl != null) {
            log.info("$url already exist")

            shortUrl
        } else {
            val hashedUrl = urlHashing.hash(url.url)

            log.info(
                """
                    
                hashedUrl : $hashedUrl
                realUrl : $url
                """.trimIndent()
            )

            urlWriter.save(
                hashedUrl = hashedUrl,
                url = url
            )
        }
    }
}
