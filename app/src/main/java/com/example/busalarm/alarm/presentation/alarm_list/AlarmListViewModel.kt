package com.example.busalarm.alarm.presentation.alarm_list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AlarmListViewModel : ViewModel() {
    private val _state = MutableStateFlow(AlarmListState())
    val state = _state.asStateFlow()

    fun onAction(action: AlarmListAction) {
        when (action) {
            is AlarmListAction.onAlarmClick -> {

            }
            is AlarmListAction.onAddButtonClick -> {

            }
        }
    }

}