package com.aniketkadam.heritageplaces

import com.aniketkadam.heritageplaces.data.HeritageDatasourceResponse
import com.aniketkadam.heritageplaces.di.HERITAGE_PLACES_DATA
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Named

class HeritageListLoader @Inject constructor(
    @Named(HERITAGE_PLACES_DATA) dataInputStream: InputStream, gson: Gson
) : IHeritageListLoader {
    private val heritageListType = object : TypeToken<List<HeritageDatasourceResponse>?>() {}.type

    override val data by lazy {
        dataInputStream.bufferedReader().readText()
            .let { gson.fromJson<List<HeritageDatasourceResponse>>(it, heritageListType) }
            .map { it.getHeritagePlace() }
    }

}