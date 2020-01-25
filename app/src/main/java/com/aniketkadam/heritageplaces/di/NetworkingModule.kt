package com.aniketkadam.heritageplaces.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
object NetworkingModule {
    @JvmStatic
    @Provides
    fun provideGson(): Gson = Gson()
}