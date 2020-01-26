package com.aniketkadam.heritageplaces.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeritagePlace(
    val id: Int,
    val name: String,
    val image: String,
    val shortInfo: String,
    val location: Location
) : Parcelable