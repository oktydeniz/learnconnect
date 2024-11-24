package com.odeniz.learnconnect.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.odeniz.learnconnect.R

@BindingAdapter("formattedRatingCount")
fun bindFormattedRatingCount(textView: TextView, ratingCount: Int) {
    val formattedText = "(${ratingCount})"
    textView.text = formattedText
}