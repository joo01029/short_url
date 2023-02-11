package com.url.urlzip.mongodb.shorturl

import org.springframework.data.jpa.repository.JpaRepository

interface ShortUrlRepository : JpaRepository<ShortUrl, String> {

    fun findByRealUrl(realUrl: String): ShortUrl?
}
