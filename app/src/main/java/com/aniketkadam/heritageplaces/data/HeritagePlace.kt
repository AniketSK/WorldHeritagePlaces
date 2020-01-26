package com.aniketkadam.heritageplaces.data

import kotlinx.serialization.Serializable

@Serializable
data class HeritagePlace(
    val id: Int,
    val name: String,
    val image: String,
    val shortInfo: String,
    val location: Location
)