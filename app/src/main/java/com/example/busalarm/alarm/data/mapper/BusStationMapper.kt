package com.example.busalarm.alarm.data.mapper

import com.example.busalarm.alarm.data.dto.BusStationDto
import com.example.busalarm.alarm.domain.Bus
import com.example.busalarm.alarm.domain.Station
import java.time.LocalTime

fun BusStationDto.toBus(
    startStaion: String,
    destination: String
) : Bus {
    val stations = this.timetables
        .map { it.stopTimes }.associate {
            it[0].stopName.zhTw to it.map { station ->
                station.arrivalTime
            }
        }

}