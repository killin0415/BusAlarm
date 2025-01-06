package com.example.busalarm.alarm.presentation.add

import com.example.busalarm.alarm.domain.Alarm
import java.time.LocalTime

data class AddAlarmState(
    val nameInp: String = "起床",
    val timeInp: LocalTime = LocalTime.of(13, 30),
    val destinationInp: String = "有吉可樂",
    val alarm: Alarm = Alarm(),
    val isNew: Boolean = true
)
