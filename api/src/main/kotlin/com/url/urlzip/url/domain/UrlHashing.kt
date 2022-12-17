package com.url.urlzip.url.domain

import org.springframework.stereotype.Component
import org.springframework.util.Base64Utils
import java.security.DigestException
import java.security.MessageDigest

@Component
class UrlHashing {
    fun hash(url: String): String {
        val hashData: ByteArray
        try {
            val md = MessageDigest.getInstance("SHA-256")
            md.update(url.toByteArray())
            hashData = md.digest()
        } catch (e: CloneNotSupportedException) {
            throw DigestException("couldn't make digest of patial content")
        }
        return Base64Utils.encodeToUrlSafeString(hashData)
    }
}
