package com.aniketkadam.heritageplaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainVm(repository: HeritagePlaceRepository) : ViewModel() {

    private val _viewState: MutableLiveData<ScreenLce> = MutableLiveData(ScreenLce.Loading)

    val viewState: LiveData<ScreenLce> = _viewState


}

sealed class ScreenLce {
    object Loading : ScreenLce()
    object Error : ScreenLce()
}