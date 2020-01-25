package com.aniketkadam.heritageplaces

import com.aniketkadam.heritageplaces.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class HeritagePlacesApplication : DaggerApplication() {

    private val appInjector by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appInjector

}