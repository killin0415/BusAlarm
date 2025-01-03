package com.example.busalarm.alarm.presentation.alarm_list

import com.example.busalarm.alarm.domain.Alarm

sealed interface AlarmListAction {
    data class onAlarmClick(val alarm: Alarm): AlarmListAction
    data object onAddButtonClick: AlarmListAction
}