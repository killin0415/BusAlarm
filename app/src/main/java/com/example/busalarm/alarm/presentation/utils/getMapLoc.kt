package com.example.busalarm.alarm.presentation.utils

import android.location.Geocoder
import com.google.android.gms.maps.model.LatLng

private fun searchLocation(locationName: String, geocoder: Geocoder): LatLng? {
    try {
        val addressList = geocoder.getFromLocationName(locationName, 1)
        if(addressList.isNullOrEmpty()) return null
        val address = addressList[0]
        val latLng = LatLng(address.latitude, address.longitude)
        return latLng
    } catch (e: Exception) {
        e.printStackTrace()
        return null
    }
}