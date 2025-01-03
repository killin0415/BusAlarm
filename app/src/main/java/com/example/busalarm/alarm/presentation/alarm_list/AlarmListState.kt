package com.example.busalarm.alarm.presentation.alarm_list

import com.example.busalarm.alarm.domain.Alarm

data class AlarmListState(
    val alarms: List<Alarm> = emptyList()
)