package com.url.urlzip.url.domain

import io.seruco.encoding.base62.Base62
import org.springframework.stereotype.Component
import java.nio.ByteBuffer
import java.security.DigestException
import java.util.zip.CRC32

@Component
class UrlHashing {
    private val base62 = Base62.createInstanceWithInvertedCharacterSet()
    fun hash(url: String): String {
        val hashData: Long
        try {
            val hashAlgorithm = CRC32()
            hashAlgorithm.update(url.toByteArray())
            hashData = hashAlgorithm.value
        } catch (e: CloneNotSupportedException) {
            throw DigestException("couldn't make digest of patial content")
        }
        return String(base62.encode(hashData.toByteArray()))
    }

    fun Long.toByteArray(): ByteArray {
        val byteBuffer = ByteBuffer.allocate(Long.SIZE_BYTES)
        try {
            byteBuffer.putLong(this)
            return byteBuffer.array()
        } finally {
            byteBuffer.clear()
        }
    }
}
