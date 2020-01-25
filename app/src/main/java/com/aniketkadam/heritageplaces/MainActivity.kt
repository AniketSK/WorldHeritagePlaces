package com.aniketkadam.heritageplaces

import android.os.Bundle
import com.aniketkadam.heritageplaces.di.MAINACTIVITY_VM
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    @field:Named(MAINACTIVITY_VM)
    lateinit var mainVm: MainVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
