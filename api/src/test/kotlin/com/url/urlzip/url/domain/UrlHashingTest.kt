package com.url.urlzip.url.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class UrlHashingTest {
    val urlHashing = UrlHashing()

    @Test
    fun `해시 테스트 같은 데이터`() {
        val testData = "qwer"
        val compareData = "qwer"

        val hashedTestData = urlHashing.hash(testData)
        val hashedCompareData = urlHashing.hash(compareData)

        hashedTestData shouldBe hashedCompareData
    }

    @Test
    fun `해시 테스트 다른 데이터`() {
        val testData = "qwer"
        val compareData = "qweㄷr"

        val hashedTestData = urlHashing.hash(testData)
        val hashedCompareData = urlHashing.hash(compareData)

        hashedTestData shouldNotBe hashedCompareData
    }
}
