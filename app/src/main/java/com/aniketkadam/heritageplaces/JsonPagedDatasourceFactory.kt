package com.aniketkadam.heritageplaces

import androidx.paging.DataSource
import com.aniketkadam.heritageplaces.data.HeritagePlace

class JsonPagedDatasourceFactory(heritageListLoader: HeritageListLoader) :
    DataSource.Factory<Int, HeritagePlace>() {
    private val source by lazy {
        JsonPagedDataSource(heritageListLoader)
    }

    override fun create(): DataSource<Int, HeritagePlace> = source
}