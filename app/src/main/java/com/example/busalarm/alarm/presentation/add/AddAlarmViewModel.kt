package com.example.busalarm.alarm.presentation.add

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddAlarmViewModel: ViewModel() {
    private val _state = MutableStateFlow(AddAlermState())
    val state = _state.asStateFlow()

    fun onAction(action: AddAction) {
        when(action) {
            AddAction.onDeleteClick -> TODO()
            AddAction.onDoneClick -> TODO()
            is AddAction.onDestinationChange -> TODO()
            is AddAction.onNameChange -> TODO()
            is AddAction.onTimeChange -> TODO()
        }
    }
}
