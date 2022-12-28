package com.url.urlzip.mongodb.shorturl

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest

@DataMongoTest
class ShortUrlRepositoryTest @Autowired private constructor(
    private val shortUrlRepository: ShortUrlRepository
) {

    @Test
    fun `데이터 저장후 realUrl로 데이터를 받아올 수 있는지 테스트`() {
        val realUrl = "https://qqqq.qqq"
        val sampleData = ShortUrl(
            shortUrl = "qwer",
            realUrl = realUrl
        )

        shortUrlRepository.save(sampleData)

        val savedData = shortUrlRepository.findByRealUrl(realUrl)

        sampleData.shortUrl shouldBe savedData!!.shortUrl
    }
}
