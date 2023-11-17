package com.example.buildingshop.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

fun ImageView.setImageUrl(url: String){
    Glide.with(context)
        .load(url)
        .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
        .into(this)
}