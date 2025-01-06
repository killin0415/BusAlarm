package com.example.busalarm.alarm.data.network

import com.example.busalarm.alarm.data.dto.BusStationDto
import com.example.busalarm.core.domain.DataError
import com.example.busalarm.core.domain.Result
import com.google.android.gms.maps.model.LatLng

interface RemoteDataSource {
    suspend fun searchStation(
        query: String,
        curLoc: LatLng,
        des: LatLng,
        radius: Int = 500,
        limits: Int? = null
    ) : Result<BusStationDto, DataError.Remote>
}