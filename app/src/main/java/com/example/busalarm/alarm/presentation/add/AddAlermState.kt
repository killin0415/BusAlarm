package com.example.busalarm.alarm.presentation.add

import java.time.LocalTime

data class AddAlermState(
    val nameInp: String = "",
    val timeInp: LocalTime = LocalTime.now(),
    val destinationInp: String = ""
)
