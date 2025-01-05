package com.example.busalarm.alarm.presentation

import com.example.busalarm.alarm.domain.Alarm

data class SharedState(
    val alarms: List<Alarm> = emptyList()
)