package com.aniketkadam.heritageplaces.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    override fun inject(instance: DaggerApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}