package com.example.busalarm.alarm.presentation.bus_list

import com.example.busalarm.alarm.domain.Alarm
import com.example.busalarm.alarm.domain.Bus

data class BusListState(
    val alarm: Alarm = Alarm(),
    val busList: Map<String, List<Bus>> = emptyMap()
)