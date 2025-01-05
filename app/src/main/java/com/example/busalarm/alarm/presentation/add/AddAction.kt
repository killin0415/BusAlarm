package com.example.busalarm.alarm.presentation.add

import com.example.busalarm.alarm.domain.Alarm
import java.time.LocalTime

sealed interface AddAction {
    data class onDeleteClick(val alarmName: String): AddAction
    data class onDoneClick(val alarmName: String): AddAction
    data class onNameChange(val name: String): AddAction
    data class onTimeChange(val time: LocalTime): AddAction
    data class onDestinationChange(val destination: String): AddAction

}