package com.url.urlzip.url.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class UrlTest {
    @Test
    fun `url valueClass init validate 정상 작동 확인 성공케이스 구글 url`() {
        val testUrl = "https://google.com"

        val url = Url(testUrl)

        url.url shouldBe testUrl
    }

    @Test
    fun `url valueClass init validate 정상 작동 확인 실패케이스 http 가 없는 경우`() {
        val testUrl = "google.com"

        try {
            val url = Url(testUrl)
        } catch (e: Exception) {
            e.printStackTrace()
            e.message shouldBe "we received unValid url : $testUrl"
        }
    }

    @Test
    fun `url valueClass init validate 정상 작동 확인 실패케이스 point이 없는 경우`() {
        val testUrl = "https://googlecom"

        try {
            val url = Url(testUrl)
        } catch (e: Exception) {
            e.printStackTrace()
            e.message shouldBe "we received unValid url : $testUrl"
        }
    }
}
