package com.odeniz.learnconnect.util

import android.content.Context
import android.content.Intent
import android.net.Uri

object LinkUtils {

    fun getYouTubeVideoId(url: String): String? {
        val regex = "v=([a-zA-Z0-9_-]+)".toRegex()
        val matchResult = regex.find(url)
        return matchResult?.groups?.get(1)?.value
    }

    fun openUrl(context: Context) {
        val url = "https://policies.google.com/privacy?hl=en-US"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }
}