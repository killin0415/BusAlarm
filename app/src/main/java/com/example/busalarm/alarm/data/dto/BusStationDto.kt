package com.example.busalarm.alarm.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BusStationDto(
    @SerialName("Direction") val direction: Int = 0,
    @SerialName("OperatorID") val operatorID: String = "",
    @SerialName("RouteID") val routeID: String = "",
    @SerialName("RouteName") val routeName: Language = Language(),
    @SerialName("RouteUID") val routeUID: String = "",
    @SerialName("SubRouteID") val subRouteID: String = "",
    @SerialName("SubRouteName") val subRouteName: Language,
    @SerialName("SubRouteUID") val subRouteUID: String = "",
    @SerialName("Timetables") val timetables: List<Timetable> = emptyList(),
    @SerialName("UpdateTime") val updateTime: String = "",
    @SerialName("VersionID") val versionID: Int = 0
)

@Serializable
data class Language(
    @SerialName("En") val en: String = "",
    @SerialName("Zh_tw") val zhTw: String = ""
)

@Serializable
data class Timetable(
    @SerialName("ServiceDay") val serviceDay: ServiceDay = ServiceDay(),
    @SerialName("StopTimes") val stopTimes: List<StopTime> = emptyList()
)

@Serializable
data class ServiceDay(
    @SerialName("Friday") val friday: Int = 0,
    @SerialName("Monday") val monday: Int = 0,
    @SerialName("Saturday") val saturday: Int = 0,
    @SerialName("NationalHolidays") val nationalHolidays: Int = 0,
    @SerialName("Sunday") val sunday: Int = 0,
    @SerialName("Thursday") val thursday: Int = 0,
    @SerialName("Tuesday") val tuesday: Int = 0,
    @SerialName("Wednesday") val wednesday: Int = 0
)

@Serializable
data class StopTime(
    @SerialName("ArrivalTime") val arrivalTime: String = "",
    @SerialName("DepartureTime") val departureTime: String = "",
    @SerialName("StopID") val stopID: String = "",
    @SerialName("StopName") val stopName: Language = Language(),
    @SerialName("StopSequence") val stopSequence: Int = 0,
    @SerialName("StopUID") val stopUID: String = ""
)
