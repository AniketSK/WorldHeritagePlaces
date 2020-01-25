package com.aniketkadam.heritageplaces.databindinghelpers

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageBinder {

    @JvmStatic
    @BindingAdapter("glideSrc")
    fun setImageUrl(view: ImageView, glideSrc: String) {
        Glide.with(view.context).load(glideSrc).into(view)
    }
}