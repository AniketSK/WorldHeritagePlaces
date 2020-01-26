package com.aniketkadam.heritageplaces.databindinghelpers

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.aniketkadam.heritageplaces.R
import com.bumptech.glide.Glide

object ImageBinder {

    private fun getSpinner(context: Context) = CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }

    @JvmStatic
    @BindingAdapter("glideSrc")
    fun setImageUrl(view: ImageView, glideSrc: String) {
        Glide.with(view.context)
            .load(glideSrc)
            .error(R.drawable.broken_image)
            .placeholder(getSpinner(view.context))
            .into(view)
    }
}