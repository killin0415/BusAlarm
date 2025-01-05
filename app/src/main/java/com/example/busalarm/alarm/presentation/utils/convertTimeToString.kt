package com.example.busalarm.alarm.presentation.utils

import java.time.LocalTime

fun convertTimeToString(time: LocalTime): String {
    return "${time.hour}:${time.minute}"
}