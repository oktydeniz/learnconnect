package com.odeniz.learnconnect.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtil {
    fun getEnrollmentDate(): String {
        val currentDate = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val formattedDate = formatter.format(currentDate)
        return formattedDate
    }

    fun formatDurationWithoutSeconds(totalSeconds: Int): String {
        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60

        val result = StringBuilder()
        if (hours > 0) result.append("${hours}H ")
        if (minutes > 0 || result.isEmpty()) result.append("${minutes}M")

        return result.toString().trim()
    }
}


