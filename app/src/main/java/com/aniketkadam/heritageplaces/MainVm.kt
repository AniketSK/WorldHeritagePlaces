package com.aniketkadam.heritageplaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aniketkadam.heritageplaces.data.HeritagePlace

class MainVm(repository: HeritagePlaceRepository) : ViewModel() {

    private val _viewState: MutableLiveData<ScreenLce> = MutableLiveData(ScreenLce.Loading)

    val viewState: LiveData<ScreenLce> = _viewState

    init {
        _viewState.postValue(ScreenLce.HeritageListScreen(repository.getHeritagePlacesPagedAdapter()))
    }

    fun openMapForPlace(place: HeritagePlace) = _viewState.postValue(ScreenLce.MapsMarker(place))
}

sealed class ScreenLce {
    object Loading : ScreenLce()
    object Error : ScreenLce()
    data class HeritageListScreen(val heritagePagedList: LiveData<PagedList<HeritagePlace>>) :
        ScreenLce()
    data class MapsMarker(val heritagePlace: HeritagePlace) : ScreenLce()
}