package com.aniketkadam.heritageplaces

import android.content.Context
import com.aniketkadam.heritageplaces.data.HeritagePlace
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class HeritageListLoader @Inject constructor(context: Context, gson: Gson) : IHeritageListLoader {
    private val heritageListType = object : TypeToken<List<HeritagePlace>?>() {}.type

    override val data by lazy {
        context.assets.open("real.planet.world-heritage.json").bufferedReader().readText()
            .let { gson.fromJson<List<HeritagePlace>>(it, heritageListType) }
    }

}