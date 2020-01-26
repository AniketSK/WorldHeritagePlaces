package com.aniketkadam.heritageplaces.data

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val lat: Double,
    val lng: Double
)