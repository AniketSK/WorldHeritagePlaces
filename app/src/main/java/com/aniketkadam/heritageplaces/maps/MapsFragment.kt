package com.aniketkadam.heritageplaces.maps

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : SupportMapFragment(), OnMapReadyCallback {

    private val args by navArgs<MapsFragmentArgs>()

    override fun onActivityCreated(p0: Bundle?) {
        super.onActivityCreated(p0)
        getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val place = args.heritagePlace

        val mapsLocation = LatLng(place.location.lat, place.location.lng)

        googleMap.addMarker(MarkerOptions().position(mapsLocation).title(place.name))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(mapsLocation))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(19f)) // Zoom in a bit, range from out(2), to in(21)
    }

}