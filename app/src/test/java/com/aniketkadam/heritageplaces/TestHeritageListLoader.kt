package com.aniketkadam.heritageplaces

import com.aniketkadam.heritageplaces.data.HeritagePlace
import com.aniketkadam.heritageplaces.data.getTextFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TestHeritageListLoader : IHeritageListLoader {
    private val heritageListType = object : TypeToken<List<HeritagePlace>?>() {}.type

    override val data =
        getTextFromAsset("real.planet.world-heritage.json")
            .let { Gson().fromJson<List<HeritagePlace>>(it, heritageListType) }


}