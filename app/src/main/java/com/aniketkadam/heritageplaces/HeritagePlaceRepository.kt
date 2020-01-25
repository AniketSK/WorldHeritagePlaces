package com.aniketkadam.heritageplaces

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aniketkadam.heritageplaces.data.HeritagePlace
import javax.inject.Inject

class HeritagePlaceRepository @Inject constructor(private val heritageListLoader: IHeritageListLoader) {
    private val PAGE_SIZE = 20
    private val PREFETCH_DISTANCE = PAGE_SIZE

    fun getHeritagePlacesPagedAdapter(): LiveData<PagedList<HeritagePlace>> {

        val localSource = JsonPagedDatasourceFactory(heritageListLoader)

        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setMaxSize(PAGE_SIZE + 2 * PREFETCH_DISTANCE) // The recommended default
            .build()

        return LivePagedListBuilder(localSource, config).build()
    }
}