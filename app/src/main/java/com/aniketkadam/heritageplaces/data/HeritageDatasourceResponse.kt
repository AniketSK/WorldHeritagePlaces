package com.aniketkadam.heritageplaces.data

import com.google.gson.annotations.SerializedName

data class HeritageDatasourceResponse(
    private @SerializedName("id") val id: Int,
    private @SerializedName("name") val name: String,
    private @SerializedName("image") val image: String,
    private @SerializedName("shortInfo") val shortInfo: String,
    private @SerializedName("lng") val lng: Double,
    private @SerializedName("lat") val lat: Double
) {
    fun getHeritagePlace() = HeritagePlace(
        id,
        name,
        image,
        shortInfo,
        Location(lat, lng)
    )
}