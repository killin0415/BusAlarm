package com.example.busalarm.alarm.presentation.bus_list

import com.example.busalarm.alarm.domain.Alarm

sealed interface BusListAction {
    data class onAlarmClick(val alarm: Alarm): BusListAction
    data object onAddButtonClick: BusListAction
}