package com.url.urlzip.mongodb.shorturl

import org.springframework.data.mongodb.repository.MongoRepository

interface ShortUrlRepository : MongoRepository<ShortUrl, String> {

    fun findByRealUrl(realUrl: String): ShortUrl?
}
