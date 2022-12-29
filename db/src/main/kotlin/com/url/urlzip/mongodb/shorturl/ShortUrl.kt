package com.url.urlzip.mongodb.shorturl

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class ShortUrl {
    @Id
    @Column(nullable = false)
    var shortUrl: String? = null
    @Column(nullable = false)
    var realUrl: String? = null

    constructor(shortUrl: String, realUrl: String) {
        this.shortUrl = shortUrl
        this.realUrl = realUrl
    }

    constructor() {
    }
}
