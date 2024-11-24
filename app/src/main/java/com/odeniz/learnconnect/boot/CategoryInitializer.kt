package com.odeniz.learnconnect.boot

import android.content.Context
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.entity.Category
import com.odeniz.learnconnect.local.AppDatabase

object CategoryInitializer {
    fun initializeCategories(context: Context, database: AppDatabase) {
        val categories = listOf(
            Category(categoryName = context.getString(R.string.software), slug = "software"),
            Category(categoryName = context.getString(R.string.economy), slug = "economy"),
            Category(categoryName = context.getString(R.string.health), slug = "health"),
            Category(categoryName = context.getString(R.string.personal_development), slug = "personal-development"),
            Category(categoryName = context.getString(R.string.music), slug = "music"),
            Category(categoryName = context.getString(R.string.art), slug = "art"),
            Category(categoryName = context.getString(R.string.sports), slug = "sports"),
            Category(categoryName = context.getString(R.string.education), slug = "education"),
            Category(categoryName = context.getString(R.string.travel), slug = "travel"),
            Category(categoryName = context.getString(R.string.technology), slug = "technology")
        )
        database.categoryDao().insertAll(categories)
    }
}