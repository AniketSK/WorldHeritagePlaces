package com.aniketkadam.heritageplaces.heritageplacelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aniketkadam.heritageplaces.MainVm
import com.aniketkadam.heritageplaces.R
import com.aniketkadam.heritageplaces.di.MAINACTIVITY_FRAGMENT_VM
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named

class HeritageList : DaggerFragment() {

    @Inject
    @field:Named(MAINACTIVITY_FRAGMENT_VM)
    lateinit var mainVm: MainVm

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_heritage_list, container, false)
    }
}