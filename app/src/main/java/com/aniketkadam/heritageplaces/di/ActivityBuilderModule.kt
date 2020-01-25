package com.aniketkadam.heritageplaces.di

import com.aniketkadam.heritageplaces.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainActivityFragmentBuilder::class])
    abstract fun getMainActivity(): MainActivity

}