package com.example.busalarm.alarm.presentation.utils

import java.time.LocalTime

fun convertTimeToString(time: LocalTime): String {
    return "${time.hour}:${time.minute}"
}

fun convertIntToTimeString(time: Int) : String {
    return "%02d:%02d".format(time/3600, time%3600/60)
}

fun convertToMin(time: Int) : String {
    return "${time/60} min"
}
