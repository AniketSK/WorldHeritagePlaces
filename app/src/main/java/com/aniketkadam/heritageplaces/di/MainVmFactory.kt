package com.aniketkadam.heritageplaces.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aniketkadam.heritageplaces.HeritagePlaceRepository
import com.aniketkadam.heritageplaces.MainVm
import javax.inject.Inject

class MainVmFactory @Inject constructor(private val repository: HeritagePlaceRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = with(modelClass) {
        when {
            isAssignableFrom(MainVm::class.java) -> MainVm(repository)
            else -> throw IllegalArgumentException("${modelClass.name} is not a known viewmodel to ${MainVmFactory::class.java.name}")
        }
    } as T
}