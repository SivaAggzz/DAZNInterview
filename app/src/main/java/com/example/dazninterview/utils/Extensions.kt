package com.example.dazninterview.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.dazninterview.R

fun ImageView.loadImageWithPlaceholder(url:String){
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.outline_image_24)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                scaleType=ImageView.ScaleType.CENTER_INSIDE
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: com.bumptech.glide.load.DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                scaleType=ImageView.ScaleType.CENTER_CROP
                return false
            }

        })
        .into(this)
}

fun ImageView.loadImage(url:String){
    Glide.with(context)
        .load(url)
        .into(this)
}


fun String.toast(context: Context){
    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}