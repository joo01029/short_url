package com.url.urlzip.url.domain

import java.util.regex.Pattern

@JvmInline
value class Url(
    val url: String
) {
    init {
        val isMatching = Pattern.compile("^https?:\\/\\/(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$")
            .matcher(url)
            .find()

        if (!isMatching) {
            throw IllegalArgumentException("we received unValid url : $url")
        }
    }
}
