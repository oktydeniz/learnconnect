package com.odeniz.learnconnect.util

object LinkUtils {

    fun getYouTubeVideoId(url: String): String? {
        val regex = "v=([a-zA-Z0-9_-]+)".toRegex()
        val matchResult = regex.find(url)
        return matchResult?.groups?.get(1)?.value
    }
}