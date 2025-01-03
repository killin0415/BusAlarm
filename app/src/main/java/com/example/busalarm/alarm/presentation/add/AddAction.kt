package com.example.busalarm.alarm.presentation.add

import java.time.LocalTime

sealed interface AddAction {
    object onDeleteClick: AddAction
    object onDoneClick: AddAction
    data class onNameChange(val name: String): AddAction
    data class onTimeChange(val time: LocalTime): AddAction
    data class onDestinationChange(val destination: String): AddAction

}