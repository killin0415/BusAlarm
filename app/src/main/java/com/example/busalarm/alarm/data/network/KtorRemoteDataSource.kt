package com.example.busalarm.alarm.data.network

import com.example.busalarm.alarm.data.dto.BusStationDto
import com.example.busalarm.core.data.safeCall
import com.example.busalarm.core.domain.DataError
import com.example.busalarm.core.domain.Result
import com.google.android.gms.maps.model.LatLng
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

private val BASE_LAT_LNG_URL = "https://tdx.transportdata.tw/api/basic/v3/Bus/Stop/City/Tainan"
private val BASE_SCHEDULE_URL = "https://tdx.transportdata.tw/api/basic/v2/Bus/Schedule/City/Tainan"

class KtorRemoteDataSource(
    private val httpClient: HttpClient
) : RemoteDataSource {
    override suspend fun searchStation(
        query: String,
        curLoc: LatLng,
        des: LatLng,
        radius: Int,
        limits: Int?
    ) : Result<BusStationDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "$BASE_SCHEDULE_URL/$query"
            ) {
                parameter("\$top", limits)
                parameter("\$format", "JSON")
            }
        }
    }
}