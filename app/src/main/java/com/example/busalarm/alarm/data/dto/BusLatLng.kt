package com.example.busalarm.alarm.data.dto

data class BusLatLngDto(
    val AuthorityCode: String,
    val SrcUpdateInterval: Int,
    val SrcUpdateTime: String,
    val Stops: List<Stop>,
    val UpdateInterval: Int,
    val UpdateTime: String,
    val VersionID: Int
)

data class Stop(
    val Bearing: String,
    val CityCode: String,
    val RoadName: String,
    val StationID: String,
    val StationUID: String,
    val StopAddress: String,
    val StopID: String,
    val StopName: StopName,
    val StopPosition: StopPosition,
    val StopUID: String
)

data class StopName(
    val En: String,
    val Zh_tw: String
)

data class StopPosition(
    val PositionLat: Double,
    val PositionLon: Double
)