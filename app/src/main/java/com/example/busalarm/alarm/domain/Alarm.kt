package com.example.busalarm.alarm.domain

import java.time.LocalTime

data class Alarm(
    val name: String = "",
    val time: LocalTime = LocalTime.now(),
    val destination: String = ""
)
