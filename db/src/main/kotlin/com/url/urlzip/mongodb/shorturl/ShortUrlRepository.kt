package com.url.urlzip.mongodb.shorturl

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ShortUrlRepository : ReactiveMongoRepository<ShortUrl, String> {

    fun findByRealUrl(realUrl: String): ShortUrl?
}
