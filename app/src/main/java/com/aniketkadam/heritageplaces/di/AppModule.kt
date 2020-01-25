package com.aniketkadam.heritageplaces.di

import android.app.Application
import android.content.Context
import com.aniketkadam.heritageplaces.HeritageListLoader
import com.aniketkadam.heritageplaces.IHeritageListLoader
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    internal abstract fun provideContext(application: Application): Context

    @Binds
    internal abstract fun bindHolder(heritageListLoader: HeritageListLoader): IHeritageListLoader

}