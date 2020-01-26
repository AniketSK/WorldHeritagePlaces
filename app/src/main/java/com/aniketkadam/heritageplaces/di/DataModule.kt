package com.aniketkadam.heritageplaces.di

import android.content.Context
import dagger.Module
import dagger.Provides
import java.io.InputStream
import javax.inject.Named

const val HERITAGE_PLACES_DATA = "heritage_places_data_inputstream"

@Module
object DataModule {
    @JvmStatic
    @Provides
    @Named(HERITAGE_PLACES_DATA)
    fun provideDataInputStream(context: Context): InputStream =
        context.assets.open("real.planet.world-heritage.json")

}