package com.odeniz.learnconnect.util

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.odeniz.learnconnect.R

@BindingAdapter("imageUri")
fun bindImage(imageView: ImageView, imageUri: Bitmap?) {
    if (imageUri != null) {
        imageView.setImageBitmap(imageUri)
    } else {
        imageView.setImageResource(R.drawable.profile_img)
    }
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    } else {
        imageView.setImageResource(R.drawable.ic_launcher_background)
    }
}