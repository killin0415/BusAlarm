package com.example.busalarm.alarm.presentation.bus_list

import com.example.busalarm.alarm.domain.Alarm
import com.example.busalarm.alarm.domain.Bus

data class BusListState(
    val busList: List<Bus> = emptyList()
)