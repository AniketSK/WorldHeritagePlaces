package com.aniketkadam.heritageplaces.maps

import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MapsFragment : SupportMapFragment(), OnMapReadyCallback {

    override fun onActivityCreated(p0: Bundle?) {
        super.onActivityCreated(p0)
        getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        TODO("handle the marker showing up for the place")
    }

}