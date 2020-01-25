package com.aniketkadam.heritageplaces

import android.content.res.AssetManager
import com.aniketkadam.heritageplaces.data.HeritagePlace
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeritageListLoader(assetManager: AssetManager, gson: Gson) : IHeritageListLoader {
    private val heritageListType = object : TypeToken<List<HeritagePlace>?>() {}.type

    override val data by lazy {
        assetManager.open("real.planet.world-heritage.json").bufferedReader().readText()
            .let { gson.fromJson<List<HeritagePlace>>(it, heritageListType) }
    }

}