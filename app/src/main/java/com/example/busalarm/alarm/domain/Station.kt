package com.example.busalarm.alarm.domain

import java.time.LocalTime

data class Station(
    val id: String,
    val stationName: String,
    val arriveTime: LocalTime
)
