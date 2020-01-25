package com.aniketkadam.heritageplaces.loadingscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aniketkadam.heritageplaces.R
import dagger.android.support.DaggerFragment

class LoadingFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_loading, container, false)
    }
}