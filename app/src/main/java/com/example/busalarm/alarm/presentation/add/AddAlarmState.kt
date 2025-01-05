package com.example.busalarm.alarm.presentation.add

import com.example.busalarm.alarm.domain.Alarm
import java.time.LocalTime

data class AddAlarmState(
    val nameInp: String = "",
    val timeInp: LocalTime = LocalTime.now(),
    val destinationInp: String = "",
    val alarm: Alarm = Alarm(),
    val isNew: Boolean = true
)
