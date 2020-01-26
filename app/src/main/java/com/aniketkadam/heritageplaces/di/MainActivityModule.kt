package com.aniketkadam.heritageplaces.di

import androidx.lifecycle.ViewModelProviders
import com.aniketkadam.heritageplaces.MainActivity
import com.aniketkadam.heritageplaces.MainVm
import dagger.Module
import dagger.Provides
import javax.inject.Named

const val MAINACTIVITY_VM = "main_activity_vm"
const val MAINACTIVITY_FRAGMENT_VM = "main_activity_fragment_vm"

@Module
object MainActivityModule {

    @JvmStatic
    @Provides
    @Named(MAINACTIVITY_VM)
    fun provideVm(mainActivity: MainActivity, factory: MainVmFactory): MainVm =
        ViewModelProviders.of(mainActivity, factory).get(MainVm::class.java)

    @JvmStatic
    @Provides
    @Named(MAINACTIVITY_FRAGMENT_VM)
    fun provideFragmentVm(mainActivity: MainActivity): MainVm =
        ViewModelProviders.of(mainActivity).get(MainVm::class.java)

}