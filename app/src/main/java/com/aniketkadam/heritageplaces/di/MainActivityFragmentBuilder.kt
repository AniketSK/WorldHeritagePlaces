package com.aniketkadam.heritageplaces.di

import com.aniketkadam.heritageplaces.heritageplacelist.HeritageList
import com.aniketkadam.heritageplaces.loadingscreen.LoadingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilder {

    @ContributesAndroidInjector
    abstract fun bindLoadingFragment(): LoadingFragment

    @ContributesAndroidInjector
    abstract fun bindHeritageListFragment(): HeritageList
}